import java.util.Scanner;

public class PizzaBillingSystem {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int bill = 0;
        String size;

        while (true) {
            System.out.print("Enter pizza size (small/medium/large): ");
            size = input.nextLine().toLowerCase();

            if (size.equals("small")) {
                bill = 100;
                break;
            } else if (size.equals("medium")) {
                bill = 200;
                break;
            } else if (size.equals("large")) {
                bill = 300;
                break;
            } else {
                System.out.println("Invalid size! Please try again.\n");
            }
        }

        while (true) {
            System.out.print("Do you want pepperoni? (yes/no): ");
            String pepperoni = input.nextLine().toLowerCase();

            if (pepperoni.equals("yes")) {
                if (size.equals("small")) {
                    bill += 30;
                } else {
                    bill += 50;
                }
                break;
            } else if (pepperoni.equals("no")) {
                break;
            } else {
                System.out.println("Invalid input! Please enter yes or no.\n");
            }
        }

        while (true) {
            System.out.print("Do you want extra cheese? (yes/no): ");
            String cheese = input.nextLine().toLowerCase();

            if (cheese.equals("yes")) {
                bill += 20;
                break;
            } else if (cheese.equals("no")) {
                break;
            } else {
                System.out.println("Invalid input! Please enter yes or no.\n");
            }
        }

        System.out.println("\nYour Final Bill is: " + bill + " rupees");

        input.close();
    }
}


