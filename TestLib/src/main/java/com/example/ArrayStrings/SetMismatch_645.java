package com.example.ArrayStrings;

//Input: nums = [1,2,2,4]
//        Output: [2,3]
//        https://leetcode.com/problems/set-mismatch/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SetMismatch_645 {

    public static void main(String[] args) {
        //String a = "11", b = "1";
        int[] nums = {1,2,4,2};
        int[] result = findErrorNums(nums);
        System.out.println("result is: "+result[0] +"\t "+result[1]);
    }

    public static int[] findErrorNums(int[] nums) {
        int dup = -1, missing = 0;
        int[] extraArray = new int[nums.length+1];

        for (int num: nums)  {
            extraArray[num] += 1;
        }

        for(int i =0; i < extraArray.length; i++) {
            if (extraArray[i] == 0) {
                missing = i;
            } else if (extraArray[i] ==2) {
                dup = i;
            }
        }
        int[] returnValue = {dup, missing};
        return returnValue;
    }

    //using Array sort to find the soln
    public static int[] findErrorNums2(int[] nums) {
        Arrays.sort(nums);
        int dup = -1, missing = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                dup = nums[i];
            else if (nums[i] > nums[i - 1] + 1)
                missing = nums[i - 1] + 1;
        }
        return new int[] {dup, nums[nums.length - 1] != nums.length ? nums.length : missing};
    }

    //using a  hashMap to store the count
    public static int[] findErrorNums1(int[] nums) {
        Map< Integer, Integer > map = new HashMap();
        int dup = -1, missing = 1;
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (map.containsKey(i)) {
                if (map.get(i) == 2)
                    dup = i;
            } else
                missing = i;
        }
        return new int[]{dup, missing};
    }

}
