package ITCCoderpad;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RunLengthEncoding {

    public static void main(String[] args) {
        System.out.println(solution(3, 2, new int[]{2, 1, 1, 0, 1}));
    }

    /**
     * https://www.geeksforgeeks.org/run-length-encoding/
     * @param str
     * @return
     */
//    public static int solution(int N) {
//        // write your code in Java SE 8
//        String[] num = String.valueOf(N).split("");
//        Arrays.sort(num, Comparator.reverseOrder());
//
//        return Integer.parseInt(Arrays.stream(num).collect(Collectors.joining()));
//    }
    public static String solution(int U, int L, int[] C) {
        // write your code in Java SE 8
        int[] c1 = new int[C.length];
        int[] c2 = new int[C.length];

        Integer sum = Arrays.stream(C).sum();
        for(int i = 0; i < C.length; i++){
            //map.put(i, C[i]);
            if(C[i]==2){
                c1[i] = 1;
                c2[i] = 1;
                U--;
                L--;
                continue;
            } else if(C[i]==0){
                continue;
            }else if(C[i]==1 && U>=1){
                c1[i]=1;
                U--;
                continue;
            } if(C[i]==1 && L>=1){
                c2[i]=1;
                L--;
                continue;
            }
        }

        StringBuilder cb = new StringBuilder();
        cb.append(Arrays.stream(c1).mapToObj(x -> String.valueOf(x)).collect(Collectors.joining()));
        cb.append(",");
        cb.append(Arrays.stream(c2).mapToObj(x -> String.valueOf(x)).collect(Collectors.joining()));

        return cb.toString();

       // if()
//        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
//            if(entry.getValue()==2){
//                C[i]
//            }
//        }
    }
}