public class CalcMedian {
    public static void main (String[] args) {
        int median = medianOf3(1,4,2);
        System.out.println("The median is: " + median);

    }
    public static int medianOf3(int n1, int n2, int n3) {
        if(n1 < n2 ) {
            if (n2 < n3) {
                return n2;
            } else { //if (n3<n2)
                if(n3<n1) {
                    return n1;
                } else { //if(n1<n3)
                    return n3;
                }
            }
        } else { //if (n2<n1)
            if(n1<n3) {
                return n1;
            } else {//if (n3<n1)
                if(n3<n2){
                    return n2;
                }else{ //if(n2<n3)
                    return n3;
                }
            }
        }
    }
}
