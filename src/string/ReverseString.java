package string;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverse("JIMMY"));
    }

    public static String reverse(String source){
        if(source == null || source.isEmpty()){
            return source;
        }
        String reverse = "";
        for(int i = source.length() -1; i>=0; i--){
            reverse = reverse + source.charAt(i);
        }

        return reverse;
    }

    public static String reverseRecursive(String str)
    {
        if (str.isEmpty())
            return str;
        //Calling Function Recursively
        return reverseRecursive(str.substring(1)) + str.charAt(0);
    }
}
