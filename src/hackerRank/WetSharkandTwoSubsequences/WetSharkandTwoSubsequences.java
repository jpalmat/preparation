package hackerRank.WetSharkandTwoSubsequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WetSharkandTwoSubsequences {

	public static void main(String[] args) {
		int arr[] = { 902, 155, 1806, 1596, 672, 295, 984, 1845, 221, 1211, 1604, 1150, 892, 1843, 1500, 1626, 1696, 1912, 130, 1294, 1025, 1766, 572, 797, 1087, 408, 991, 1235, 1385, 1781, 1675, 1959, 413, 384, 344, 1467, 832, 762, 1999, 1829, 1296, 586, 1260, 1139, 1272, 608, 1587, 1194, 628, 438, 112, 1216, 646, 1144, 35, 1579, 1944, 1750, 972, 1737, 851, 1879, 1988, 785, 671, 992, 1724, 1162, 1532, 326, 1865, 827, 465, 736, 1281, 1363, 818, 256, 479, 730, 183, 1652, 493, 855, 1307, 1912, 722, 1283, 883, 1534, 26, 1517, 64, 1985, 1910, 496, 1750, 1798, 1619, 1251 };
		System.out.println(twoSubsequences(arr, 2000, 1000));
	}
	
	/*
     * Complete the twoSubsequences function below.
     */
    static int twoSubsequences(int[] x, int r, int s) {
    	int ru = 2;
		int n = x.length;
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		printCombination(x, n, ru, list);
		
		int count = 0;
		
		for (List<Integer> list2 : list) {
			Integer sum = list2.stream().mapToInt(Integer::intValue).sum();
			Integer res = list2.get(0) - list2.get(1);
			res = res < 0 ? res * -1 : res;
			if(sum == r && res == s)
				count++;
		}
		
		return count;
    }

	static void combinationUtil(int arr[], int data[], int start, int end, int index, int r, List<List<Integer>> list) {
		if (index == r) {
			list.add(Arrays.stream(data).boxed().collect(Collectors.toList()));
			return;
		}

		for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
			data[index] = arr[i];
			combinationUtil(arr, data, i + 1, end, index + 1, r, list);
		}
	}

	static void printCombination(int arr[], int n, int r, List<List<Integer>> list) {
		int data[] = new int[r];

		combinationUtil(arr, data, 0, n - 1, 0, r, list);
	}
}
