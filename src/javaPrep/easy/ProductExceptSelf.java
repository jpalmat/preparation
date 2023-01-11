package javaPrep.easy;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] test = {1,2,3,4};
        productExceptSelf(test);
//        Arrays.stream(productExceptSelf(test)).forEach(x -> System.out.println(x));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int[] t1 = new int[nums.length];
        int[] t2 = new int[nums.length];

        t1[0]=1;
        t2[nums.length-1]=1;

        //scan from left to right
        for(int i=0; i<nums.length-1; i++){
            t1[i+1] = nums[i] * t1[i];
        }
        System.out.println("t1");
        Arrays.stream(t1).forEach(x -> System.out.println(x));

        //scan from right to left
        for(int i=nums.length-1; i>0; i--){
            t2[i-1] = t2[i] * nums[i];
        }

        System.out.println("t2");
        Arrays.stream(t2).forEach(x -> System.out.println(x));

        //multiply
        for(int i=0; i<nums.length; i++){
            result[i] = t1[i] * t2[i];
        }
        System.out.println("result");
        Arrays.stream(result).forEach(x -> System.out.println(x));

        return result;
    }
}