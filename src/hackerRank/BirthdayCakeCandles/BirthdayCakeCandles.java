package hackerRank.BirthdayCakeCandles;

import java.util.Arrays;import java.util.Comparator;

public class BirthdayCakeCandles {

	public static void main(String[] args) {
		int[] ar = {3, 2, 1, 3};
		System.out.println(birthdayCakeCandles(ar));
	}

	static int birthdayCakeCandles(int[] ar) {
		Integer max = Arrays.stream(ar).boxed().max(Comparator.comparing(Integer::valueOf)).get();
		long count = Arrays.stream(ar).boxed().filter(n -> n == max).count();
		return (int) count;
		
		/**
		 * int maxCandle=ar[0];
        int maxCount=0;
        for (int i=1; i<ar.length;i++){
            if(ar[i]>maxCandle){
                maxCandle=ar[i];
            }
        }
        for(int j=0;j<ar.length;j++){
            if(ar[j]==maxCandle){
                maxCount++;
            }
        }
        return maxCount;
		 */
    }
}
