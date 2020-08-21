package interview;

import java.util.HashMap;
import java.util.Map;

public class SumTwoNumbers {

    public static void main(String[] args) {
        int[] arr = {10, 22, 4, 8, 12, 6, 11, 1};
        int sum = 15;

        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            m.put(sum - arr[i], i);
        }

        int temp = 0;
        boolean f = false;
        for (int i = 0; i < arr.length; i++) {
            if (m.containsKey(arr[i])) {
//                if (arr[i] != sum - arr[i] && m.get(arr[i]) != i) {
                    System.out.println("the values are " + arr[i] + " " + arr[m.get(arr[i])]);
//                }
            }
        }
    }
}
