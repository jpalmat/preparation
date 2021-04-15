package collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortCollections {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Jim", "Maryam", "Lucasssssss");

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        Collections.sort(list, (String s1, String s2)-> s2.length()-s1.length());
        System.out.println(list);
    }
}
