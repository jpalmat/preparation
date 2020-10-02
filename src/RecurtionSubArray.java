import java.util.List;

public class RecurtionSubArray {
    public static boolean SplitRecursion(List<Integer> input) {
        // if(input.size()=2 && input.get(0)==input.get(1)){
        //     return true;
        // }
        int leftBucketSum = 0;
        int rightBucketSum = 0;

        //int[] leftBucket = new int[input.size()];
        //int[] rightBucket = new int[input.size()];
        return SplitHelper(input, 0 , leftBucketSum,rightBucketSum);

    }

    public static boolean SplitHelper(List<Integer> input, int index, int leftSum, int rightSum){

        int item = input.get(index);
        if (index >= input.size())
            return leftSum == rightSum;

        return SplitHelper(input, index, leftSum + item, rightSum) || SplitHelper(input, index, leftSum, rightSum + item);

    }

    public static void main(String[] args) {
        final int[] aa =new int[10];
        aa[0]=1;
        // aa=new int[24];
        System.out.println(aa);
    }
}
