package com.example.ArrayStrings;

public class ContainerWithMostWater_11 {

//    Input: [1,8,6,2,5,4,8,3,7]
//    Output: 49
//    https://leetcode.com/problems/container-with-most-water/

    public static void main(String args[]) {
        int[] input = {1,8,6,2,5,4,8,3,7};
        int res = maxArea(input);
        System.out.println(res);
    }

    public static int maxArea(int[] height) {
        int a_pointer = 0;
        int b_pointer = height.length-1;
        int maxArea = 0;

        if (height.length ==0) return 0;

        while(a_pointer < b_pointer) {
            if (height[a_pointer] < height[b_pointer]) {
                maxArea = Math.max(maxArea, height[a_pointer] * (b_pointer-a_pointer));
                a_pointer++;
            } else {
                maxArea = Math.max(maxArea, height[b_pointer] * (b_pointer-a_pointer));
                b_pointer--;
            }
        }
        return maxArea;
    }

}
