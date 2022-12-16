package javaPrep;

import java.util.Random;

public class GenerateList {
    protected static int[] inputArray = new int[10];

    static {
        Random rand = new Random();
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = rand.nextInt(10000);
        }
    }

    protected static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
