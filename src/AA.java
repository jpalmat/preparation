public class AA {
    public static void main(String[] args) {
        String s = "xyz";
        printPermutation(s, 0, s.length() -1);
    }

    public static void printPermutation(String s, int initial, int length) {
        if (length == initial) {
            System.out.println(s);
        } else {
            for (int i = initial; i <= length; i++) {
                s = swat(s, initial, i);
                printPermutation(s, initial + 1, length);
                s = swat(s, initial, i);
            }
        }
    }

    private static String swat(String s, int initial, int i) {
        char a;
        char[] arrString = s.toCharArray();
        a = arrString[initial];
        arrString[initial] = arrString[i];
        arrString[i] = a;
        return String.valueOf(arrString);
    }
}
