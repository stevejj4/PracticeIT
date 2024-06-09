import java.util.Scanner;

/**
 * The class is to run the main workflow.
 *
 * @author FIRST_NAME LAST_NAME <SCHOOL_EMAIL>
 */
public class FractionMain {
    public static void main(String[] args) {
        System.out.println("Welcome to the Fraction program");
        System.out.println("===============================");
        Scanner console = new Scanner(System.in);
        char tryAgain = runWorkflow(console);
        while (tryAgain == 'y' || tryAgain == 'Y') {
            tryAgain = runWorkflow(console);
        }
        System.out.println("===============================");
        System.out.println("Thank you for using the program");
        console.close();
    }

    public static char runWorkflow(Scanner console) {
        // Declare variables for numerators and denominators
        int num1, den1, num2, den2;

        // Get inputs for f1 numerator and denominator
        System.out.print("Enter the numerator for the 1st fraction: ");
        num1 = console.nextInt();
        System.out.print("Enter the denominator for the 1st fraction: ");
        den1 = console.nextInt();

        // Get inputs for f2 numerator and denominator
        System.out.print("Enter the numerator for the 2nd fraction: ");
        num2 = console.nextInt();
        System.out.print("Enter the denominator for the 2nd fraction: ");
        den2 = console.nextInt();

        // Create instances for two fractions
        Fraction f1 = new Fraction(num1, den1);
        Fraction f2 = new Fraction(num2, den2);

        // Display the two fractions
        System.out.println("f1 == " + f1);
        System.out.println("f2 == " + f2);

        // Display the two fractions as decimal values
        System.out.printf("%s == %.4f%n", f1, f1.getDecimalValue());
        System.out.printf("%s == %.4f%n", f2, f2.getDecimalValue());

        // Multiply the two fractions and store product in f3
        Fraction f3 = f1.multiply(f2);
        // Display f3 after multiplication
        System.out.println(f1 + " * " + f2 + " = " + f3);

        // Divide the two fractions and store result in f3
        f3 = f1.divide(f2);
        // Display f3 after division
        System.out.println(f1 + " / " + f2 + " = " + f3);

        // Add the two fractions and store result in f3
        f3 = f1.add(f2);
        // Display f3 after addition
        System.out.println(f1 + " + " + f2 + " = " + f3);

        // Subtract the two fractions and store result in f3
        f3 = f1.subtract(f2);
        // Display f3 after subtraction
        System.out.println(f1 + " - " + f2 + " = " + f3);

        // Prompt the user if they would like to try again
        System.out.print("Would you like to try again ['Y' or 'y']? ");
        return console.next().charAt(0);
    }
}
