package PracticeIT;

public class Weird {
    public static void main (String[] args) {
        int number = 8;
        halfThefun(11);
        halfThefun(2 - 3 + 2 * 8);
        halfThefun(number);
        System.out.println("number=" + number);
    }
 public static void halfThefun(int number) {
    number = number / 2;
    for(int count=1; count<=number;count++) {
        System.out.print(count + " ");  
    }
    System.out.println();
 }
}
