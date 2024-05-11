public class MinimumNumber {
    public static int min(int one, int two, int three) {
        int small = 0;
        small = Math.min(one, two);
        small = Math.min(three, small);
        

        return small;
    }
    
}
