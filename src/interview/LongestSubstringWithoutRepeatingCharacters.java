package interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(longestUniqueSubsttr("geeksforgeeks"));
    }

    static int longestUniqueSubsttr(String s)
    {
        Set<String> setString = new HashSet<>(s.length());
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                if(setString.contains(String.valueOf(s.charAt(j)))){
                    max = setString.size()> max ? setString.size() : max;
                    setString = new HashSet<>();
                    break;
                } else {
                    setString.add(String.valueOf(s.charAt(j)));
                }
            }

        }
        return max;
    }
}