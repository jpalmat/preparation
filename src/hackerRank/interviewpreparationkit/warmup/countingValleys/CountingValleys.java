package hackerRank.interviewpreparationkit.warmup.countingValleys;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class CountingValleys {
    public static void main(String[] args) {
        System.out.println(countingValleys(10, "UDUUUDUDDD"));
        /**
         *UDDDUDUU
         _/\
            \     /
             \/\/


         *     /\/\
             /     \
         _/\/       \

         UDUUUDUDDD
              /\/\
             /    \
         _/\/      \
         */
    }

    static int countingValleys(int n, String s) {
        //first intent
        //List<String> steeps = Arrays.stream(s.split("")).collect(Collectors.toList());
        Stack<String> stackSteeps = new Stack<>();
        int numValley = 0;
        boolean valley = false;
        for (int i = 0; i < s.length(); i++) {
            if(stackSteeps.empty()) {
                if(String.valueOf(s.charAt(i)).equals("D"))
                    valley=true;
                stackSteeps.push(String.valueOf(s.charAt(i)));
            } else if(stackSteeps.peek().equals(String.valueOf(s.charAt(i)))){
                stackSteeps.push(String.valueOf(s.charAt(i)));
            } else {
                if(String.valueOf(s.charAt(i)).equals("U") && (i == s.length()-1 || stackSteeps.size()==1) && valley) {
                    numValley++;
                    valley = false;
                }
                stackSteeps.pop();
            }
        }
        return numValley;
    }
}
