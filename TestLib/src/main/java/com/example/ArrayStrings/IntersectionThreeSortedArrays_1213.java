package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.List;

public class IntersectionThreeSortedArrays_1213 {

//    Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
//    Output: [1,5]
//    Explanation: Only 1 and 5 appeared in the three arrays.
//     https://leetcode.com/problems/intersection-of-three-sorted-arrays/

    public static void main(String args[]) {
        int[] ip1 = {1,2,3,4,5};
        int[] ip2 = {1,2,5,7,9};
        int[] ip3 = {1,3,4,5,8};
        System.out.println(arraysIntersection(ip1, ip2, ip3));
    }

    public List<Integer> arraysIntersectionExpandable(int[] arr1, int[] arr2, int[] arr3) {
        int a=0,b=0,c=0;
        List<Integer> res = new ArrayList<>();
        while(a<arr1.length && b<arr2.length && c<arr3.length) {
            int min = Math.min(arr1[a],Math.min(arr2[b],arr3[c]));
            if(arr1[a] == min && arr2[b] == min && arr3[c] == min) res.add(min);
            if(arr1[a] == min) a++;
            if(arr2[b] == min) b++;
            if(arr3[c] == min) c++;
        }
        return res;
    }

    public static List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                result.add(arr1[i]);
                i++;
                j++;
                k++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr3[k]) {
                j++;
            } else k++;
        }
        return result;
    }
}
