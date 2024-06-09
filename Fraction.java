//This class will handle the operations related to fractions
// addition, subtraction, multiplication and divison
//Also Include methods to simplify fractions
//manage signs approprietrly
/**
 * The class is to define the fraction object that includes properties:
 * - Numerator
 * - Denominator
 * The class provides some methods such as:
 * - Addition
 * - Subtraction
 * - Multiplication
 * - Division
 *
 * @author FIRST_NAME LAST_NAME <SCHOOL_EMAIL>
 * @version 1.0
 */
public class Fraction {
    /**
     * The value of the numerator of the fraction.
     */
    private int numerator;
    
    /**
     * The value of the denominator of the fraction.
     */
    private int denominator;

    /**
     * The constructor accepts numerator and denominator.
     * @param numerator the numerator of the fraction
     * @param denominator the denominator of the fraction
     */
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        setDenominator(denominator);
        adjustSign();
        reduce();
    }

    /**
     * The setter method for the numerator.
     * @param numerator the numerator
     */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
        adjustSign();
        reduce();
    }

    /**
     * The setter method for the denominator.
     * @param denominator the denominator
     */
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.denominator = denominator;
        adjustSign();
        reduce();
    }

    /**
     * The method returns the numerator.
     * @return the numerator
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * The method returns the denominator.
     * @return the denominator
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * The method returns the decimal value.
     * @return the decimal value of the fraction
     */
    public double getDecimalValue() {
        return (double) numerator / denominator;
    }

    /**
     * The method returns the sum of fractions.
     * @param other the other fraction
     * @return the sum of fractions
     */
    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    /**
     * The method returns the difference between fractions.
     * @param other the other fraction
     * @return the difference between fractions
     */
    public Fraction subtract(Fraction other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    /**
     * The method returns the product of two fractions.
     * @param other the other fraction
     * @return the product of two fractions
     */
    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    /**
     * The method returns the quotient of two fractions.
     * @param other the other fraction
     * @return the quotient of two fractions
     * @throws ArithmeticException if the numerator of the divided fraction is zero
     */
    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            throw new ArithmeticException("Cannot divide by a fraction with a numerator of zero.");
        }
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    /**
     * The method returns the greatest common factor (GCF) of two integers.
     * @param a the first integer
     * @param b the second integer
     * @return the greatest common factor of a and b
     */
    protected int getGCF(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * The method simplifies the current fraction.
     */
    protected void reduce() {
        int gcf = getGCF(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcf;
        denominator /= gcf;
    }

    /**
     * The method makes sure the negative sign always goes with
     * the numerator instead of the denominator.
     */
    protected void adjustSign() {
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    /**
     * The method returns a string representing a fraction.
     */
    @Override
    public String toString() {
        if (denominator == 1) {
            return Integer.toString(numerator);
        }
        return numerator + "/" + denominator;
    }
}
