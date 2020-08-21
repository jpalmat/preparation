package interview.amazon;

import java.util.*;
import java.util.Stack;

/*
Several teams across Amazon are participating in a company wide robotics challenge Your team has programmed a robot to play a game in
which it throws a ball at various blocks marked with a
symbol so as to knock these out You have been asked to automate the scoring process. A score is computed for each throw The last score
is the score of the previous throw (or 0,
if there is no previous throw) and the total score is the sum of the scores of all the throws. The symbol on a block can be an integer,
a sign or a letter Each sign or

letter represents a special rule as given below.

If a throw hits a block marked with an integer, the score for that throw is the value of that integer If throw hits a block marked with
an x the score for that throw is double the

last score If a throw hits a block marked with a, the score for that throw is the sum of the last two scores Ha throw hits a block marked
with a Z, the last score is removed, as though

the last throw never happened. Its value does not count towards the total

score and the subsequent throws will ignore it when computing their values

(see example below)

Write an algorithm that computes the total score for a given list of ordered hits by John

Input

The input to the function/method consists of two arguments

num, an integer representing the number of symbols in the list

blocks, representing a list of symbols

Output Return an integer representing the total score for the given ist af ordered
 */
public class RobotGame {
    public static int foo(List<String> blocks, int num) {
        Stack<Integer> st = new Stack<>();
        int totalScore = 0, temp = 0, temp2 = 0;
        for (int i = 0; i < num; ++i) {
            if (blocks.get(i).equals("X")) {
                if (!st.isEmpty()) {
                    temp = st.peek();
                    totalScore += temp;
                }
            } else if (blocks.get(i).equals("+")) {
                if (!st.isEmpty()) {
                    temp = st.peek();
                    temp2 = st.pop();
                    totalScore += totalScore + temp + temp2;
                    st.push(temp2);
                }
            } else if (blocks.get(i).equals("Z")) {
                if (!st.isEmpty()) {
                    temp2 = st.pop();
                    totalScore -= temp2;

                }
            } else {
                st.push(Integer.parseInt(blocks.get(i)));
            }
        }
        return totalScore;
    }

    public static void main(String[] args) {
        List<String> blocks = Arrays.asList(new String[]{"5", "-2", "4", "Z", "X", "9", "+", "+"});

        System.out.println(foo(blocks, 8));
    }
}
