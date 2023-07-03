//Name: HO Cheuk Hin
//Class: IT114105/A
//Student ID: 220010839
//File Name: OrderSystem.java
//Description: This program is to create a food order system for a restaurant. The system will allow the user to input the member ID and the food order. The system will then display the order in the order of priority. 
//             The system will also allow the admin to view the order list and remove an order from the list.
public class FoodOrder { // FoodOrder class
    private int memberID; // 8001 - 8199 VIP member, 8200 - 8999 Registered member, 9000 - 9999 Guest
    private String foodOrder; // A, B, C, or D
    private int priority; // 1 - VIP member, 2 - Registered member, 3 - Guest

    // constructor
    public FoodOrder(int memberID, String foodOrder, int priority) {
        this.memberID = memberID; // Initialize memberID
        this.foodOrder = foodOrder; // Initialize foodOrder
        this.priority = priority; // Initialize priority

        if (memberID >= 8001 && memberID <= 8199) { // If memberID is between 8001 and 8199
            this.priority = 1; // VIP member
        } else if (memberID >= 8200 && memberID <= 8999) { // If memberID is between 8200 and 8999
            this.priority = 2; // Registered member
        } else { // If memberID is between 9000 and 9999
            this.priority = 3; // Guest
        }
    }

    // provide methods getter, setter, toString ....
    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getFoodOrder() {
        return foodOrder;
    }

    public void setFoodOrder(String foodOrder) {
        this.foodOrder = foodOrder;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String toString() {
        return "[MemberID: " + memberID + " ordered Set " + foodOrder + " with Priority " + priority + "]";
    }
}