package com.example.DynamicProgramming;

public class DecodeWays_91 {

//    Input: "226"
//    Output: 3
//    Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
//    https://leetcode.com/problems/decode-ways/

//    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int res = numDecodings("226");
        //System.out.println(res);
        System.out.println("234".substring(1,2));
        System.out.println("234".substring(0,2));
        System.out.println("234".substring(0,3));
    }

    //space complexity 0(n)
    public static int numDecodings(String s) {
      int[] dp = new int[s.length()+1];
      dp[0] = 1;
      dp[1] = s.charAt(0) =='0' ? 0:1;

      for (int i = 2; i <= s.length(); i++) {
        int first = Integer.parseInt(s.substring(i-1, i));
        int second = Integer.parseInt(s.substring(i-2, i));

        if (first >=1) {
            dp[i] += dp[i-1];
        }
        if (second >= 10 && second <= 26) {
            dp[i] += dp[i-2];
        }
      }
      return dp[s.length()];
    }

//    public static int numDecodingsOptimized(String s) {
//
//        int firstIndex, secondIndex;
//        firstIndex = 1;
//        secondIndex = s.charAt(0) =='0' ? 0:1;
//
//        for (int i = 2; i <= s.length(); i++) {
//            int first = Integer.parseInt(s.substring(i-1, i));
//            int second = Integer.parseInt(s.substring(i-2, i));
//
//            int current = 0;
//            if (first >=1) {
//                current += secondIndex;
//            }
//            if (second >= 10 && second <= 26) {
//                current += firstIndex;
//            }
//            firstIndex = secondIndex;
//            secondIndex = current;
//        }
//        return secondIndex;
//    }



}
