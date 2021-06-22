package com.example.DynamicProgramming;

//Input: mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
//Output: [[12,21,16],[27,45,33],[24,39,28]]
//https://leetcode.com/problems/matrix-block-sum/

public class MatrixBlockSum_1314 {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.print(matrixBlockSum(mat, 1));
    }

    //  1  2  3
    //  4  5  6
    //  7  8  9

    // 0  0  0  0
    // 0  1  3  6
    // 0  5  12 21
    // 0  12 27 45

    //https://leetcode.com/problems/matrix-block-sum/discuss/477041/Java-Prefix-sum-with-Picture-explain-Clean-code-O(m*n)
    public static int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length, n = mat[0].length;
        int[][] sum = new int[m + 1][n + 1]; // sum[i][j] is sum of all elements from rectangle (0,0,i,j) as left, top, right, bottom corresponding
        for (int r = 1; r <= m; r++) {
            for (int c = 1; c <= n; c++) {
                sum[r][c] = mat[r - 1][c - 1] + sum[r - 1][c] + sum[r][c - 1] - sum[r - 1][c - 1];  //-1 to take care of zero first row & column
            }
        }
        int[][] ans = new int[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int r1 = Math.max(0, r - K);
                int c1 = Math.max(0, c - K);
                int r2 = Math.min(m - 1, r + K);
                int c2 = Math.min(n - 1, c + K);
                r1++; c1++; r2++; c2++; // Since `sum` start with 1 so we need to increase r1, c1, r2, c2 by 1
                ans[r][c] = sum[r2+1][c2+1] - sum[r2+1][c1] - sum[r1][c2+1] + sum[r1][c1];
            }
        }
        return ans;
    }
}