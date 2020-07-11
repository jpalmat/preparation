package collection.map;

import java.util.TreeMap;

public class TreeMapmain {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(3, "val3");
        map.put(2, "val2");
        map.put(1, "val1");
        map.put(5, "val5");
        map.put(4, "val4");

        System.out.println(map.headMap(3));
    }
}
