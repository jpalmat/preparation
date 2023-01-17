package javaPrep.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RomanToInt {

    public static void main(String[] args) {
//        String a = "test";
//        char c = a.charAt(0);
//        System.out.println(a.charAt(0) == 't');
        System.out.println(romanToInt("MCMXCIV"));
    }

    static Map<String, Integer> map = Stream.of(new Object[][] {
            { "I", 1 },
            { "IV", 4 },
            { "V", 5 },
            { "IX", 9 },
            { "X", 10 },
            { "XL", 40 },
            { "L", 50 },
            { "XC", 90 },
            { "C", 100 },
            { "CD", 400 },
            { "D", 500 },
            { "CM", 900 },
            { "M", 1000 },
    }).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));

    public static int romanToInt(String s) {


        List<Integer> numbers = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {
            if(isSpecialRoman(i, s)) {
                numbers.add(map.get(String.valueOf(s.charAt(i))+String.valueOf(s.charAt(i+1))));
                i++;
                continue;
            }
            numbers.add(map.get(String.valueOf(s.charAt(i))));
        }

        int total = 0;
        for(int number : numbers) {
            total += number;
        }
        return total;
    }

    private static boolean isSpecialRoman(int i, String s) {
        if(i<s.length() - 1 && map.containsKey(String.valueOf(s.charAt(i))+String.valueOf(s.charAt(i+1)))){
            return true;
        }
        return false;
    }
}
