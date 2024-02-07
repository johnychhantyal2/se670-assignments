public class Calculator {

    // Method to add two numbers
    public double add(double number1, double number2) {
        return number1 + number2;
    }

    // Method to subtract two numbers
    public double subtract(double number1, double number2) {
        return number1 - number2;
    }

    // Method to multiply two numbers
    public double multiply(double number1, double number2) {
        return number1 * number2;
    }

    // Method to divide two numbers
    public double divide(double number1, double number2) {
        if (number2 == 0) {
            throw new IllegalArgumentException("Divider cannot be zero");
        }
        return number1 / number2;
    }

    // Main method for demonstration
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        // Test the methods
        System.out.println("Addition: 5 + 3 = " + calculator.add(5, 3));
        System.out.println("Subtraction: 5 - 3 = " + calculator.subtract(5, 3));
        System.out.println("Multiplication: 5 * 3 = " + calculator.multiply(5, 3));
        System.out.println("Division: 10 / 2 = " + calculator.divide(10, 2));
    }
}
