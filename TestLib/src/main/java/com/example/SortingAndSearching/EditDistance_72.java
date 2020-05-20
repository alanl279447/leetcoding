package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class EditDistance_72 {
//    Input: word1 = "intention", word2 = "execution"
//    Output: 5
//    Explanation:
//    intention -> inention (remove 't')
//    inention -> enention (replace 'i' with 'e')
//    enention -> exention (replace 'n' with 'x')
//    exention -> exection (replace 'n' with 'c')
//    exection -> execution (insert 'u')
//    https://leetcode.com/problems/edit-distance/
//   time complexity 0(mn)

    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        System.out.print(minDistance("intention", "execution")); //abac, abca
    }

    public static int minDistance(String word1, String word2) {
      int[][] dp = new int[word1.length()+1][word2.length()+1];

      for (int i=0;i<word1.length();i++) {
          dp[0][i] = i;
      }

      for (int j=0;j<word2.length();j++) {
          dp[j][0]=j;
      }

      for (int i=0; i< word1.length();i++) {
          for (int j=0; j<word2.length(); j++) {
              if (word1.charAt(i)==word2.charAt(j)) {
                  dp[i+1][j+1]=dp[i][j];
              } else {
                  dp[i+1][j+1]=Math.min(dp[i][j], Math.min(dp[i][j+1], dp[i+1][j]));
              }
          }
      }
      return dp[word1.length()][word2.length()];
    }
}
