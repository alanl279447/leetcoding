package com.example.ArrayStrings;

public class calculateStringFromBinary {

//    Input: str = “101110”
//    Output: 8
//
//    Number ‘101110’ is even, after dividing it by 2 we get an odd number ‘10111’ so we will add 1 to it.
//    Then we’ll get ‘11000’ which is even and can be divide three times continuously in a row and get ’11’
//    which is odd, adding 1 to it will give us ‘100’ which is even and can be divided 2 times in a row.
//    As, a result we get 1.
//    So 8 times the above two operations were required in this number.
//     https://www.geeksforgeeks.org/number-of-steps-required-to-convert-a-binary-number-to-one/

    public static void main(String[] args) {
        String s;
        s = "1010";
        System.out.println(calculate_(s));
    }

    //function to calculate the number of actions
    static int calculate_(String s)
    {
        // if the size of binary is 1
        // then the number of actions will be zero
        if (s.length() == 1)
            return 0;

        // initializing the number of actions as 0 at first
        int count_ = 0;
        char[] s1=s.toCharArray();
        for (int i = s.length() - 1; i > 0;) {
        // start traversing from the last digit
        // if its 0 increment the count and decrement i
        if (s1[i] == '0') {
            count_++;
            i--;
        }
        // if s[i] == '1'
        else {
            count_++;

            // stop until you get 0 in the binary
            while (s1[i] == '1' && i > 0) {
                count_++;
                i--;
            }
            if (i == 0)
                count_++;

            // when encounter a 0 replace it with 1
            s1[i] = '1';
        }
    }
        return count_;
    }

}
