package interview.altimtrick;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Given a list of digits, build the smallest number you can construct with those digits
 Digits: 8, 7, 1   (in array/list of integers format)
    * Answer: “178”   (in string format)
* Digits: 0, 0, 7
    * Answer: “7”
 */
public class SmallestDigits {


    static int smallest(int num)
    {
        // initialize frequency of each digit to Zero
        int[] freq = new int[10];

        // count frequency of each digit in the number
        while (num > 0)
        {
            int d = num % 10; // extract last digit
            freq[d]++; // increment counting
            num = num / 10; //remove last digit
        }

        // Set the LEFTMOST digit to minimum expect 0
        StringBuilder result = new StringBuilder();
        for (int i = 1 ; i <= 9 ; i++)
        {
            if (freq[i] != 0)
            {
                result.append(i);
                freq[i]--;
                break;
            }
        }

        // arrange all remaining digits
        // in ascending order
        for (int i = 0 ; i <= 9 ; i++)
            while (freq[i] != 0) {
                result.append(i);// = result * 10 + i;
                freq[i]--;
            }

        return Integer.valueOf(result.toString());// result;
    }

    // Driver Program
    public static void main(String args[])
    {
        int num = 570107;
        System.out.println(smallest(num));
    }

}
