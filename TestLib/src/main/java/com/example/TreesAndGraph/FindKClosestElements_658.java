package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindKClosestElements_658 {

//    Input: [1,2,3,4,5], k=4, x=3
//    Output: [1,2,3,4]
//    https://leetcode.com/problems/find-k-closest-elements/
//    0(logn + K)
//    O(logn) is for the time of binary search, while O(k)O(k) is for shrinking the index range to k elements.

    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5};
//        int[] nums = {0,0,0,0,2,3,4};
        List<Integer> result = findClosestElements(nums, 2,1);
        for (Integer res: result) {
            System.out.println(res);
        }
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
         List<Integer> result = new ArrayList<>();
         int left =0;
         int right = arr.length-1;
         while(right-left >= k) {
          if (Math.abs(arr[left] -x) > Math.abs(arr[right] -x)) {
              left++;
          } else {
              right--;
          }
         }
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}