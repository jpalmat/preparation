package hackerRank.interviewpreparationkit.warmup.sockMerchant;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SockMerchant {
    public static void main(String[] args) {

        System.out.println(sockMerchant(9, new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20}));
    }

    static int sockMerchant(int n, int[] ar) {

        List<String> listString = Arrays.stream(ar).boxed().map(x -> x.toString()).collect(Collectors.toList());
        Map<String, Integer> collect = listString.parallelStream().collect(Collectors.toConcurrentMap(w -> w, w -> 1, Integer::sum));
        int numSocks = 0;
        for (Map.Entry<String, Integer> entry : collect.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue()+" -> "+entry.getValue()/2);
            numSocks+=entry.getValue()/2;
        }
        return numSocks;
    }
}
