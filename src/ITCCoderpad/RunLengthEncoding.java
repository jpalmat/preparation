package ITCCoderpad;

import java.util.HashMap;
import java.util.Map;

public class RunLengthEncoding {

    public static void main(String[] args) {
        System.out.println(printRLE("wwwwaaadexxxxxx"));
    }

    /**
     * https://www.geeksforgeeks.org/run-length-encoding/
     * @param str
     * @return
     */
    public static String printRLE(String str)
    {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i = 0; i < str.length(); i++){
            while(i < str.length()-1){
                if(str.charAt(i) != str.charAt(i+1)) {
                    break;
                }
                count++;
                i++;
            }
            sb.append(str.charAt(i)).append(count);
            count = 1;
        }
        return sb.toString();
    }
}