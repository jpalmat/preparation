package ITCCoderpad;

public class minimumInitialEnergyRequiredToCrossStreet {
    public static void main(String[] args) {
        int arr[] = {4, -10, 4, 4, 4};
        System.out.print(minInitialEnergy(arr));
    }

    /**
     * https://www.geeksforgeeks.org/minimum-initial-energy-required-to-cross-street/
     * @param arr
     * @return
     */
    public static int minInitialEnergy(int arr[]){
        int initialEnergy = 1, temp = arr[0];
        for(int i = 1; i < arr.length - 1; i++){
            temp += arr[i];
            if(temp<0){
                initialEnergy = -temp + 1;
                temp = 1;
            }
        }
        return initialEnergy;
    }
}