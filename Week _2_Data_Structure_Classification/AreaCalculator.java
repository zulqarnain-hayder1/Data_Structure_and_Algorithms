import java.util.Scanner;

public class AreaCalculator {
    public static double area(double radius) {
        return Math.PI * radius * radius;
    }

    public static double area(double length, double width) {
        return length * width;
    }

    public static double areaSquare(double side) {
        return side * side;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter radius of circle: ");
        double r = sc.nextDouble();
        System.out.println("Area of Circle = " + area(r));

        System.out.print("\nEnter length of rectangle: ");
        double l = sc.nextDouble();
        System.out.print("Enter width of rectangle: ");
        double w = sc.nextDouble();
        System.out.println("Area of Rectangle = " + area(l, w));

        System.out.print("\nEnter side of square: ");
        double s = sc.nextDouble();
        System.out.println("Area of Square = " + areaSquare(s));

        sc.close();
    }
}

