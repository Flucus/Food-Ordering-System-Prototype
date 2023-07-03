//Name: HO Cheuk Hin
//Class: IT114105/A
//Student ID: 220010839
//File Name: OrderSystem.java
//Description: This program is to create a food order system for a restaurant. The system will allow the user to input the member ID and the food order. The system will then display the order in the order of priority.
//             The system will also allow the admin to view the order list and remove an order from the list.
import java.util.*; // Import all classes in java.util package

public class OrderSystem { // Main class
	private static Scanner sc; // Scanner object
	private static LinkedList orders; // LinkedList object
	private static int nextGuestID = 9000; // Guest ID

	public static void main(String[] args) throws InvalidInputException { // Main method
		orders = new LinkedList(); // Create a new LinkedList object
		sc = new Scanner(System.in); // Create a new Scanner object

		while (true) { // Loop until user input -1
			try { // Try to execute the following code
				System.out.print("Please input your member ID [input 0 for guest]:"); // Prompt user to input member ID
				int memberID = sc.nextInt(); // Read user input
				sc.nextLine(); // Consume the newline character

				if (memberID <= -1) { // If user input less than 0, exit the program
					System.out.println("Have a nice day!!!"); // Display message
					break; // Exit the loop
				} else if (memberID == 9999) { // If user input 9999, call adminFunc() method
					adminFunc(); // Call adminFunc() method
				} else { // If user input other number, call inputOrder() method
					inputOrder(memberID); // Call inputOrder() method
				}
			} catch (InvalidInputException e) { // If user input invalid input, display error message
				System.out.println(e.getMessage()); // Display error message
			} catch (InputMismatchException e) { // If user input invalid input, display error message
				System.out.println("Input Error"); // Display error message
				break; // Exit the loop
			}
		}

		sc.close(); // Close the Scanner object
	}

	public static void inputOrder(int memberID) throws InvalidInputException { // inputOrder() method
		int priority; // Declare priority variable

		if (memberID == 0) { // If user input 0, assign priority to 3
			if (nextGuestID >= 9999) { // If nextGuestID is greater than 9999, display error message and exit the program
				System.out.println("Sorry, we have no more guest ID available."); // Display error message
				System.exit(0); // Exit the program
			}
			memberID = nextGuestID++; // Assign memberID to nextGuestID and increment nextGuestID by 1
			priority = 3; // Assign priority to 3
		} else if (memberID >= 8001 && memberID <= 8199) { // If user input 8001 to 8199, assign priority to 1
			priority = 1; // Assign priority to 1
		} else if (memberID >= 8200 && memberID <= 8999) { // If user input 8200 to 8999, assign priority to 2
			priority = 2; // Assign priority to 2
		} else { // If user input other number, display error message and exit the program
			throw new InvalidInputException(); // Throw InvalidInputException
		}

		System.out.println("----------------- Food Menu ----------------"); // Display food menu
		System.out.println("Set A : Chicken Salad"); 
		System.out.println("Set B : Grilled Ribeye Steak"); 
		System.out.println("Set C : Angel Hair Pasta with Shrimp"); 
		System.out.println("Set D : Grilled Fish and Potatoes"); 
		System.out.println("--------------------------------------------");

		System.out.print("Select food:"); // Prompt user to select food
		String food = sc.nextLine().toUpperCase(); // Read user input and convert to uppercase

		if (!food.equals("A") && !food.equals("B") && !food.equals("C") && !food.equals("D")) { // If user input other than A, B, C, D, display error message and exit the program
			throw new InvalidInputException(); // Throw InvalidInputException
		}

		orders.add(new FoodOrder(memberID, food, priority)); // Add new FoodOrder object to the LinkedList object
	}

	public static void adminFunc() throws EmptyListException { // adminFunc() method
		System.out.println("----------------- Admin Function ----------------"); // Display admin function menu
		System.out.println("1 : Print order list");
		System.out.println("2 : Remove order");
		System.out.print(">"); // Prompt user to select option

		int option = sc.nextInt(); // Read user input
		sc.nextLine(); // Consume the newline character

		if (option == 1) { // If user input 1, display order list
			System.out.println("--------------------------------------"); // Display order list
			System.out.print(orders.toString()); 
			System.out.println("--------------------------------------"); 
			System.out.println("Total outstanding order: " + orders.count()); // Display total outstanding order
		} else if (option == 2) { // If user input 2, remove order
			System.out.print("Enter Member ID: "); // Prompt user to input member ID
			int memberID = sc.nextInt(); // Read user input
			sc.nextLine(); // Consume the newline character

			try { // Try to execute the following code
				orders.remove(memberID); // Remove order
			} catch (EmptyListException e) { // If user input invalid input, display error message
				System.out.println("None of order"); // Display error message
			}
		}
	}
}

class InvalidInputException extends Exception { // InvalidInputException class
	public InvalidInputException() { // Constructor
		super("Invalid input! Please input again."); // Call super class constructor
	}
}