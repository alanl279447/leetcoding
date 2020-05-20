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


//   24 12 4  1  rightSum
//
//    1 2  3  4
//
//    1 1  2  6  leftSum
//
//    24 12 8 6   result

    public static int[] productExceptSelf(int[] inputs) {
        int[] leftSum = new int[inputs.length];
//        int[] rightSum = new int[inputs.length];
//        int[] result = new int[inputs.length];

        leftSum[0] = 1;
        for (int i = 1; i < inputs.length; i++) {
            leftSum[i] =  leftSum[i-1] * inputs[i-1];
        }

//        rightSum[inputs.length-1] = 1;
        int rightSum = 1;
        for (int i = inputs.length-1; i >=0; i--) {
//            rightSum[i] = rightSum[i+1] * inputs[i+1];

            leftSum[i]  *= rightSum;
             rightSum *= inputs[i];
        }

        return leftSum;
    }


//    public static int[] productExceptSelf(int[] nums) {
//        int length = nums.length;
//        int[] output = new int[length];
//
//        output[0]=1;
//        for (int i=1; i < nums.length; i++) {
//            output[i] = nums[i-1] * output[i-1];
//        }
//
//        int R = 1;
//        for (int j = length-1; j >= 0; j--) {
//            output[j] = output[j] * R;
//            R = R * nums[j];
//        }
//        return output;
//    }
}
