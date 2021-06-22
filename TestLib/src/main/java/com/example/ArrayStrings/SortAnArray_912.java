package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortAnArray_912 {

    public static void main(String[] args) {
//        int[] nums = {5,1,1,2,0,0};
        int[] nums = {5,1,2,0};
        sortArray(nums);

        for (int res: nums) {
            System.out.println(res);
        }
    }

    private static final int QUICKSORTSHOLD = 50;
    private static final int MERGESORTSHOLD = 300;

    public static int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2){
            return nums;
        }
//        if (nums.length < QUICKSORTSHOLD){
//            selectionSort(nums);
//        }else if (nums.length < MERGESORTSHOLD) {
//            quickSort(nums);
//        }else{
//            mergeSort(nums);
//        }
//        mergeSort(nums);

        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    private static void quickSort(int[] nums, int lo, int hi){
        if (lo >= hi)
            return ;
        int pivot = partition(nums, lo, hi);
        quickSort(nums, lo, pivot - 1);
        quickSort(nums, pivot + 1, hi);
    }

    private static int partition(int[] nums, int lo, int hi){
        //int q = lo + (int)(Math.random() * (hi - lo + 1));
        int q = (lo + hi) / 2;
        exch(nums, lo, q);

        int index = lo + 1;
        for (int i = lo + 1; i <= hi; i++){
            if (nums[i] < nums[lo]){
                exch(nums, i, index++);
            }
        }
        exch (nums, lo, --index);
        return index;
    }


    private static void exch(int[] nums, int i, int j){
        if (i == j)
            return;
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }

    private static void selectionSort(int[] nums){
        for (int i = 0; i < nums.length; i++){
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++){
                if (nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            exch(nums, i, minIndex);
        }
    }

    public static void mergeSort(int[] nums) {
        mergeSortInternal(nums, 0, nums.length-1);
    }

    public static void mergeSortInternal(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (end+start)/2;

        mergeSortInternal(nums, start, mid);
        mergeSortInternal(nums, mid+1, end);
        merge(nums, start, mid, mid+1, end);
    }

    public static void merge(int[] nums, int stLo, int stHg, int endLo, int endHg) {
        if (stLo >= endHg) {
            return;
        }

        int lo = stLo;
        int high = endHg;
        int[] newInt = new int[stHg-stLo+endHg-endLo+2];

        int index=0;
        while(stLo<=stHg && endLo <= endHg) {
            newInt[index++] = nums[stLo]<nums[endLo]?nums[stLo++]:nums[endLo++];
        }

        while(stLo<=stHg) {
            newInt[index++] = nums[stLo++];
        }

        while(endLo<=endHg) {
            newInt[index++] = nums[endLo++];
        }
        index=0;
        while(lo<=high){
            nums[lo++] = newInt[index++];
        }
    }
}
