package interview.altimtrick;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
We are given n different types of stickers. Each sticker has a lowercase English word on it.

You would like to spell out the given string target by cutting individual letters from your collection of stickers and rearranging them. You can use each sticker more than once if you want, and you have infinite quantities of each sticker.

Return the minimum number of stickers that you need to spell out target. If the task is impossible, return -1.

Note: In all test cases, all words were chosen randomly from the 1000 most common US English words, and target was chosen as a concatenation of two random words.



Example 1:

Input: stickers = ["with","example","science"], target = "thehat"
Output: 3
Explanation:
We can use 2 "with" stickers, and 1 "example" sticker.
After cutting and rearrange the letters of those stickers, we can form the target "thehat".
Also, this is the minimum number of stickers necessary to form the target string.
Example 2:

Input: stickers = ["notice","possible"], target = "basicbasic"
Output: -1
Explanation:
We cannot form the target "basicbasic" from cutting letters from the given stickers.
 */
public class StickersToSpellWord {

    public static int minStickers(String[] stickers, String target) {
        int[] t = new int[27];
        //bit 26 to record remaining character
        t[26] = target.length();
        Set<Character> set = new HashSet<>();
        Set<Character> checkSet = new HashSet<>();
        for(int i = 0; i < target.length(); i++) {
            t[target.charAt(i) - 'a']++;
            set.add(target.charAt(i));
            checkSet.add(target.charAt(i));
        }
        //mark valid stickers
        boolean[] valid = new boolean[stickers.length];
        int[][] stable = new int[stickers.length][26];
        for(int i = 0; i < stickers.length; i++) {
            for(int j = 0; j < stickers[i].length(); j++) {
                char c = stickers[i].charAt(j);
                if(set.contains(c)) {
                    stable[i][c - 'a']++;
                    valid[i] = true;
                    checkSet.remove(c);
                }
            }
        }
        if(checkSet.size() > 0) return -1;
        // if sticker A include sticker B, remove sticker B
        for(int i = 0; i < stable.length; i++) {
            for(int j = i + 1; j < stable.length; j++) {
                if(!valid[i] || !valid[j] || i == j) continue;
                int judge = isIncluding(stable[i], stable[j]);
                if(judge == 1) valid[j] = false;
                else if(judge == -1) valid[i] = false;
            }
        }
        //BFS
        Deque<int[]> queue = new LinkedList<>();
        queue.add(t);
        int level = 1;
        while(true) {
            int size = queue.size();
            while(size-- > 0) {
                int[] currState = queue.poll();
                for(int i = 0; i < stickers.length; i++) {
                    if(valid[i]) {
                        int[] nextState = new int[27];
                        boolean finished = true;
                        for(int j = 0; j < 26; j++) {
                            nextState[j] = currState[j] - stable[i][j];
                            if(nextState[j] > 0) finished = false;
                            nextState[26] += nextState[j] > 0 ? nextState[j] : 0;
                        }
                        if(finished) return level;
                        //if nothing change by using current sticker, don't put it back to queue.
                        if(nextState[26] < currState[26]) {
                            queue.offer(nextState);
                        }
                    }
                }
            }
            level++;
        }
    }

    private static int isIncluding(int[] a, int[] b) {
        boolean larger = true, smaller = true;
        for(int i = 0; i < 26; i++) {
            if(a[i] >= b[i]) smaller = false;
            else larger = false;
        }
        return larger ? 1 : smaller ? -1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(minStickers(new String[]{"with","example","science"}, "thehat"));
    }
}