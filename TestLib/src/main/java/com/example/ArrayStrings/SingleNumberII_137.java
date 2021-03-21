package com.example.ArrayStrings;

import java.util.HashSet;
import java.util.Set;

public class SingleNumberII_137 {

//    Input: [0,1,0,1,0,1,99]
//    Output: 99
//    https://leetcode.com/problems/single-number-ii/


    public static void main(String[] args) {
        int[] input = {2,1,2,1,2,1,99};
        System.out.println(singleNumberGeneralTest(input));
    }

    public static int singleNumberGeneralTest(int[] nums) {
        int ans = 0;
        for (int i=0; i < 32; i++) {  //for all the 32 bit get the count of 1's
            int sum = 0;
            for (int j=0; j < nums.length; j++) {
                if ((nums[j] >> i & 1) == 1) {
                    sum++;
                    sum %=3;   //keep only the count's not multiple of 3
                }
            }
            ans |= sum<<i;   //move the bit back to the original position
        }
        return ans;
    }

    //time 0(32n)
    public static int singleNumberGeneral(int[] nums) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            int sum = 0;
            for(int j = 0; j < nums.length; j++) {
                if(((nums[j] >> i) & 1) == 1) {
                    sum++;
                    sum %= 3;
                }
            }
            if(sum != 0) {
                ans |= sum << i;
            }
        }
        return ans;
    }

    //time 0(n), space 0(n)
    public static int singleNumber(int[] nums) {
        Set<Long> set = new HashSet<>();
        long sumArray = 0;
        for (int num:nums) {
            set.add((long)num);
            sumArray +=num;
        }
        int sSum = 0;
        for (Long s:set) {
            sSum += s;
        }
        return (int)(3*sSum - sumArray)/2;
    }

    //time 0(n), space 0(1)
    public int singleNumberFast(int[] A) {
        int ones = 0, twos = 0;
        for(int i = 0; i < A.length; i++){
            ones = (ones ^ A[i]) & ~twos;
            twos = (twos ^ A[i]) & ~ones;
        }
        return ones;
    }
}