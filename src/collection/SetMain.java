package collection;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetMain {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("zzz");
        set.add("bb");
        set.add("a");
        set.add("a");
        System.out.println(set);

        TreeSet<String> set1 = new TreeSet<>(Comparator.comparing(String::length).reversed());
        set1.add("zz");
        set1.add("bbbb");
        set1.add("aaa");
        System.out.println(set1.subSet("aaa", "zz"));
        System.out.println(set1.headSet("zz"));
    }
}
