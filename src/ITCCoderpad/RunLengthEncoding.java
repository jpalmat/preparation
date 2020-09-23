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
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) == str.charAt(i-1)) {
                count++;
                if(i != str.length() - 1)
                    continue;
            }
            sb.append(str.charAt(i-1)).append(count);
            count = 1;
        }
        return sb.toString();
    }
}