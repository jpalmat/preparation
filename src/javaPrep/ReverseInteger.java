package javaPrep;

public class ReverseInteger {

    public static void main(String[] args) {

        int x = 1234567;
        int intLength = intLength(x);
        int revertedNumber = 0;

        for(int i = 0; i < intLength; i++) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        System.out.println(revertedNumber);
    }

    private static int intLength(int x) {
        int count = 1;

        while(x>=10){
            x = x/10;
            count++;
        }
        return count;
    }
}
