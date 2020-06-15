package hackerRank.DiagonalDifference;

import java.util.ArrayList;
import java.util.List;

public class DiagonalDifference {

	public static void main(String[] args) {
		List<List<Integer>> arraF = new ArrayList<List<Integer>>();
		List<Integer> arra1 = new ArrayList<Integer>();
		arra1.add(11);
		arra1.add(2);
		arra1.add(4);
		
		List<Integer> arra2 = new ArrayList<Integer>();
		arra2.add(4);
		arra2.add(5);
		arra2.add(6);
		
		List<Integer> arra3 = new ArrayList<Integer>();
		arra3.add(10);
		arra3.add(8);
		arra3.add(-12);
		
//		arraF.add(arra);
		arraF.add(arra1);
		arraF.add(arra2);
		arraF.add(arra3);
		
		System.out.println(diagonalDifference(arraF));
	}

	public static int diagonalDifference(List<List<Integer>> arr) {
    	int rows = arr.size();
    	int diagPrincipal = 0, diagSec = 0;
    	int result;
    	for(int i = 0; i<rows; i++) {
    		for(int j = 0; j<rows; j++) {
        		if(i==j)
        			diagPrincipal += arr.get(i).get(j) ;
        		
        		if(i+j == rows -1)
        			diagSec+= arr.get(i).get(j) ;
        	}
    	}
    	result = diagPrincipal - diagSec;
		return result < 0 ? result * -1 : result;
    }
}
