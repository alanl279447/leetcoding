package com.example.ArrayStrings;

import java.util.Random;

public class QuickSort_MergeSort {

    public static void main(String[] args) {
//        int[] nums = {5,1,1,2,0,0};
        int[] nums = {5,1,2,3,7};
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

        quickSort(nums);
        return nums;
    }

    public static void quickSort(int[] A) {
        quickSort(A, 0, A.length-1);
    }

    private static void quickSort(int[] A, int low, int high) {
      if (low >= high) {
          return;
      }
      int pivot = getPartitionId(A, low, high);
      quickSort(A, low, pivot-1);
      quickSort(A, pivot+1, high);
    }

    private static int getPartitionId(int[] A, int low, int high) {
        int pivot = getPivot(low, high);
        swap(A, pivot, low);

        int border = low+1;
        for (int i=border; i <=high; i++) {
            if (A[i]<A[low]) {
                swap(A, i, border++);
            }
        }
        swap(A, low, border-1);
        return border-1;
    }

    private static void swap(int[] A, int index1, int index2) {
        int temp = A[index1];
        A[index1] = A[index2];
        A[index2] = temp;
    }

    // returns random pivot index between low and high inclusive.
    private static int getPivot(int low, int high) {
        Random rand = new Random();
        return rand.nextInt((high - low) + 1) + low;
    }

//    private static void selectionSort(int[] nums){
//        for (int i = 0; i < nums.length; i++){
//            int minIndex = i;
//            for (int j = i + 1; j < nums.length; j++){
//                if (nums[j] < nums[minIndex]){
//                    minIndex = j;
//                }
//            }
//            exch(nums, i, minIndex);
//        }
//    }

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
