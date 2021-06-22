package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionofTwoArrays_349 {

//    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//    Output: [9,4]
//    https://leetcode.com/problems/intersection-of-two-arrays/

    public static void main(String args[]) {
//        int[] ip1 = {4,9,5};
//        int[] ip2 = {9,4,9,8,4};
        int[] ip1 = {4,5,9};
        int[] ip2 = {4,4,4,8,9};
        int[] result = intersection(ip1, ip2);
        for (int res: result)
           System.out.println(res);
    }

    /* Solution 2 : O(n) time and O(1) space */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1); // assume sorted
        Arrays.sort(nums2); // assume sorted
        int[] intersections = new int[nums1.length];
        int i1 = 0 , i2 = 0, j = 0;

        while(i1 < nums1.length && i2 < nums2.length) {
            int val1 = nums1[i1];
            int val2 = nums2[i2];

            if(val1 == val2) {
                intersections[j++] = val1;
                while(i1 < nums1.length && val1 == nums1[i1]) i1++;
                while(i2 < nums2.length && val2 == nums2[i2]) i2++;
            }

            if(val2 > val1) {
                while(i1 < nums1.length && val1 == nums1[i1]) i1++;
            } else {
                while(i2 < nums2.length && val2 == nums2[i2]) i2++;
            }
        }
        return Arrays.copyOf(intersections, j);

    }

    public static int[] intersectionWork(int[] nums1, int[] nums2) {

        Set<Integer> input1 = new HashSet<>(nums1.length);
        Set<Integer> input2 = new HashSet<>(nums2.length);

        for (int i =0; i < nums1.length; i++) {
            input1.add(nums1[i]);
        }

        for (int i =0; i < nums2.length; i++) {
            input2.add(nums2[i]);
        }

        if (input1.size() < input2.size()) {
            return intersectionResult(input1, input2);
        } else {
            return  intersectionResult(input2, input1);
        }
    }

    private static int[] intersectionResult(Set<Integer> s1, Set<Integer> s2) {

        int[] result = new int[s1.size()];
        int idx = 0;
        for (int s:s1) {
            if (s2.contains(s)) {
                 result[idx++] = s;
            }
        }
        return Arrays.copyOf(result, idx);
    }


}
