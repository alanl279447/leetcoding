package com.example.ArrayStrings;

//Input: [1,0,1,1,0]
//        Output: 4
//        Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
//        After flipping, the maximum number of consecutive 1s is 4.
//        https://leetcode.com/problems/max-consecutive-ones-ii/
public class MaxConsecutiveOnesII_487 {

    public static void main(String[] args) {
        int[] input = {1,0,1,1,0};
        System.out.println("Longest subString is: "+findMaxConsecutiveOnes(input));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int start=0, end=0, length = nums.length, k=1;
        while(end < length) {
           if (nums[start]==0){
               k--;
           }
           end++;
           if (k<0) {
               if (nums[start]==0) {
                   k++;
               }
               start++;
           }
        }
        return end-start;
    }


    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) return 0;
        int[] map = new int[128];
        int start = 0, end = 0, len = 0, counter = 0;

        while (end < s.length()) {
            char c = s.charAt(end);
            map[c]++;
            if (map[c] > 1) counter++;
            end++;

            while (counter > 0) {
                char b = s.charAt(start);
                if (map[b] > 1) counter--;
                map[b]--;
                start++;
            }
            len = Math.max(len, end-start);
        }
        return len;
    }

}
