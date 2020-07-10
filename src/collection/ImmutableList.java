package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ImmutableList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        System.out.println(list);
        list.add("c");
        System.out.println(list);
        List<String> a = Collections.unmodifiableList(list);
        a.add("d"); //error
        System.out.println(a);
    }
}
