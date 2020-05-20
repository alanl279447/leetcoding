package com.example.ArrayStrings;

public class MainTesting {

//    public static void main(String[] args) {
//        NumArray_RangeSum rangeSum = new NumArray_RangeSum(new int[]{0, 1, 1, 1, 0, 0});
//        System.out.println("sumRange 0-3: " +rangeSum.sumRange(0,3));
//        System.out.println("sumRange 0-0: " +rangeSum.sumRange(0,0));
//        System.out.println("sumRange 3-5: " +rangeSum.sumRange(3,5));
//    }

    static int[] arr = {0,1,1,1,0,0};
    static int[] preSum = new int[arr.length + 1];

    public static void main(String[] args) {
        for(int i=1;i<preSum.length;i++) {
            if(arr[i-1] == 1)
                preSum[i] = preSum[i-1] + 1;
            else
                preSum[i] = preSum[i-1];
        }
        System.out.println(howManyOnesInRage(3, 5));
    }

    private static int howManyOnesInRage(int i, int j) {
        return preSum[j+1] - preSum[i];
    }
}
