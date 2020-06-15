package hackerRank.Mini_Max_Sum;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Mini_Max_Sum {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		miniMaxSum(arr);
	}

	// Complete the miniMaxSum function below.
	
	/**
	 * Integer minNumber = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                    .min(Comparator.comparing(Integer::valueOf))
                    .get();
	 * @param arr
	 */
	static void miniMaxSum(int[] arr) {
		int maxDig=arr[0];
        int minDig=arr[0];
        long sum=arr[0];
        long minSum=0,maxSum=0;
        for(int i=1; i<5;i++){
            sum+=arr[i];
            if(arr[i]>maxDig){
                maxDig=arr[i];
            }
            else if(arr[i]< minDig){
                minDig=arr[i];
            }
        }
        minSum=sum-maxDig;
        maxSum=sum-minDig;

        System.out.print(minSum+" "+maxSum);
	}
}
