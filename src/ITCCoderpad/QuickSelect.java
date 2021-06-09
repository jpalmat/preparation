package ITCCoderpad;

public class QuickSelect {
    // Driver Code
    public static void main(String[] args) {
        int[] arr = {10, 4, 6};
        int ksmall = 2;
        System.out.println(kSmallest(arr, 0, arr.length - 1, ksmall-1));
    }

    public static int kSmallest(int[] arr, int low, int top, int ksamll) {
        int pivot = partitionArray(arr, low, top);
        if(pivot == ksamll)
            return arr[pivot];
        else if(pivot<ksamll){
            return kSmallest(arr, pivot + 1, top, ksamll);
        } else {
            return kSmallest(arr, low, pivot-1, ksamll);
        }

    }

    private static int partitionArray(int[] arr, int low, int top) {
        int pivot = arr[top], index=low;

        for(int i = low; i <= top; i++){
            if(arr[i]< pivot){
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                index++;
            }
        }

        int temp = arr[top];
        arr[top] = arr[index];
        arr[index]=temp;
        return index;
    }
}