package ITCCoderpad;

import java.util.TreeSet;

/**
 * https://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/
 */
public class SmallestSubarrayWithSumGreaterThanAGivenValue {
    public static void main(String[] args) {
        int arr1[] = {1, 10, 5, 2, 7};
        int x = 51;
        System.out.println(smallestSubWithSum(arr1, 9));
    }

    public static int smallestSubWithSum(int arr[], int x){
        TreeSet<Integer> set = new TreeSet<>();
        int temp = 0, count = 0;
        for(int i = 0; i < arr.length; i++){
            temp = 0;
            count = 0;
            for(int j = i; j < arr.length; j++){
                if(set.size() > 0 && count > set.first())
                    break;
                if(temp > x){
                    set.add(count);
                    break;
                }
                temp += arr[j];
                count++;
            }
        }
        return set.first();
    }
}
