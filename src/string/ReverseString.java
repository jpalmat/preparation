package string;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverse("JIMMY"));
        System.out.println(reverse1("JIMMY"));
        System.out.println(inPlaceReverse("JIMMY"));
    }

    public static String reverse(String source){
        long start = System.nanoTime();
        if(source == null || source.isEmpty()){
            return source;
        }
        StringBuilder reverse = new StringBuilder();
        for(int i = source.length() -1; i>=0; i--){
            reverse.append(source.charAt(i));
        }

        System.out.println(System.nanoTime() - start);
        return reverse.toString();
    }

    public static String reverse1(String source){
        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder(source);
        int i = 0, j = source.length() - 1;
        char characterJ, characterAux;
        while(i < j) {
            characterJ = sb.charAt(j);
            characterAux = sb.charAt(i);
            sb.setCharAt(i, characterJ);
            sb.setCharAt(j, characterAux);

            i++;
            j--;
        }

        System.out.println(System.nanoTime() - start);
        return sb.toString();
    }

    public static String inPlaceReverse(final String input) {
        long start = System.nanoTime();
        final StringBuilder builder = new StringBuilder(input);
        int length = builder.length();
        for (int i = 0; i < length / 2; i++) {
            final char current = builder.charAt(i);
            final int otherEnd = length - i - 1;
            builder.setCharAt(i, builder.charAt(otherEnd)); // swap
            builder.setCharAt(otherEnd, current);
        }

        System.out.println(System.nanoTime() - start);
        return builder.toString();
    }

    public static String reverseRecursive(String str)
    {
        if (str.isEmpty())
            return str;
        //Calling Function Recursively
        return reverseRecursive(str.substring(1)) + str.charAt(0);
    }
}
