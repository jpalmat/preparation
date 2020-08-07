package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxEvents {

    public static void main(String[] args) {
        List<Integer> arrival = Arrays.asList(new Integer[]{1, 3, 3, 5, 7});
        List<Integer> duration = Arrays.asList(new Integer[]{2, 2, 1, 2, 11});

        System.out.println(maxEvents(arrival, duration));

    }

	/*
	Sam is part of the organizing team arranging the university's career fair and has list of companies and their respective arrival times and
	durations. Due to university-wide budget cuts, there is only one stage/dais available on the entire campus so only one event can occur at a
	time. Given each company's arrival time and the duration they will stay, determine the maximum number of promotional events that can be
	hosted during the career fair.

For example, there are n = 5 companies that will arrive at times arrival = [1, 3, 3, 5, 7) and will stay for duration = [2, 2, 1, 2, 11.
The first company arrives at time 1 and stays for 2 hours.
 At time 3, two companies arrive, but only 1 can stay for either 1 or 2 hours. The next companies arrive at times 5 and 7 and do not conflict
 with each other. In total, there can be a maximum of 4 promotional events.

Function Description

Complete the function maxEvents in the editor below. It must return an integer that represents the maximum number of promotional events that
can be hosted.

maxEvents has the following parameter(s):

arrivalſ arrival (O)....arrivalin-11: an array of integers where it element is the arrival time of the i" company.

duration duration)... duration(n-1]): an array of integers where it" element is the duration that the company's stay at the career fair.

• 1 < n < 5O

• 1 <= arrival[i] <= 1000

. 1 <= duration[i] <= 1000

• Both 'arrival' array and duration array will have equal number of elements
	 */
    public static int maxEvents(List<Integer> arrival, List<Integer> duration) {
        int n = arrival.size();
        List<Integer> uniqueArrivals = new ArrayList<Integer>();
        List<Integer> uniqueDurations = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (uniqueArrivals.contains(arrival.get(i))) {
                //int index = uniqueArrivals.get(arrival.get(i));
                int index = 0;
                for (int k = 0; k < uniqueArrivals.size(); k++) {
                    if (uniqueArrivals.get(k) == arrival.get(i)) {
                        index = k;
                    }
                }
                if (duration.get(i) < uniqueDurations.get(index)) {
                    int xx = uniqueDurations.get(index);
                    uniqueDurations.set(index, duration.get(i));

                }
            } else {
                uniqueArrivals.add(arrival.get(i));
                uniqueDurations.add(duration.get(i));
            }

        }
        int uniqueArrivalsSize = uniqueArrivals.size();
        for (int i = 0; i < uniqueArrivalsSize; i++) {
            for (int j = 0; j < uniqueArrivalsSize - 1; j++) {
                if (uniqueArrivals.get(j) > uniqueArrivals.get(j + 1)) {
                    int temp = uniqueArrivals.get(j);
                    uniqueArrivals.set(j, uniqueArrivals.get(j + 1));
                    uniqueArrivals.set(j + 1, temp);
                    //
                    temp = uniqueDurations.get(j);
                    uniqueDurations.set(j, uniqueDurations.get(j + 1));
                    uniqueDurations.set(j + 1, temp);

                }
            }
        }


        int totalTime = 0, count = 0;

        for (int i = 0; i < uniqueArrivalsSize; i++) {
            if (totalTime <= uniqueArrivals.get(i)) {
                totalTime = uniqueArrivals.get(i) + uniqueDurations.get(i);
                count++;
            }
        }
        return count;
    }
}
