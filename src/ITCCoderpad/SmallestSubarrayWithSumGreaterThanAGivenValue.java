package ITCCoderpad;

import java.util.TreeSet;

/**
 * https://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/
 */
public class SmallestSubarrayWithSumGreaterThanAGivenValue {
    public static void main(String[] args) {
        int arr1[] = {1, 4, 45, 6, 0, 19};
        int x = 51;
        System.out.println(smallestSubWithSum(arr1, x));
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
                    count=0;
                    break;
                }
                temp += arr[j];
                count++;
            }
        }
        return set.first();
    }
}
