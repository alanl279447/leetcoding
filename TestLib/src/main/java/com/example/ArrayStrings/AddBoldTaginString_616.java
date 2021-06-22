package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class AddBoldTaginString_616 {

//    Input:
//    s = "abcxyz123"
//    dict = ["abc","123"]
//    Output:"<b>abc</b>xyz<b>123</b>"
//    https://leetcode.com/problems/add-bold-tag-in-string/
//O(N*k)
    public static void main(String[] args) {
//        String s = "abcxyz123";
//        String[] dict = {"abc","123"};
//        System.out.println(addBoldTag(s, dict));

        int[] input = {1,2,3,4,5};
        int[] res = largestProductSum(input);
        for (int re: res) {
            System.out.println(re);
        }

        //Input: A = [2,7,4], K = 181
        //Output: [4,5,5]
        //Explanation: 274 + 181 = 455
//        int[] A = {2,7,4};
//        System.out.println(addToArrayForm(A, 181));

//        int[] arr = {12, 7, 6, 7, 6};         //output = false
        int[] arr = {1, 5, 7, 1, 4,4,2};
        System.out.println(balancedSplitExists(arr));
    }

    static boolean balancedSplitExists(int[] arr) {
        Arrays.sort(arr);    //1,1,2,4,4,5,7
        int len = arr.length;
        int left = 1;
        int right = len-1;
        int lsum = arr[0];  //1
        int rsum = arr[len-1]; //7

        while (left < right){
            while (left < right && lsum < rsum){  //1+1+2+4 = 8+4=12
                lsum +=arr[left++];
            }

            while (left < right && lsum > rsum){
                rsum +=arr[--right];   //7+5 = 12
            }

            if (lsum == rsum){
                return left == right;
            }

        }
        return lsum == rsum &&  arr[left]!=arr[right];
    }

    public static String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        for (int i = 0, end = 0; i < s.length(); i++) {
            for (String word : dict) {
                if (s.startsWith(word, i)) {
                    end = Math.max(end, i + word.length());
                }
            }
            bold[i] = end > i;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!bold[i]) {
                result.append(s.charAt(i));
                continue;
            }
            int j = i;
            while (j < s.length() && bold[j]) {
                j++;
            }
            result.append("<b>" + s.substring(i, j) + "</b>");
            i = j - 1;
        }
        return result.toString();
    }

    public static int[] largestProductSum(int[] nums) {
        if (nums  == null || nums.length == 0) return new int[] {};
        int len = nums.length;
        int[] result = new int[len];
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2) {
                max3 = max2;
                max2 = nums[i];
            } else if (nums[i] > max3) {
                max3 = nums[i];
            }
            if (i < 2) result[i] = -1;
            else {
                result[i] = max1*max2*max3;
            }
        }
        return result;
    }



    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new LinkedList<>();
        for (int i = A.length - 1; i >= 0; --i) {
            res.add(0, (A[i] + K) % 10);
            K = (A[i] + K) / 10;
        }
        while (K > 0) {
            res.add(0, K % 10);
            K /= 10;
        }
        return res;
    }
}