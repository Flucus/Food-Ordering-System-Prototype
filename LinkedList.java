//Name: HO Cheuk Hin
//Class: IT114105/A
//Student ID: 220010839
//File Name: OrderSystem.java
//Description: This program is to create a food order system for a restaurant. The system will allow the user to input the member ID and the food order. The system will then display the order in the order of priority. 
//             The system will also allow the admin to view the order list and remove an order from the list.
class ListNode { // ListNode class

	private Object data; // Declare data variable
	private ListNode next; // Declare next variable

	public ListNode(Object o) { data = o; next = null; } // Constructor
	public ListNode(Object o, ListNode nextNode) // Constructor
		{ data = o; next = nextNode; } // Constructor

	public Object getData() { return data; } // Getter method
	public void setData(Object o) { data = o; } // Setter method
	
	public ListNode getNext() { return next; } // Getter method
	public void setNext(ListNode next) { this.next = next; } // Setter method


} // class ListNode

class EmptyListException extends RuntimeException { // EmptyListException class
	public EmptyListException () // Constructor
		{ super("List is empty"); }
} // class EmptyListException

public class LinkedList { // LinkedList class

	private ListNode head; // Declare head variable
	private ListNode tail; // Declare tail variable

	private int length;		// the length of the list

	public LinkedList() { // Constructor
		head = tail = null; // Initialize head and tail
		length = 0; // Initialize length
	}

	public boolean isEmpty() { return head == null; } // isEmpty method

	public void addToHead(Object item) { // addToHead method
		if (isEmpty()) // If the list is empty
			head = tail = new ListNode(item); // Create a new node
		else // If the list is not empty
			head = new ListNode(item, head); // Create a new node
		length++; // Increment length
	}

	public void addToTail(Object item) { // addToTail method
		if (isEmpty()) // If the list is empty
			head = tail = new ListNode(item); // Create a new node
		else { // If the list is not empty
			tail.setNext(new ListNode(item)); // Create a new node
			tail = tail.getNext(); // Set tail to the new node
		}
		length++; // Increment length
	}

	public Object removeFromHead() throws EmptyListException { // removeFromHead method
		Object item = null; // Declare item variable
		if (isEmpty()) // If the list is empty
			throw new EmptyListException(); // Throw an exception
		item = head.getData(); // Set item to the data of the head
		if (head == tail) // If the list has only one node
			head = tail = null; // Set head and tail to null
		else // If the list has more than one node
			head = head.getNext(); // Set head to the next node
		length--; // Decrement length
		return item; // Return item
	}

	public Object removeFromTail() throws EmptyListException { // removeFromTail method
		Object item = null; // Declare item variable
		if (isEmpty()) // If the list is empty
			throw new EmptyListException(); // Throw an exception
		item = tail.getData(); // Set item to the data of the tail
		if (head == tail) // If the list has only one node
			head = tail = null; // Set head and tail to null
		else { // If the list has more than one node
			ListNode current = head; // Declare current variable
			while (current.getNext() != tail) // While current is not the node before the tail
				current = current.getNext(); // Set current to the next node
			tail = current; // Set tail to current
			current.setNext(null); // Set the next node of current to null
		}
		length--; // Decrement length
		return item; // Return item
	}
	
	public int count() { // count method
		return length; // Return length
	}
	
	//students need to revise toString method
	public String toString() { // toString method
		String str = ""; // Declare str variable
		ListNode current = head; // Declare current variable
		if (isEmpty()){
            return "None of order \n";
        }
		while (current != null) { // While current is not null
			str = str + current.getData() + " \n"; // Set str to str plus the data of current plus a new line
			current = current.getNext(); // Set current to the next node
		}
		return str; // Return str
	}



	//to be completed ...
	// Method remove(int) is to remove a ListNode from the LinkedList with a specific Member ID
	public void remove(int targetID) throws EmptyListException { // remove method
		if (isEmpty()) { // If the list is empty
			throw new EmptyListException(); // Throw an exception
		}

		if (head.getData() instanceof FoodOrder && ((FoodOrder) head.getData()).getMemberID() == targetID) { // If the head is the target
			removeFromHead(); // Remove the head
			return;
		}

		ListNode current = head; // Declare current variable
		ListNode previous = null; // Declare previous variable

		while (current != null) { // While current is not null
			if (current.getData() instanceof FoodOrder && ((FoodOrder) current.getData()).getMemberID() == targetID) { // If current is the target
				if (current == tail) { // If current is the tail
					previous.setNext(null); // Set the next node of previous to null
					tail = previous; // Set tail to previous
				} else { // If current is not the tail
					previous.setNext(current.getNext()); // Set the next node of previous to the next node of current
				}
				length--; // Decrement length
				return; 
			}
			previous = current; // Set previous to current
			current = current.getNext(); // Set current to the next node
		}
	}

	//to be completed ...
    // Method add(Object) is to insert a new ListNode into the LinkedList in a correct position
	public void add(Object item) { // add method
		if (!(item instanceof FoodOrder)) { // If item is not a FoodOrder
			return; 
		}

		FoodOrder newOrder = (FoodOrder) item; // Declare newOrder variable

		if (isEmpty() || newOrder.getPriority() < ((FoodOrder) head.getData()).getPriority()) { // If the list is empty or the priority of newOrder is less than the priority of the head
			addToHead(item); // Add item to the head
			return;
		}

		ListNode current = head; // Declare current variable
		ListNode previous = null; // Declare previous variable

		while (current != null && newOrder.getPriority() >= ((FoodOrder) current.getData()).getPriority()) { // While current is not null and the priority of newOrder is greater than or equal to the priority of current
			previous = current; // Set previous to current
			current = current.getNext(); // Set current to the next node
		}

		ListNode newNode = new ListNode(item); // Declare newNode variable
		if (current == null) { // If current is null
			previous.setNext(newNode); // Set the next node of previous to newNode
			tail = newNode; // Set tail to newNode
		} else { // If current is not null
			newNode.setNext(current); // Set the next node of newNode to current
			previous.setNext(newNode); // Set the next node of previous to newNode
		}
		length++; // Increment length
	}


} // class LinkedList
