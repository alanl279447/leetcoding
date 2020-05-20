package com.example.ArrayStrings;

//        Input:
//        nums1 = [1,2,3,0,0,0], m = 3
//        nums2 = [2,5,6],       n = 3
//
//        Output: [1,2,2,3,5,6]
//        https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/309/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortedArray_309 {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, 3, nums2, 3);
        for (int num: nums1) {
            System.out.println(num);
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        System.arraycopy(nums2,0,nums1,m,n);
//        Arrays.sort(nums1);
        int p1 =m-1, p2 =n-1, p = m+n-1;

        while(p1>=0 && p2>=0) {
            nums1[p--] = nums1[p1] > nums2[p2]? nums1[p1--] : nums2[p2--];
        }
        System.arraycopy(nums2,0, nums1, 0,p2+1);
    }
}
