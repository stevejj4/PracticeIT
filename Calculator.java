import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char choice;
        do {
            startEnteringBinaryNumbers(scanner);
            System.out.print("Would you like to try again [Y or y for yes]? ");
            choice = scanner.next().charAt(0);
        } while (choice == 'Y' || choice == 'y');
        System.out.println("Thank you for using the program.");
        scanner.close();
    }

    public static void startEnteringBinaryNumbers(Scanner scanner) {
        System.out.print("How many binary numbers would you like to enter? ");
        int numBinaryNumbers = scanner.nextInt();
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < numBinaryNumbers; i++) {
            String binaryNumber = enterBinaryNumber(scanner);
            int decimalValue = convertBinaryToDecimal(binaryNumber);
            System.out.printf("The binary number you just entered has decimal value %d%n", decimalValue);
            sum += decimalValue;
            if (decimalValue < min) min = decimalValue;
            if (decimalValue > max) max = decimalValue;
        }

        System.out.printf("The sum is %d%n", sum);
        System.out.printf("The minimum value is %d%n", min);
        System.out.printf("The maximum value is %d%n", max);
        System.out.printf("The average is %.2f%n", (double) sum / numBinaryNumbers);
    }

    public static String enterBinaryNumber(Scanner scanner) {
        System.out.print("Enter the binary number: ");
        return scanner.next();
    }

    public static int convertBinaryToDecimal(String binaryNumber) {
        int decimal = 0;
        int power = 0;
        for (int i = binaryNumber.length() - 1; i >= 0; i--) {
            if (binaryNumber.charAt(i) == '1') {
                decimal += Math.pow(2, power);
            }
            power++;
        }
        return decimal;
    }
}
