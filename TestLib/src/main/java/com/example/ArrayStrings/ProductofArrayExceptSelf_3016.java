package com.example.ArrayStrings;

//        Input:  [1,2,3,4]
//        Output: [24,12,8,6]
//        https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/3016/

//Time complexity 0(N)
//space complexity 0(1)

public class ProductofArrayExceptSelf_3016 {

    public static void main(String[] args) {
        int[] input = {1,2,3,4};

        int[] result = productExceptSelf(input);
        for(int res: result) {
            System.out.println(res);
        }
    }

//    public static int[] productExceptSelfTest(int[] inputs) {
//        if (inputs == null || inputs.length == 0) return new int[]{0};
//        int len = inputs.length;
//        int[] output = new int[len];
//        output[0] =1;
//        for (int i=1; i < len; i++) {
//            output[i] = output[i-1]*inputs[i-1];  //leftSum
//        }
//        int R = 1;
//        for (int j = len-1; j >=0;j--) {
//            output[j] = output[j] * R;
//            R = R * inputs[j];
//        }
//        return output;
//    }

    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] output = new int[length];
//        int[] left_positions = new int[length];
//        int[] right_positions = new int[length];
//
//        left_positions[0]=1;
//        right_positions[length-1]=1;

        output[0]=1;
        for (int i=1; i < nums.length; i++) {
            output[i] = nums[i-1] * output[i-1];
        }

        int R = 1;
        for (int j = length-1; j >= 0; j--) {
            output[j] = output[j] * R;
            R = R * nums[j];
        }

//        for (int i=0; i < length; i++) {
//         output[i] = left_positions[i] * right_positions[i];
//        }

        return output;
    }

//        R = 1
//   24 12 4  1  rightSum
//    1 2  3  4
//
//    1 1  2  6  leftSum
//
//    24 12 8 6   result
}