package interview;

/*
Given an array of integers and a number x, find the smallest subarray with sum greater than the given value.
 */
public class SmallestSubarrayWithSumGreaterThanAGivenValue {
    public static void main(String[] args) {
        int arr1[] = {1, 4, 45, 6, 0, 19};
        int x = 51;
        System.out.println(smallestSubWithSum(arr1, x));
    }

    public static int smallestSubWithSum(int arr[], int x){
        int temp = 0, count = 0;
        for(int i = 0; i < arr.length; i++){
            temp = 0;
            for(int j = i; j < arr.length; j++){
                if(temp > x){
                    count = j - i;
                    break;
                }
                temp+=arr[j];
            }
        }
        return count;
    }
}