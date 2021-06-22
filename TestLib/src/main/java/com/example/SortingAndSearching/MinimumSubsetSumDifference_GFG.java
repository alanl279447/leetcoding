package com.example.SortingAndSearching;

//        https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
//        Input:  arr[] = {1, 6, 11, 5}
//        Output: 1
//        Explanation:
//        Subset1 = {1, 5, 6}, sum of Subset1 = 12
//        Subset2 = {11}, sum of Subset2 = 11
//https://gist.github.com/SuryaPratapK/2d64d50aacc394a9dbe1e8797ebbf361
// same as PartitionEqualSubsetSum_416
public class MinimumSubsetSumDifference_GFG {

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        System.out.print(findMin(nums));
    }

    //equal subset problem where diff is minimum
    //dp array from 0 to n and subSet 0 to totalSum
    //1,6,11,5 - total == 23
    //dp[n+1][sum+1] dp[5][24]
    //dp[4][23] -- F, T, F,F,T,T,T...T,....T

    // Returns minimum possible difference between
    // sums of two subsets
    public static int findMin(int[] A) {
        int n = A.length;
        int sum = 0;
        for (int i = 0; i < n; ++i)
            sum += A[i];

        //Subset Sum Problem
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= sum; ++j) {
                if (j == 0)
                    dp[i][j] = true;     //true since we can form sum =0 by not selecting any element in j
                else if (i == 0)
                    dp[i][j] = false;   //false as we cannot form sum j with i=0 (zero elements)
                else if (j < A[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - A[i - 1]];
            }
        }
        int diff = Integer.MAX_VALUE;
        for(int i=0;i<=sum/2;++i) {
            int first = i;
            int second = sum-i;
            if(dp[n][i]==true && diff>Math.abs(first-second))
                diff = Math.abs(first-second);
        }
        return diff;
    }
}