package interview;

import java.util.*;
import java.util.stream.Collectors;

public class CountRepeat {
    public static void main(String[] args) {
        System.out.println(summation(new int[]{1, 6, 8, 5, 9, 4, 7, 2}));
        System.out.println(getMapping("abbbcddddeffabbbbbb"));
    }

    /*
Given an array of integers, return an list of integers which contains the
[1st integer, Sum of next 2 integers (2nd, 3rd),
Sum of next 3 integers (4th, 5th, 6th)…] and so on

Input
[1,6,8,5,9,4,7,2]
Output
[1,14,18,9]

*/
    private static List<Integer> summation(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int limit = 1, i, j;
        int sum = 0;
        list.add(arr[0]);
        for (i = 1; i < arr.length; i++) {
            limit++;
            sum = 0;
            ok:
            for (j = 0; j < limit; j++) {
                if (i == arr.length)
                    break ok;
                sum += arr[i++];
            }
            list.add(sum);
            i--;
        }
        return list;
    }
/*

For a given string "abbbcddddeffabbbbbb" return the
characters who are consecutively repeated like "bbb" and how many times
it appears on the string.
For example, return a HashMap like,
b -> 2 Note: (bbb & bbbbbb)
d -> 1
f -> 1
Note: “a” appears two times but it is not consecutively repeated
 so it is not included. The same is true for “e”.
*/

    public static Map<String, Integer> getMapping(String str) {
        List<String> listString1 = Arrays.stream(str.split("")).collect(Collectors.toList());

        Stack<String> a = new Stack();
        Map<String, Integer> collect = new HashMap<>();
        String value = "";
        for (int i = 0; i < listString1.size(); i++) {
            value = listString1.get(i);
            if (a.size() == 0 || value.equals(a.peek()))
                a.push(listString1.get(i));
            else {
                if (a.size() > 1) {
                    if (collect.containsKey(value))
                        collect.computeIfPresent(a.pop(), (k, v) -> v + 1);
                    else
                        collect.put(a.pop(), 1);
                }
                a.clear();
                a.push(value);
            }
        }
        if (a.size() > 1 && a.peek().equals(value)) {
            if (collect.containsKey(value))
                collect.computeIfPresent(a.pop(), (k, v) -> v + 1);
            else
                collect.put(a.pop(), 1);
        }

        return collect;
    }
}
