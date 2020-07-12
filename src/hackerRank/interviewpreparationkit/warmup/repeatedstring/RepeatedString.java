package hackerRank.interviewpreparationkit.warmup.repeatedstring;

import java.util.Arrays;

public class RepeatedString {
    public static void main(String[] args) {
        System.out.println(repeatedString("a", 1000000000000l));
    }

    static long repeatedString(String s, long n) {
        StringBuilder stringBuilder = new StringBuilder(s);
        long anumber = Arrays.stream(s.split("")).filter(x -> x.equals("a")).count();
        long repeticionNumber = n/s.length();
        long mod = n%s.length();
        String ssubstring = s.substring(0, (int) mod);
        long anumberSubString = Arrays.stream(ssubstring.split("")).filter(x -> x.equals("a")).count();
        return anumber*repeticionNumber+anumberSubString;
    }
}
