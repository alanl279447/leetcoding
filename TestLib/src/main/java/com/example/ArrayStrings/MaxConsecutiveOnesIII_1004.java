package com.example.ArrayStrings;


//Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//        Output: 6
//        Explanation:
//        [1,1,1,0,0,1,1,1,1,1,1]
//        Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined
//        https://leetcode.com/problems/max-consecutive-ones-iii/
public class MaxConsecutiveOnesIII_1004 {

    public static void main(String[] args) {
        int[] input = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println("Longest subString is: "+longestOnes(input, 2));
    }

//    public static int longestOnesPrac(int[] A, int K) {
//
//    }

    public static int longestOnes(int[] A, int K) {
        int start =0, end =0, length = A.length;
        while(end < length) {
          if (A[end] == 0) {
              K--;
          }
          end++;
          if (K < 0) {
              if (A[start] == 0) {
                  K++;
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
