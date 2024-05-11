public class printRange {
    public static void main (String[] args) {
        rangeOf2(2, 7);
    }
    public static void rangeOf2(int n1, int n2) {
        if (n1 < n2){
            for(int N1 = n1; N1<=n2; N1++) {
                System.out.print(N1 + " ");
            }

        } else if (n1>n2){
            for(int N1 = n1; N1>=n2; N1--) {
                System.out.print(N1 + " ");
            }
        } else {
            System.out.println(n1);
        }
    }
}
