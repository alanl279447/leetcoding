package com.example.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumCostMergeStones_1000 {

//    Input: stones = [3,2,4,1], K = 2
//    Output: 20
//    Explanation:
//    We start with [3, 2, 4, 1].
//    We merge [3, 2] for a cost of 5, and we are left with [5, 4, 1].
//    We merge [4, 1] for a cost of 5, and we are left with [5, 5].
//    We merge [5, 5] for a cost of 10, and we are left with [10].
//    The total cost was 20, and this is the minimum possible.
//
//    Input: stones = [3,5,1,2,6], K = 3
//    Output: 25
//    Explanation:
//    We start with [3, 5, 1, 2, 6].
//    We merge [5, 1, 2] for a cost of 8, and we are left with [3, 8, 6].
//    We merge [3, 8, 6] for a cost of 17, and we are left with [17].
//    The total cost was 25, and this is the minimum possible.
//
//    https://leetcode.com/problems/minimum-cost-to-merge-stones/

    public static void main(String[] args) {
        int[] prices = {3, 2, 4, 1};
        System.out.print(mergeStones(prices, 2));
    }
        private static Integer[][][] memo;
        private static int[] preSum;

        public static int mergeStones(int[] stones, int K) {
            if (stones == null || stones.length == 0) return -1;

            int n = stones.length;
            if (n == 1) return 0;
            preSum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                preSum[i + 1] = preSum[i] + stones[i];
            }

            if (n == K) {
                return preSum[n];
            }

            if ((n - 1) % (K - 1) != 0) return -1;

            memo = new Integer[n][n][K + 1];
            for (int i = 0; i < n; i++) {
                memo[i][i][1] = 0;
            }

            return calculate(stones, 0, n - 1, 1, K);
        }

        private static int calculate(int[] stones, int i, int j, int piles, int K) {
            if ((j - i + 1 - piles) % (K - 1) != 0) {
                return Integer.MAX_VALUE;
            }
            if (memo[i][j][piles] != null) {
                return memo[i][j][piles];
            }
            int cost = Integer.MAX_VALUE;
            if (piles == 1) {
                int prev = calculate(stones, i, j, K, K);
                if (prev != Integer.MAX_VALUE) {
                    cost = prev + preSum[j + 1] - preSum[i];
                }
            } else {
                for (int mid = i; mid < j; mid++) {
                    int left = calculate(stones, i, mid, 1, K);
                    if (left >= cost) continue;
                    int right = calculate(stones, mid + 1, j, piles - 1, K);
                    if (right >= cost) continue;
                    cost = Math.min(cost, left + right);
                }
            }
            memo[i][j][piles] = cost;
            return cost;
        }
}
