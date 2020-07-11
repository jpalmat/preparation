package collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapMain {
    public static void main(String[] args) {
        Map<String, String> mapHashMap = new HashMap<>();
        mapHashMap.put("2", "2");
        mapHashMap.put("1", "1");
        System.out.println(mapHashMap.get("2"));
        System.out.println(mapHashMap.getOrDefault("3", "4"));
        mapHashMap.putIfAbsent("2", "3");
        System.out.println(mapHashMap.get("2"));
    }
}
