package interview.baires;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class problem3 {
    static String[] solution(String pin) {
        // Write your code here
        Map<Character, char[]> keypad = new HashMap<>();
        keypad.put('1', new char[]{'1', '2', '4'});
        keypad.put('2', new char[]{'1', '2', '3', '5'});
        keypad.put('3', new char[]{'2', '3', '6'});
        keypad.put('4', new char[]{'1', '4', '5', '7'});
        keypad.put('5', new char[]{'2', '4', '5', '6', '8'});
        keypad.put('6', new char[]{'3', '5', '6', '9'});
        keypad.put('7', new char[]{'4', '7', '8'});
        keypad.put('8', new char[]{'5', '7', '8', '9', '0'});
        keypad.put('9', new char[]{'6', '8', '9'});
        keypad.put('0', new char[]{'8', '0'});

        Set<String> variations = new TreeSet<>();
        variations.add(pin);

        for (int i = 0; i < pin.length(); i++) {
            char digit = pin.charAt(i);
            char[] possibleDigits = keypad.get(digit);

            Set<String> currentVariations = new TreeSet<>(variations);
            variations.clear(); 

            for (String variation : currentVariations) {
                
                StringBuilder sb = new StringBuilder(variation);

                for (char possibleDigit : possibleDigits) {
                    sb.setCharAt(i, possibleDigit); 
                    variations.add(sb.toString());     
                }
            }
        }

        int n = variations.size(); 
        String arr[] = new String[n]; 
  
        int i = 0; 
        for (String x : variations) 
            arr[i++] = x; 
        return arr;

    }

    public static void main(String[] args) {
        System.out.println(solution("8"));
    }
}
