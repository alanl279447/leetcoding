package com.example.ArrayStrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoArraysII_350 {

//    Input: nums1 = [1,2,2,1], nums2 = [2,2]
//    Output: [2,2]
//    https://leetcode.com/problems/intersection-of-two-arrays-ii/

    public static void main(String args[]) {
        int[] ip1 = {4,9,5};
        int[] ip2 = {9,4,9,8,4};
//        int[] ip1 = {4,9,5};
//        int[] ip2 = {4,4,4,8,9};
        int[] result = intersect(ip1, ip2);
        for (int res: result)
           System.out.println(res);
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
      int n1 = nums1.length;
      int n2 = nums2.length;
      Arrays.sort(nums1);
      Arrays.sort(nums2);
      int[] intersection = new int[n1];
      int i=0, j=0, k =0;
      while (i < n1 && j < n2) {
          if (nums1[i] == nums2[j]) {
              intersection[k++]=nums1[i];
              i++;
              j++;
          } else if (nums1[i] > nums2[j]) {
              j++;
          } else {
              i++;
          }
      }
      return Arrays.copyOf(intersection, k);
    }


}
