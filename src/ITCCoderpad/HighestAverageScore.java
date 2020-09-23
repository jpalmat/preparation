package ITCCoderpad;

public class HighestAverageScore {
    public static void main(String[] args) {
        String [][] scores = {{"jerry","65"},{"bob","91"}, {"jerry","23"}, {"Eric","83"}};
        System.out.println(findMax(scores));
    }

    public static int findMax(String[][] scores){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<scores.length; i++){
            if(Integer.valueOf(scores[i][1])>max){
                max = Integer.valueOf(scores[i][1]);
            }
        }
        return max;
    }
}
