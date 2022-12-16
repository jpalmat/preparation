package javaPrep.sort;

import java.util.Random;

public class QuickSort extends GenerateList {
    public static void main(String[] args) {
        printArray(inputArray);

        System.out.println("after");
        quicksort(inputArray, 0, inputArray.length - 1);
        printArray(inputArray);
    }

    private static void quicksort(int[] inputArray, int lowIndex, int highindex) {
        if(lowIndex >= highindex) {
            return;
        }

        //choosing first or last
//        int pivot = inputArray[highindex];

        //choosing pivot random
//        int pivotIndex = new Random().nextInt(highindex - lowIndex)+lowIndex;
//        int pivot = inputArray[pivotIndex];
//        swap(inputArray, pivotIndex, highindex);

        //median of three
        int pivotIndex = (lowIndex + highindex)/2;
        int pivot = inputArray[pivotIndex];
        swap(inputArray, pivotIndex, highindex);

        int leftPointer = lowIndex;
        int rightPointer = highindex;

        while(leftPointer < rightPointer){
            while(inputArray[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while(inputArray[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            swap(inputArray, leftPointer, rightPointer);
        }
        swap(inputArray, leftPointer, highindex);

        quicksort(inputArray, lowIndex, leftPointer - 1);
        quicksort(inputArray, leftPointer + 1, highindex);
    }

    private static void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
