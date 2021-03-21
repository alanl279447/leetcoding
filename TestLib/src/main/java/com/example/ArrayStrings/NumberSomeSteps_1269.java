package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberSomeSteps_1269 {
//    https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/
//    Input: steps = 3, arrLen = 2
//    Output: 4
//    Explanation: There are 4 differents ways to stay at index 0 after 3 steps.
//            Right, Left, Stay
//            Stay, Right, Left
//    Right, Stay, Left
//            Stay, Stay, Stay

//    Stay. Then we consume one step and stay at the same position => dp[steps-1][position]
//    Go right. Then we consume one step and go right => dp[steps-1][position+1]
//    Go left (if not at position zero). Then we consume one step and go left => if position > 0 then dp[steps-1][position-1]

    public static void main(String args[]) {
        int res = numWays(3, 2);
        System.out.println(res);
    }

    public static int numWays(int steps, int arrLen) {
        int maxPos = Math.min(steps,arrLen);
        long[][] dp = new long[steps+1][maxPos+1];

        dp[1][0]=1;
        dp[1][1]=1;
        for(int i = 2; i <= steps; i++) {
            for(int j = 0; j < maxPos; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i-1][j+1] + (j>0?dp[i-1][j-1]:0))%1000000007;
            }
        }
        return (int)dp[steps][0];
    }
}