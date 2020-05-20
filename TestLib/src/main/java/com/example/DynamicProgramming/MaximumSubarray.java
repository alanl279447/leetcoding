package com.example.DynamicProgramming;

public class MaximumSubarray {

//    Input: [-2,1,-3,4,-1,2,1,-5,4],
//    Output: 6
//    Explanation: [4,-1,2,1] has the largest sum = 6.

    public static void main(String[] args) {
        int[] prices = {-2,1,-3,4,-1,2,1,-5,4};
//        int[] prices = {1};
        System.out.print(maxSubArray(prices));
    }

    public static int maxSubArray(int[] nums) {
        int currNum = nums[0], maxNumber = nums[0];
        for (int i=1; i <nums.length; i++) {
            currNum = Math.max(nums[i], nums[i]+currNum);
            maxNumber = Math.max(currNum, maxNumber);
        }
        return maxNumber;
    }

//    public static int maxSubArray(int[] nums) {
//        int n = nums.length;
//        int currSum = nums[0], maxSum = nums[0];
//
//        for(int i = 1; i < n; ++i) {
//            currSum = Math.max(nums[i], currSum + nums[i]);
//            maxSum = Math.max(maxSum, currSum);
//        }
//        return maxSum;
//    }

//    public static String longestPalindrome(String s) {
//        if (s == null || s.length() < 1) return "";
//        int start = 0, end = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int len1 = expandAroundCenter(s, i, i);
//            int len2 = expandAroundCenter(s, i, i + 1);
//            int len = Math.max(len1, len2);
//            if (len > end - start) {
//                start = i - (len-1) / 2;
//                end = i + len / 2;
//            }
//        }
//        return s.substring(start, end + 1);
//    }
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
