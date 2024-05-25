public class Pairs {
    public static void main (String[] args){
        String[] words = {"score", "four", "seven", "and", "ago", "years"};
        swapPairs(words);
        System.out.println(java.util.Arrays.toString(words));
    }
    public static void swapPairs(String[] strings) {
        int length = strings.length;

        //if it odd
        if(strings.length%2!=0) length = strings.length - 1;
        int counter = 0;
        for(int a = 0; a<length; a++) {
            String first = strings[counter++];
            String second = strings[counter++];

            strings[a++] = second;
            strings[a] = first;
        }
    }   
}
