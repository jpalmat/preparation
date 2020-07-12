package hackerRank.interviewpreparationkit.warmup.jumpingclouds;

public class JumpingontheClouds {
    public static void main(String[] args) {
        System.out.println(jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 0}));
    }

    static int jumpingOnClouds(int[] c) {
        int jumps = 0;
        for(int i = 0; i < c.length; i++){
            if(i!=0 && c[i]==0){
                jumps++;
            }
            if(i<c.length-2 && c[i+2]==0)
                i++;
        }
        return jumps;
    }
}
