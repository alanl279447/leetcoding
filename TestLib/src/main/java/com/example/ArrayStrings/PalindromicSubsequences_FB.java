package com.example.ArrayStrings;

//        Input: "abca"
//        Output: True
//        Explanation: You could delete the character 'c'.
//        https://leetcode.com/problems/valid-palindrome-ii/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PalindromicSubsequences_FB {

    // Driver program
    public static void main(String args[]) {
        Set<String> result = LongestPalindromeSubseq("aaaa");
        for (String res:result) {
            System.out.println(res);
        }
    }

    public static Set<String> LongestPalindromeSubseq(String s)
    {
        Set<String> result = new HashSet<>();
        int n = s.length();
        int[][] dp = new int[n][n];

        // len 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            result.add(s.substring(i,i+1));
        }

        // len 2
        for (int i = 0, j = 1; j < n; i++, j++) {
            if (s.charAt(i) == s.charAt(j)) {
                dp[i][j] = 2;
            } else {
                dp[i][j] = 1;
            }
        }

        // len 3 and up
        for (int len = 3; len <= n; len++)
        {
            for (int i = 0, j = len - 1; j < n; i++, j++)
            {
                // better of without left or without right
                int max = Math.max(dp[i][j-1], dp[i+1][j]);
                if (s.charAt(i) == s.charAt(j))
                {
                    // now check 2 plus without left and without right
                    max = Math.max(max, 2 + dp[i+1][j-1]);
                    result.add(s.substring(i, j+1));
                }
                dp[i][j] = max;
            }
        }

        //return dp[0][n-1];
        return result;
    }
}
