package ITCCoderpad;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(maxWater(arr));
    }

    public static int maxWater(int[] arr) {
        int[] left = new int[arr.length];
        int[] rigth = new int[arr.length];
        int water =0;
        left[0]= arr[0];
        for(int i = 1; i < arr.length; i++){
            left[i] = Math.max(left[i-1], arr[i]);
        }

        rigth[arr.length - 1] = arr[arr.length - 1];
        for(int i = arr.length - 2; i>=0; i--){
            rigth[i] = Math.max(rigth[i+1], arr[i]);
        }

        for(int i = 0; i < arr.length; i++){
            water += Math.min(left[i], rigth[i])- arr[i];
        }
        return water;
    }
}