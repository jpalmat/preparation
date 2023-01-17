package javaPrep.leetcode.easy;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flihg"}));
    }
    public static String longestCommonPrefix(String[] strs){
        int min = Integer.MAX_VALUE;
        for (String word : strs) {
            min = Math.min(min, word.length());
        }
        int start = 1;
        int end = min;

        while(start <= end) {
            int middle = (start + end) / 2;
            if (isPrefix(strs, middle)) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return strs[0].substring(0, (start + end)/ 2);
    }

    private static boolean isPrefix(String[] strs, int middle) {
        String wordPrefixToSearch = strs[0].substring(0, middle);
        for (String word : strs) {
            if(!word.startsWith(wordPrefixToSearch)) {
                return false;
            }
        }
        return true;
    }
}