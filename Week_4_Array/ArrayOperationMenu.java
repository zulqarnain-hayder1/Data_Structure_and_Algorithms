import java.util.Scanner;

public class ArrayOperationMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[100];
        int n;

        System.out.print("Enter number of elements: ");
        n = sc.nextInt();

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int choice;
        do {
            System.out.println("\n--- ARRAY MENU ---");
            System.out.println("1. Traversal");
            System.out.println("2. Insert Element");
            System.out.println("3. Delete Element");
            System.out.println("4. Search Element");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Array: ");
                    for (int i = 0; i < n; i++) System.out.print(arr[i] + " ");
                    System.out.println();
                    break;

                case 2:
                    System.out.print("Enter element: ");
                    int ele = sc.nextInt();
                    System.out.print("Enter position (1 to " + (n + 1) + "): ");
                    int pos = sc.nextInt();
                    if (pos >= 1 && pos <= n + 1) {
                        for (int i = n; i >= pos; i--) arr[i] = arr[i - 1];
                        arr[pos - 1] = ele;
                        n++;
                    } else System.out.println("Invalid position!");
                    break;

                case 3:
                    System.out.print("Enter position (1 to " + n + "): ");
                    int dpos = sc.nextInt();
                    if (dpos >= 1 && dpos <= n) {
                        for (int i = dpos - 1; i < n - 1; i++) arr[i] = arr[i + 1];
                        n--;
                    } else System.out.println("Invalid position!");
                    break;

                case 4:
                    System.out.print("Enter element to search: ");
                    int key = sc.nextInt();
                    int i;
                    for (i = 0; i < n; i++) {
                        if (arr[i] == key) {
                            System.out.println("Found at position " + (i + 1));
                            break;
                        }
                    }
                    if (i == n) System.out.println("Not found!");
                    break;

                case 5:
                    System.out.println("Exit...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}
