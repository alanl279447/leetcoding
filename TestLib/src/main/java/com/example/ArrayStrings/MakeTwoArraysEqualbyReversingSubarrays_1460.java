package com.example.ArrayStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
//        Input: target = [1,2,3,4], arr = [2,4,1,3]
//        Output: true
//        Explanation: You can follow the next steps to convert arr to target:
//        1- Reverse sub-array [2,4,1], arr becomes [1,4,2,3]
//        2- Reverse sub-array [4,2], arr becomes [1,2,4,3]
//        3- Reverse sub-array [4,3], arr becomes [1,2,3,4]
//        There are multiple ways to convert arr to target, this is not the only way to do so.
//        https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/

public class MakeTwoArraysEqualbyReversingSubarrays_1460 {
    public static void main(String[] args) {
        int[] target = {1,2,3,4};
        int[] arr = {2,4,1,3};
        System.out.println(canBeEqual(target, arr));
    }

    public boolean canBeEqualFast(int[] target, int[] arr) {
        int[] tmp=new int[1001];
        Arrays.fill(tmp, 0);
        for(int i=0;i<target.length;i++){
            tmp[target[i]]++;
        }
        for(int i=0;i<arr.length;i++){
            tmp[arr[i]]--;
            if( tmp[arr[i]]<0){
                return false;
            }
        }

        return true;
    }

    public static boolean canBeEqual(int[] target, int[] arr) {
        int m = target.length, n = arr.length;
        if (m != n) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i < m; i++) {
            map.put(target[i], map.getOrDefault(target[i], 0)+1);
            map.put(arr[i], map.getOrDefault(arr[i], 0)-1);
        }
        for (int i: map.keySet()) {
            if (map.get(i) != 0) return false;
        }
        return true;
    }
}