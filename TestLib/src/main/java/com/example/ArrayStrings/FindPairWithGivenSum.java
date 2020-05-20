package com.example.ArrayStrings;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//        Input: nums = [1, 10, 25, 35, 60], target = 90
//        Output: [2, 3]
//        Explanation:
//        nums[2] + nums[3] = 25 + 35 = 60 = 90 - 30
//        https://leetcode.com/discuss/interview-question/356960
public class FindPairWithGivenSum {

    public static void main(String[] args) {

        int[] nums = {1,10,25,35,60};
        int target = 90;
        int[] result = Find2Sum(nums, target-30);
        System.out.print(Arrays.toString(result));
    }

    private static int[] Find2Sum(int[] nums, int total) {
        int[] res = new int[] {-1, -1};
        Map<Integer, Integer> map = new HashMap<>();
        int MAX = Integer.MIN_VALUE;

        for (int i =0; i <nums.length; i++) {
          if (map.containsKey(nums[i])) {
              if (nums[i] > MAX || nums[map.get(nums[i])] > MAX) {
                res[0] = i;
                res[1] = map.get(nums[i]);
                MAX = Math.max(nums[i], nums[map.get(nums[i])]);
              }
          }
          map.put(total-nums[i], i);
        }
       return res;
    }

//    private static int[] Find2Sum(int[] nums, int target) {
//        Map<Integer, Integer> map = new HashMap<>();
//        int max = Integer.MIN_VALUE;
//        int[] res = new int[] {-1, -1};
//        for(int i=0;i<nums.length;i++) {
//            if(map.containsKey(nums[i])) {
//                if(nums[i] > max || nums[map.get(nums[i])] > max) {
//                    res[0] = map.get(nums[i]);
//                    res[1] = i;
//                    max = Math.max(nums[i], nums[map.get(nums[i])]);
//                }
//            }
//            map.put(target - nums[i], i);
//        }
//        return res;
//    }

}
