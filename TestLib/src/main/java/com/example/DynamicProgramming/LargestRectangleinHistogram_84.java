package com.example.DynamicProgramming;

import java.util.Stack;

public class LargestRectangleinHistogram_84 {

//    Input: [2,1,5,6,2,3]
//    Output: 10
//    https://leetcode.com/problems/largest-rectangle-in-histogram/

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.print(largestRectangleArea(heights));
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
