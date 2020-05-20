package com.example.ArrayStrings;

public class ToeplitzMatrix_766 {
//    Input:
//    matrix = [
//            [1,2,3,4],
//            [5,1,2,3],
//            [9,5,1,2]
//            ]
//    Output: True
//    Explanation:
//    In the above grid, the diagonals are:
//            "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
//    In each diagonal all elements are the same, so the answer is True.
//    https://leetcode.com/problems/toeplitz-matrix/

    public static void main(String[] args) {
        int[][] nums = {{1,2,3,4}, {5,1,2,3}, {9,5,1,2}};
        boolean peakIndex = isToeplitzMatrix(nums);
        System.out.println(peakIndex);
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length; ++r)
            for (int c = 0; c < matrix[0].length; ++c)
                if (r > 0 && c > 0 && matrix[r-1][c-1] != matrix[r][c])
                    return false;
        return true;
    }
}
