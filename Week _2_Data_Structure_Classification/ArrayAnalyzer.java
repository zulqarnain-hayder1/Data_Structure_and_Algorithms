import java.util.Scanner;
public class ArrayAnalyzer {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of Element: ");
        int n = input.nextInt();
        int [] arr = new int[n];

        for(int i=0; i<n; i++)
        {
            System.out.println("Enter number "+(i+1)+":");
            arr[i] = input.nextInt();
        }
        int sum = 0, min = arr[0], max = arr[0];
        int evenCount = 0, oddCount = 0;

        for (int num : arr) {
            sum += num;

            if (num < min) min = num;
            if (num > max) max = num;

            if (num % 2 == 0)
                evenCount++;
            else
                oddCount++;
        }

        double average = (n > 0) ? (double) sum / n : 0;

        System.out.println(" Array Analyzer Results ");
        System.out.print("Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.println("\nSum: " + sum);
        System.out.println("Average: " + average);
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
        System.out.println("Even numbers count: " + evenCount);
        System.out.println("Odd numbers count: " + oddCount);

        System.out.print("Array in reverse order: ");
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}


