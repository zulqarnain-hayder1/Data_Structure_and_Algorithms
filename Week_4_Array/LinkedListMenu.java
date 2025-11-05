/* import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;

    public void traverse() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        System.out.print("Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void insertAtPosition(int data, int pos) {
        if (pos <= 0) {
            System.out.println("Invalid position!");
            return;
        }
        Node newNode = new Node(data);
        if (pos == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of range!");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
    }

    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    public void deleteFromPosition(int pos) {
        if (head == null || pos <= 0) {
            System.out.println("Invalid operation.");
            return;
        }
        if (pos == 1) {
            head = head.next;
            return;
        }
        Node temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            System.out.println("Position out of range.");
            return;
        }
        temp.next = temp.next.next;
    }

    public boolean search(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) return true;
            temp = temp.next;
        }
        return false;
    }
}

public class LinkedListMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();

        System.out.print("Enter number of initial elements: ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            list.insertAtEnd(sc.nextInt());
        }

        while (true) {
            System.out.println("\n--- Common Operations in Linked List ---");
            System.out.println("1. Traversal");
            System.out.println("2. Insertion");
            System.out.println("3. Deletion");
            System.out.println("4. Searching");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    list.traverse();
                    break;

                case 2:
                    System.out.println("\n--- Insertion Options ---");
                    System.out.println("1. At Beginning");
                    System.out.println("2. At End");
                    System.out.println("3. At Specific Position");
                    System.out.print("Enter your choice: ");
                    int insChoice = sc.nextInt();
                    System.out.print("Enter value: ");
                    int val = sc.nextInt();

                    if (insChoice == 1) list.insertAtBeginning(val);
                    else if (insChoice == 2) list.insertAtEnd(val);
                    else if (insChoice == 3) {
                        System.out.print("Enter position: ");
                        int pos = sc.nextInt();
                        list.insertAtPosition(val, pos);
                    } else {
                        System.out.println("Invalid Insertion Choice!");
                    }
                    break;

                case 3:
                    System.out.println("\n--- Deletion Options ---");
                    System.out.println("1. From Beginning");
                    System.out.println("2. From End");
                    System.out.println("3. From Specific Position");
                    System.out.print("Enter your choice: ");
                    int delChoice = sc.nextInt();

                    if (delChoice == 1) list.deleteFromBeginning();
                    else if (delChoice == 2) list.deleteFromEnd();
                    else if (delChoice == 3) {
                        System.out.print("Enter position: ");
                        int pos = sc.nextInt();
                        list.deleteFromPosition(pos);
                    } else {
                        System.out.println("Invalid Deletion Choice!");
                    }
                    break;

                case 4:
                    System.out.print("Enter key to search: ");
                    int key = sc.nextInt();
                    System.out.println(list.search(key) ? "Key Found!" : "Key Not Found!");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
*/