package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class KnightDialer_935 {
//    https://leetcode.com/problems/knight-dialer/
//    Input: n = 2
//    Output: 20
//    Explanation: All the valid number we can dial are [04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49, 60, 61, 67, 72, 76, 81, 83, 92, 94]

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int result = knightDialer(2);
        System.out.println(result);
    }

    public static int knightDialer(int N) {
        int[][] map = new int[][]{{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
        int[][] memo = new int[N + 1][10];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(memo[i], -1);
        }
        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += helper(N, i, map, memo);
            result %= (int)1e9 + 7;
        }
        return result;
    }

    private static int helper(int N, int start, int[][] map, int[][] memo) {
        if (N == 1) {
            return 1;
        }
        if (memo[N][start] > -1) {
            return memo[N][start];
        }
        memo[N][start] = 0;
        for (int next : map[start]) {
            memo[N][start] += helper(N - 1, next, map, memo);
            memo[N][start] %= (int)1e9 + 7;
        }
        return memo[N][start];
    }
}