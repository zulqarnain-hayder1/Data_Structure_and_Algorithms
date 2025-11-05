import java.util.*;

public class QueueSimulation {

    static class Queue {
        private LinkedList<String> elements;

        Queue() {
            elements = new LinkedList<>();
        }

        void enqueue(String job) {
            elements.addLast(job);
            System.out.println("Enqueued: \"" + job + "\"");
            displayQueue();
        }

        String dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty. No job to process.");
                return null;
            }
            String job = elements.removeFirst();
            System.out.println("Dequeue → Processing: \"" + job + "\"");
            displayQueue();
            return job;
        }

        String peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return null;
            }
            return elements.getFirst();
        }

        boolean isEmpty() {
            return elements.isEmpty();
        }

        void displayQueue() {
            System.out.println("Current Queue: " + elements);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue printerQueue = new Queue();

        System.out.println("=== Printer Queue Simulation ===");
        while (true) {
            System.out.println("1. Enqueue (Add Print Job)");
            System.out.println("2. Dequeue (Process Job)");
            System.out.println("3. Peek (View Next Job)");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear newline

            switch (choice) {
                case 1:
                    System.out.print("Enter document name: ");
                    String job = scanner.nextLine();
                    printerQueue.enqueue(job);
                    break;

                case 2:
                    printerQueue.dequeue();
                    break;

                case 3:
                    String nextJob = printerQueue.peek();
                    if (nextJob != null)
                        System.out.println("Next Job: \"" + nextJob + "\"\n");
                    break;

                case 4:
                    System.out.println("Exiting Printer Queue Simulation...");
                    return;

                default:
                    System.out.println("Invalid option. Try again.\n");
            }
        }
    }
}