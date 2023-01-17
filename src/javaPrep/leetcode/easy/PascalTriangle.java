package javaPrep.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        inner.add(1);
        result.add(inner);

        for (int i = 1; i < numRows; i++){
            List<Integer> actual = new ArrayList<>();
            actual.add(1);
            for (int j = 0; j < inner.size() - 1; j++) {
                actual.add(inner.get(j) + inner.get(j + 1));
            }
            actual.add(1);
            result.add(actual);
            inner = actual;
        }
        return result;
    }
}