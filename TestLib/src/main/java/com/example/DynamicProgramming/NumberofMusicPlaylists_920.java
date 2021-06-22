package com.example.DynamicProgramming;

import java.util.Arrays;

public class NumberofMusicPlaylists_920 {

//    https://leetcode.com/problems/number-of-music-playlists/
//    Input: N = 3, L = 3, K = 1
//    Output: 6
//    Explanation: There are 6 possible playlists. [1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1].

    public static void main(String[] args) {
//        int res = numMusicPlaylists(3, 3, 1);
        int res = numMusicPlaylistsDP(1, 3, 0);
        System.out.println(res);
    }

   //dp[i - 1][j - 1] * (N - j + 1) song picked for the first time
   //dp[i-1][j] * max(j-K, 0) ways (j of them, except the last K ones played are banned.)
    //https://leetcode.com/problems/number-of-music-playlists/solution/


//    static int MOD = 1000000007;
//    public static int numMusicPlaylists(int N, int L, int K) {
//        int[][] dp = new int[L+1][N+1];
//        for (int i = 0; i < dp.length;i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        return solve(dp, N, L, K, 0, 0);
//    }
//
//    public static int solve(int[][] dp, int N, int L, int k, int len, int num) {
//        if (len == L || num == N) return (num == N) ? 1 : 0;
//
//        if (dp[L][N] != -1) {
//            return dp[L][N];
//        }
//
//        int ans = 0;
//        ans = (solve(dp, N, L, k, len + 1, num) * Math.max(0, num - k)) % MOD;       //reuse existing song
//        ans += (solve(dp, N, L, k, len + 1, num + 1) * Math.max(0, N - num)) % MOD;   //new song
//
//        dp[len][num] = ans;
//        return ans;
//    }

    //dp[i][j] = dp[i-1][j-1] * (N - (j-1))   new song
    //dp[i][j] = dp[i-1][j] * (j-k)   existing song

    public static int numMusicPlaylistsDP(int N, int L, int K) {
        int mod = (int)Math.pow(10, 9) + 7;
        long[][] dp = new long[L+1][N+1];
        dp[0][0] = 1;
        for (int i = 1; i <= L; i++){
            for (int j = 1; j <= N; j++){
                dp[i][j] = (dp[i-1][j-1] * (N - (j-1)))%mod;  //pick a new song
                if (j > K){
                    dp[i][j] = (dp[i][j] + (dp[i-1][j] * (j-K))%mod)%mod;   //existing song with K condition
                }
            }
        }
        return (int)dp[L][N];
    }
}