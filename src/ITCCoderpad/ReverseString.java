package ITCCoderpad;

public class ReverseString {
    public static void main(String[] args) {
        String string = "getting good at coding needs a lot of practice";
        System.out.println(reverse(string));
    }

    private static String reverse(String string) {
        String[] splitSt = string.split(" ");
        StringBuilder reverse = new StringBuilder();
        for(int i = splitSt.length -1; i>=0; i--){
            reverse.append(splitSt[i]).append(" ");
        }
        reverse.setLength(reverse.length()-1);
        return reverse.toString();
    }
}