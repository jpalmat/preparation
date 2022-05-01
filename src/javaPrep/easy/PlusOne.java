package javaPrep.easy;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
        Arrays.stream(plusOne(new int[] {9, 9, 9, 9, 9, 9, 9, 9})).forEach(x -> System.out.println(x));
    }

    public static int[] plusOne(int[] digits) {
        int rest = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += rest;
            if(digits[i] == 10) {
                digits[i] = 0;
                rest = 1;
            } else {
                rest = 0;
            }
        }

        if (rest == 1) {
            int[] newDigits = new int[digits.length + 1];
            System.arraycopy(digits, 0, newDigits, 1, digits.length);
            newDigits[0] = 1;
            return newDigits;
        } else {
            return digits;
        }
    }
}
