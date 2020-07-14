package hackerRank.interviewpreparationkit.arrays.minimumswaps2;

import java.util.Arrays;

public class MinimumSwaps2 {
    static int times = 0;
    public static void main(String[] args) {
        System.out.println(minimumSwaps(new int[]{2, 3, 4, 1 ,5}));
    }

//    static void swap(int[] array,int left, int right){
//        int temp = array[right];
//        array[right] = array[left];
//        array[left] = temp;
//    }

    static int minimumSwaps(int[] arr) {
        int rightPointer = arr.length -1;

        int count = 0;
        int minimumSwaps = 0;

        while(count < arr.length){
            int arrValue = count+1;

            if(arr[count] == arrValue){
                count++;
                continue;
            }

            while(arr[rightPointer] != arrValue){
                rightPointer --;
            }

            if(rightPointer != count){
                minimumSwaps++;
                int temp = arr[rightPointer];
                arr[rightPointer] = arr[count];
                arr[count] = temp;
            }

            rightPointer = arr.length -1;
            count++;
        }
        return minimumSwaps;
    }
}
