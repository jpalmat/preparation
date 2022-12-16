package javaPrep.seach;

import javaPrep.GenerateList;

public class Quickselect extends GenerateList {

    public static void main(String[] args) {
        printArray(inputArray);

        System.out.println("the k smallest element is "+ ksmallest(inputArray, 0, inputArray.length - 1, 2));
    }

    private static int ksmallest(int[] inputArray, int lowIndex, int highIndex, int k) {
        int partition = partition(inputArray, lowIndex, highIndex);

        if(partition == k - 1) {
            return inputArray[partition];
        } else if (partition < k - 1 ) {
            return ksmallest(inputArray, partition + 1, highIndex, k);
        } else {
            return ksmallest(inputArray, lowIndex, partition - 1, k);
        }
    }

    private static int partition(int[] inputArray, int lowIndex, int highIndex) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        //median of three
        int pivotIndex = (lowIndex + highIndex)/2;
        int pivot = inputArray[pivotIndex];
        swap(inputArray, pivotIndex, highIndex);

        while(leftPointer < rightPointer) {
            while (inputArray[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (inputArray[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            swap(inputArray, leftPointer, rightPointer);
        }
        swap(inputArray, leftPointer, highIndex);
        return leftPointer;
    }

    private static void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}