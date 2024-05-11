public class ifElseMystry {
    public static void main(String[] args) {
        logiks(10,2);
        logiks(3,8);
        logiks(4,4);
        logiks(10,30);
         
    }
    public static void logiks(int a, int b) {
        if (a * 2 < b) {
            a = a * 3;
        }
        if (b < a) {
            b++;
        } else {
            a--;
        }
        System.out.println(a + " " + b);

    }

}