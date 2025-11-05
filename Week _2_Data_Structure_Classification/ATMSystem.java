import java.util.Scanner;

public class ATMSystem {
    private static int balance = 0;


    public static void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }


    public static void withdraw(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            balance -= amount;
            System.out.println("Successfully withdrawn: " + amount);
        }
    }


    public static void checkBalance() {
        System.out.println("Current balance: " + balance);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int PIN = 1234;
        boolean loggedIn = false;


        for (int i = 1; i <= 3; i++) {
            System.out.print("Enter PIN: ");
            int enteredPin = sc.nextInt();

            if (enteredPin == PIN) {
                loggedIn = true;
                break;
            } else {
                System.out.println("Incorrect PIN. Attempts left: " + (3 - i));
            }
        }

        if (!loggedIn) {
            System.out.println("Account locked! Too many wrong attempts.");
            sc.close();
            return;
        }


        while (true) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    int dep = sc.nextInt();
                    deposit(dep);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    int wit = sc.nextInt();
                    withdraw(wit);
                    break;

                case 3:
                    checkBalance();
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    sc.close();
                    break;

                default:
                    System.out.println("Invalid option! Try again.");
                    continue;
            }
            if (choice == 4) break;
        }
    }
}

