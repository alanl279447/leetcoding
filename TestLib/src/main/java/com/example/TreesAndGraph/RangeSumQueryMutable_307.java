package com.example.TreesAndGraph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
//        Given nums = [1, 3, 5]
//        sumRange(0, 2) -> 9
//        update(1, 2)
//        sumRange(0, 2) -> 8
//        https://leetcode.com/problems/range-sum-query-mutable/
public class RangeSumQueryMutable_307 {
    public static TreeNode root;
    private static TreeNode ans = null;

    public static void main(String[] args) {
        int[] nums = {1,3,5};
        NumArray obj = new NumArray(nums);
        obj.update(0,2);
        int param_2 = obj.sumRange(0,2);
    }

    static class NumArray {
        int[] fen; int[] arr;
        int n;
        public NumArray(int[] nums) {
            arr = nums;
            n = nums.length;
            fen = new int[n+1];
            init();
        }

        public void init(){
            if(n == 0) return;

            //fen[1] = arr[0];
            for(int i = 0; i < n; i++){
                fen[i+1] = fen[i] + arr[i];
            }
            for(int i = n; i >0 ; i--){
                int parent = i - (i & -i);
                if(parent >= 0) fen[i] -= fen[parent];
            }
            //System.out.println(Arrays.toString(fen));
        }

        //helper
        public int sum(int i){
            int res = 0;
            while(i > 0){
                res += fen[i];
                i = i - (i & -i);
            }
            return res;
        }

        //helper
        public void increment(int i, int val){
            i++;
            while(i <= n){
                fen[i] += val;
                i = i + (i & -i);  //go downwards to update
            }
        }

//        time complexity 0(logN)
        public void update(int i, int val) {
            int extra = val - arr[i];
            arr[i] = val;
            increment(i, extra);
        }

//        time complexity 0(logN)
        public int sumRange(int i, int j) {
            return sum(j+1) - sum(i);
        }
    }
}