package hackerRank.PlusMinus;

import java.text.DecimalFormat;

public class PlusMinus {
	public static void main(String[] args) {
		int arr[] = {-4, 3, -9, 0, 4, 1};
		plusMinus(arr);
	}
	
	static void plusMinus(int[] arr) {
		double positive = 0, negative = 0, zero = 0;
		double size = arr.length;

		for (int i : arr) {
			if(i > 0)
				positive++;
			if(i < 0)
				negative++;
			if(i == 0)
				zero++;
		}
		
		double positiveResult = positive/size;
		double negativeResult = negative/size;
		double zeroResult = zero/size;
		
		DecimalFormat df = new DecimalFormat("0.000000");
		
		System.out.println(df.format(positiveResult));
		System.out.println(df.format(negativeResult));
		System.out.println(df.format(zeroResult));
    }
}
