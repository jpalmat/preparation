package interview.altimtrick;

import java.util.*;

/*
Find the all the combination of the orders whose price is equals to a certain number
"Apple": 3.5
"Banana": 3.6
"Meat": 4.0
"Water": 3.9
"Coke": 3.1
given the num is 7.0

should return[[Apple, Apple], [Water, Coke]]
 */
public class CombinationPrice {
    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();
        map.put("Apple", 3.5);
        map.put("Banana", 3.6);
        map.put("Meat", 4.0);
        map.put("Water", 3.9);
        map.put("Coke", 3.1);

        Double sum = 7.0;
        Map<Double, String> map1 = new HashMap<>();
        for(Map.Entry<String, Double> entry: map.entrySet()){
            map1.put(sum - entry.getValue(), entry.getKey());
        }

        List<List<String>> names = new ArrayList<>();
        for(Map.Entry<String, Double> entry: map.entrySet()){
            if(map1.containsKey(entry.getValue())){
                names.add(Arrays.asList(entry.getKey(), map1.get(entry.getValue())));
            }
        }
        System.out.println(names);
    }

}
