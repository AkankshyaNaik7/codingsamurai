package codingsamurai;
import java.util.Scanner;
public class CalculatorApp {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("\nCalculator Application");
	            System.out.println("1. Addition");
	            System.out.println("2. Subtraction");
	            System.out.println("3. Multiplication");
	            System.out.println("4. Division");
	            System.out.println("5. Exit");
	            System.out.print("Select an operation: ");

	            int choice = scanner.nextInt();

	            if (choice == 5) {
	                System.out.println("Goodbye!");
	                break;
	            }

	            if (choice < 1 || choice > 4) {
	                System.out.println("Invalid option. Please select a valid operation.");
	                continue;
	            }

	            double num1, num2;
	            System.out.print("Enter the first number: ");
	            num1 = scanner.nextDouble();
	            System.out.print("Enter the second number: ");
	            num2 = scanner.nextDouble();

	            double result = 0;
	            boolean isValid = true;

	            switch (choice) {
	                case 1:
	                    result = add(num1, num2);
	                    break;
	                case 2:
	                    result = subtract(num1, num2);
	                    break;
	                case 3:
	                    result = multiply(num1, num2);
	                    break;
	                case 4:
	                    if (num2 == 0) {
	                        isValid = false;
	                        System.out.println("Error: Division by zero is not allowed.");
	                    } else {
	                        result = divide(num1, num2);
	                    }
	                    break;
	                default:
	                    isValid = false;
	            }

	            if (isValid) {
	                System.out.println("Result: " + result);
	            }
	        }

	        scanner.close();
	    }

	    public static double add(double num1, double num2) {
	        return num1 + num2;
	    }

	    public static double subtract(double num1, double num2) {
	        return num1 - num2;
	    }

	    public static double multiply(double num1, double num2) {
	        return num1 * num2;
	    }

	    public static double divide(double num1, double num2) {
	        return num1 / num2;
	    }
	

	}