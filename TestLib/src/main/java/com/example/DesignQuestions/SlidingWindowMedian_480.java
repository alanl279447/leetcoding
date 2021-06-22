package com.example.DesignQuestions;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
public class SlidingWindowMedian_480 {

//    For example,
//    Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
//    Window position                Median
//---------------               -----
//        [1  3  -1] -3  5  3  6  7       1
//        1 [3  -1  -3] 5  3  6  7       -1
//        1  3 [-1  -3  5] 3  6  7       -1
//        1  3  -1 [-3  5  3] 6  7       3
//        1  3  -1  -3 [5  3  6] 7       5
//        1  3  -1  -3  5 [3  6  7]      6
//    https://leetcode.com/problems/sliding-window-median/
//Time complexity: O(2 n log k) + O(n-k)  ≈ O(nlogk).

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        double[] result = medianSlidingWindow(nums, k);
        for (double res:result)
          System.out.println(res);
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        int j= 0;
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            max.add(nums[i]);
            min.add(max.poll());
            if(min.size()>max.size()){
                max.add(min.poll());
            }
            if (max.size() + min.size() == k) {
                double median;
                if(max.size() == min.size()) {
                    median = (double) ((long)max.peek() + (long)min.peek()) / 2;
                } else {
                    median = (double) max.peek();
                }

                int start = i - k + 1;
                result[start] = median;
                if (nums[start]<= max.peek()) {
                    max.remove(nums[start]);
                } else {
                    min.remove(nums[start]);
                }
            }
        }
        return result;
    }
}