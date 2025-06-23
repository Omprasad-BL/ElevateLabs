import java.util.Scanner;

public class Calculator {

    // Method for addition
    public static double add(double a, double b) {
        return a + b;
    }

    // Method for subtraction
    public static double subtract(double a, double b) {
        return a - b;
    }

    // Method for multiplication
    public static double multiply(double a, double b) {
        return a * b;
    }

    // Method for division
    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Cannot divide by zero.");
            return Double.NaN;
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalc = true;

        while (continueCalc) {
            // Menu display
            System.out.println("\n=== Calculator Menu ===");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            if (choice == 5) {
                continueCalc = false;
                System.out.println("Exiting the calculator. Goodbye!");
                break;
            }

            // Get numbers from user
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();

            double result;

            switch (choice) {
                case 1:
                    result = add(num1, num2);
                    System.out.println("Result = " + result);
                    break;
                case 2:
                    result = subtract(num1, num2);
                    System.out.println("Result = " + result);
                    break;
                case 3:
                    result = multiply(num1, num2);
                    System.out.println("Result = " + result);
                    break;
                case 4:
                    result = divide(num1, num2);
                    if (!Double.isNaN(result))
                        System.out.println("Result = " + result);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
