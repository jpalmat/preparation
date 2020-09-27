package ITCCoderpad;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        System.out.println(LCSubStr("GeeksforGeeks".toCharArray(), "GeeksQuiz".toCharArray()));
    }

    public static int LCSubStr(String x, String y) {
        int max = 0;
        exit: for(int i= 0; i<x.length(); i++){
            int j = x.length();
            while(i < j){
                String sub = new String(x.substring(i, j));
                if(y.indexOf(sub)!=-1){
                    max = j - i;
                    break exit;
                }
                j--;
            }
        }
        return max;
    }

    public static int LCSubStr(char[] x, char[] y) {

        return LCSubStr(String.valueOf(x), String.valueOf(y));
    }
}
