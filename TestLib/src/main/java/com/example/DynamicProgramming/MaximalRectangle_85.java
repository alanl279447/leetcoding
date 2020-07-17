package com.example.DynamicProgramming;

import java.util.Stack;

public class MaximalRectangle_85 {

//    Input:
//            [
//            ["1","0","1","0","0"],
//            ["1","0","1","1","1"],
//            ["1","1","1","1","1"],
//            ["1","0","0","1","0"]
//            ]
//    Output: 6
//    https://leetcode.com/problems/maximal-rectangle/
//   time complexity 0(n^2).

    public static void main(String[] args) {
        char[][] a = {};
        System.out.print(maximalRectangle(a));
    }

    public static int maximalRectangle(char[][] matrix) {
        if(matrix.length==0) return 0;
        // for each cell with value=1, we look upward (north), the number of continuous '1' is the height of cell
        int[] heights = new int[matrix[0].length];
        int maxArea=-1;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]=='0'){
                    heights[j] = 0;
                } else {
                    heights[j] ++;
                }
            }
            int area = largestRectangleArea(heights);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++){
            int h = (i == len ? 0 : heights[i]);
            if (s.isEmpty() || h >= heights[s.peek()]) {
                s.push(i);
            } else {
                int tp = s.pop();
                maxArea = Math.max(maxArea, heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }
}
