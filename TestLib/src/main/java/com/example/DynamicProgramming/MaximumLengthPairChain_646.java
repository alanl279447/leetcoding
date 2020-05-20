package com.example.DynamicProgramming;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class MaximumLengthPairChain_646 {

//    Input: [[1,2], [2,3], [3,4]]
//    Output: 2
//    Explanation: The longest chain is [1,2] -> [3,4]
//    https://leetcode.com/problems/maximum-length-of-pair-chain/

    public static void main(String[] args) {
        int[][] prices = {{3,4}, {1,2}, {2,3}};
        System.out.print(findLongestChain(prices));
    }

    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b) -> a[1] - b[1]);  //sort in ascending order for second element..
        int ans = 0, curr = Integer.MIN_VALUE;
        for (int j = 0; j < pairs.length; j++) {
            if (curr < pairs[j][0]) {
                ans++;
                curr = pairs[j][1];
            }
        }
        return ans;
    }

//
//    private static int expandAroundCenter(String s, int left, int right) {
//        int L = left, R = right;
//        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
//            L--;
//            R++;
//        }
//        return R - L - 1;
//    }
//    public static String ans = null;
//    //public static int consecutive = null;
//    public static String longestPalindrome(String s) {
//        int length = s.length();
//
//        for (int i =0; i < length; i++) {
//            String size = palindromeLength(s, i-1, i+1);
//            ans =  (ans.length() - size.length() > 0 ? ans: size);
//        }
//        return ans;
//    }
//
//    public static String palindromeLength(String s, int left, int right) {
//        String value = verifyPalindrome(s, left,right);
//        return value;
//    }
//
//    public static String verifyPalindrome(String s, int left, int right) {
//        if (left < 0 && right >= s.length()) return "";
//
//        if (s.charAt(left) == s.charAt(right)) {
//            verifyPalindrome(s, --left, ++right);
//        }
//    }
}
