package com.example.uber;

//Q3. Rotate n * m matrix clockwise k times around main diagonals. i.e keep items on main diagonals as it is.
//https://leetcode.com/discuss/interview-question/928723/Uber-or-OA-or-CodeSignal

public class RotateAlongTheMainDiagonal {
    // Driver code
    public static void main(String[] args) {
        int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
//        System.out.println(cntSubarrays(arr, n));
        rotate(arr, 4);
        System.out.println();
    }

    public static void rotate(int[][] matrix, int k) {
        for (int i =0; i < k; i++) {
            rotate(matrix);
        }
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i ++) {
            for (int j = 0; j < n / 2; j++) {
               if (i != j && n-j-1 != n-i-1) {
                   int temp = matrix[n - 1 - j][i];
                   matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                   matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];
                   matrix[j][n - 1 - i] = matrix[i][j];
                   matrix[i][j] = temp;
               }
            }
        }
    }
}