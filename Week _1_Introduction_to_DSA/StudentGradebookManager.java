import java.util.Scanner;

public class StudentGradebookManager {
    static final int MAX = 50;
    static int[] roll = new int[MAX];
    static String[] name = new String[MAX];
    static int[] marks = new int[MAX];
    static int count = 0;


    public static void addStudent(int r, String n, int m) {
        roll[count] = r;
        name[count] = n;
        marks[count] = m;
        count++;
        System.out.println("Student added successfully.");
    }


    public static void displayAll() {
        if (count == 0) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("Roll\tName\tMarks\tGrade");
        for (int i = 0; i < count; i++) {
            System.out.println(roll[i] + "\t" + name[i] + "\t" + marks[i] + "\t" + grade(marks[i]));
        }
        System.out.println("Total Students: " + count);
    }


    public static void search(int r) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (roll[i] == r) {
                System.out.println("Found:");
                System.out.println("Roll: " + roll[i]);
                System.out.println("Name: " + name[i]);
                System.out.println("Marks: " + marks[i]);
                System.out.println("Grade: " + grade(marks[i]));
                found = true;
                break;
            }
        }
        if (!found) System.out.println("No record found.");
    }


    public static void search(String n) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (name[i].equalsIgnoreCase(n)) {
                System.out.println("Found:");
                System.out.println("Roll: " + roll[i]);
                System.out.println("Name: " + name[i]);
                System.out.println("Marks: " + marks[i]);
                System.out.println("Grade: " + grade(marks[i]));
                found = true;
                break;
            }
        }
        if (!found) System.out.println("No record found.");
    }


    public static double computeAverage(int[] marks, int count) {
        if (count == 0) return 0;
        int sum = 0;
        for (int i = 0; i < count; i++) sum += marks[i];
        return (double) sum / count;
    }


    public static String grade(int m) {
        if (m >= 85) return "A";
        else if (m >= 70) return "B";
        else if (m >= 50) return "C";
        else return "F";
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Student Gradebook Manager ====");
            System.out.println("1) Add Student");
            System.out.println("2) Display All");
            System.out.println("3) Search Student (by Roll / by Name)");
            System.out.println("4) Class Average & Topper");
            System.out.println("5) Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll: ");
                    int r = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String n = sc.nextLine();
                    int m;
                    while (true) {
                        System.out.print("Enter Marks (0-100): ");
                        m = sc.nextInt();
                        if (m >= 0 && m <= 100) break;
                        else System.out.println("Invalid marks! Please enter between 0 and 100.");
                    }
                    addStudent(r, n, m);
                    break;

                case 2:
                    displayAll();
                    break;

                case 3:
                    System.out.println("Search by: 1) Roll  2) Name");
                    int opt = sc.nextInt();
                    sc.nextLine();
                    if (opt == 1) {
                        System.out.print("Enter Roll to search: ");
                        search(sc.nextInt());
                    } else if (opt == 2) {
                        System.out.print("Enter Name to search: ");
                        search(sc.nextLine());
                    } else {
                        System.out.println("Invalid option!");
                        continue;
                    }
                    break;

                case 4:
                    if (count == 0) {
                        System.out.println("No students available.");
                    } else {
                        System.out.println("==== Class Average & Topper ====");
                        double avg = computeAverage(marks, count);
                        System.out.printf("Class Average: %.2f\n", avg);

                        int maxMarks = marks[0];
                        int idx = 0;
                        for (int i = 1; i < count; i++) {
                            if (marks[i] > maxMarks) {
                                maxMarks = marks[i];
                                idx = i;
                            }
                        }
                        System.out.println("Topper:");
                        System.out.println("Roll: " + roll[idx]);
                        System.out.println("Name: " + name[idx]);
                        System.out.println("Marks: " + marks[idx]);
                        System.out.println("Grade: " + grade(marks[idx]));
                    }
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
                    continue;
            }
        }
    }
}
