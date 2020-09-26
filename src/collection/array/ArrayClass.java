package collection.array;

import java.util.Arrays;
import java.util.Optional;

public class ArrayClass {
    public static void main(String[] args) {
        String[] alphabet = new String[]{"A", "B", "C"};
        System.out.println(arrayContains(alphabet));
    }

    public static boolean arrayContains(String[] arr){
        Optional<String> a = Arrays.stream(arr).filter(x-> x.equals("a")).findFirst();
        return a.isPresent();
    }
}
