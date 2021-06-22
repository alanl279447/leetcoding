package com.example.ArrayStrings;

public class SingleNumberIII_260 {

//    Input: nums = [1,2,1,3,2,5]
//    Output: [3,5]
//    Explanation:  [5, 3] is also a valid answer.
//   https://leetcode.com/problems/single-number-iii/

    public static void main(String[] args) {
        int[] input = {1,2,1,3,2,5};
        System.out.println(singleNumber(input));
    }


    //No XOR No = 0
    //No XOR 0 = No
    //3 ^ 5 = 0011 ^ 0101 = 0110  = 6
    // 6 & -6
    //0110 &
    //1010
    //0010

    //first find the XOR of all the nums
    //find the lowest bit (x & -x)
    //bucket the numbers in two sets
    public static int[] singleNumber(int[] nums) {
        // Pass 1 :
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // Get its last set bit
        diff &= -diff;

        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums) {
            if ((num & diff) == 0) // the bit is not set
            {
                rets[0] ^= num;
            }
            else // the bit is set
            {
                rets[1] ^= num;
            }
        }
        return rets;
    }
}