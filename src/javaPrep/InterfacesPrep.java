package javaPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterfacesPrep {
    public static void main(String[] args) {
        String[] a = new String[]{"a", "b"};
        List<String> l = new ArrayList<String>(Arrays.asList(a));
        l.add("c");
        System.out.println(l);

        Object[] test = l.toArray();
        for (Object string : test) {
            System.out.println(string);
        }
    }

}

interface InterfaceA {
    public abstract void method1();
    void method2();
}

abstract class ClassA implements InterfaceA {
    @Override
    public void method2() {

    }
}