import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2 {

	public static void main(String[] args) {
		List<Integer> arrival = Arrays.asList(new Integer[] {1, 1, 1, 1, 4});
		List<Integer> duration = Arrays.asList(new Integer[] {10, 3, 6, 4, 2});
		
		System.out.println(maxEvents(arrival, duration));

	}

	public static int maxEvents(List<Integer> arrival, List<Integer> duration) {
		// Write your code here
//		int count = 1;
//		int end = arrival.get(0) + duration.get(0);
//		for (int i = 1; i < arrival.size(); i++) {
//			if (arrival.get(i) <= end) {			
//				count++;
//			}
//			end = arrival.get(i) + duration.get(i);
//		}
//		return count;
		int n = arrival.size();
				List<Integer> uniqueArrivals = new ArrayList<Integer>();
				List<Integer> uniqueDurations = new ArrayList<Integer>();
				for (int i=0;i<n;i++) {
					if(uniqueArrivals.contains(arrival.get(i))) {
						//int index = uniqueArrivals.get(arrival.get(i));
						int index =0;
						for (int k=0;k<uniqueArrivals.size();k++) {
							if(uniqueArrivals.get(k)==arrival.get(i)) {
								index=k;
							}
						}
						if(duration.get(i)<uniqueDurations.get(index)) {
							int xx = uniqueDurations.get(index);
							uniqueDurations.set(index, duration.get(i));

						}
					} else {
						uniqueArrivals.add(arrival.get(i));
						uniqueDurations.add(duration.get(i));
							}
					
				}
				int uniqueArrivalsSize = uniqueArrivals.size();
				for (int i=0;i<uniqueArrivalsSize;i++) {
					for (int j=0; j<uniqueArrivalsSize-1;j++) {
						if(uniqueArrivals.get(j)>uniqueArrivals.get(j+1)) {
							int temp = uniqueArrivals.get(j);
							uniqueArrivals.set(j,uniqueArrivals.get(j+1));
							uniqueArrivals.set(j+1,temp);
							//
							temp = uniqueDurations.get(j);
							uniqueDurations.set(j,uniqueDurations.get(j+1));
							uniqueDurations.set(j+1,temp);
							
						}
					}
				}
				

				int totalTime = 0,count =0;
				
				for (int i=0;i<uniqueArrivalsSize;i++) {
					if(totalTime<=uniqueArrivals.get(i)) {
						totalTime =uniqueArrivals.get(i) + uniqueDurations.get(i);
						count++;
					}
				}
				return count;
	}
}
