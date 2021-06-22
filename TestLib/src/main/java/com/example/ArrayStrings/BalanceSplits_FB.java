package com.example.ArrayStrings;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BalanceSplits_FB {

    public static void main(String[] args) {
//        String s = "abcxyz123";
//        String[] dict = {"abc","123"};
//        System.out.println(addBoldTag(s, dict));
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
}