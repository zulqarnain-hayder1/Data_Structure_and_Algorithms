import java.util.Scanner;

// Node class
class Node {
    int data;
    Node next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }
}

public class UserInputLinkedList {

    // Function to traverse and print list
    public static void traverse(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;  // move to next node
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask how many nodes user wants
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        Node head = null, tail = null;

        // Take values from user and create linked list
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter value for node " + i + ": ");
            int val = sc.nextInt();

            Node newNode = new Node(val);

            if (head == null) {
                // first node becomes head
                head = newNode;
                tail = newNode;
            } else {
                // link new node at the end
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Traversal
        System.out.println("\nTraversal of linked list:");
        traverse(head);

        sc.close();
    }
}