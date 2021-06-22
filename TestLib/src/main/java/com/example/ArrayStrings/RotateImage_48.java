package com.example.ArrayStrings;

public class RotateImage_48 {
//    https://leetcode.com/problems/rotate-image/
//    Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//    Output: [[7,4,1],[8,5,2],[9,6,3]]
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        rotate(matrix);
        System.out.println("done");
    }

    // 1 2 3
    // 4 5 6
    // 7 8 9

    //1 4 7
    //2 5 8
    //3 6 9

    //7 4 1
    //8 5 2
    //9 6 3


    public static void rotate(int[][] matrix) {
        //transpose the matrix
        //transpose the matrix
        int N = matrix.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //reverse the row items
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < N / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][N - 1 - j];
                matrix[i][N - 1 - j] = temp;
            }
        }
    }
}