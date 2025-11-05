import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        float quizMarks, assignmentMarks, midTermMarks, finalTermMarks;

        while (true) {
            System.out.print("Enter Quiz Marks (0-15): ");
            quizMarks = input.nextFloat();
            if (quizMarks >= 0 && quizMarks <= 15) {
                break;
            } else {
                System.out.println("Invalid input! Quiz marks must be between 0 and 15.\n");
            }
        }

        while (true) {
            System.out.print("Enter Assignment Marks (0-10): ");
            assignmentMarks = input.nextFloat();
            if (assignmentMarks >= 0 && assignmentMarks <= 10) {
                break;
            } else {
                System.out.println("Invalid input! Assignment marks must be between 0 and 10.\n");
            }
        }

        while (true) {
            System.out.print("Enter Mid Term Marks (0-25): ");
            midTermMarks = input.nextFloat();
            if (midTermMarks >= 0 && midTermMarks <= 25) {
                break;
            } else {
                System.out.println("Invalid input! Mid Term marks must be between 0 and 25.\n");
            }
        }

        while (true) {
            System.out.print("Enter Final Term Marks (0-50): ");
            finalTermMarks = input.nextFloat();
            if (finalTermMarks >= 0 && finalTermMarks <= 50) {
                break;
            } else {
                System.out.println("Invalid input! Final Term marks must be between 0 and 50.\n");
            }
        }

        float total = quizMarks + assignmentMarks + midTermMarks + finalTermMarks;
        float percentage = (total / 100) * 100;

        System.out.println("\nTotal Marks: " + total + "/100");
        System.out.println("Percentage: " + percentage + "%");

        if (percentage >= 85 && percentage <= 100) {
            System.out.println("Grade: A");
        } else if (percentage >= 70) {
            System.out.println("Grade: B");
        } else if (percentage >= 50) {
            System.out.println("Grade: C");
        } else if (percentage >= 0) {
            System.out.println("Grade: F");
        } else {
            System.out.println("Error calculating grade.");
        }

        input.close();
    }
}
