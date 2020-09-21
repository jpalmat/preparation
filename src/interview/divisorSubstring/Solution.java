package interview.divisorSubstring;

public class Solution {
    public static void main(String[] args) {
        System.out.println(divisorSubstring(120, 2));
    }

    public static int divisorSubstring(int n, int k){
        String number = String.valueOf(n);

        if(number.length() < k)
            return 0;

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = 0; i<number.length(); i++){
            if(i + k > number.length())
                break;;
            sb.setLength(0);
            sb.append(number.substring(i, i + k));
            int numberInt = Integer.valueOf(sb.toString());
            if(n%numberInt==0)
                count++;
        }
        return count;
    }
}