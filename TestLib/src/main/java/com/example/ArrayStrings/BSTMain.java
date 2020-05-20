package com.example.ArrayStrings;

import java.util.HashMap;
import java.util.Map;

public class BSTMain {

//    public static void main(String[] args) {
//        System.out.println("Testing main");
//        BinaryTreeSample mBts = new BinaryTreeSample();
//
//        mBts.add(6);
//        mBts.add(4);
//        mBts.add(8);
//        mBts.add(3);
//        mBts.add(5);
//        mBts.add(7);
//        mBts.add(9);
//        mBts.preOrderTraversal(mBts.getRoot());
//
//        mBts.delete(4);
//        mBts.preOrderTraversal(mBts.getRoot());
//
//        System.out.println("number 9: "+mBts.doesContainNumber(9));
//        System.out.println("number 4: "+mBts.doesContainNumber(4));
//    }

    public static void main(String[] args) {
        int[] sortedNums = {1,1,1,2};
        int[] dupSortedNums = {0,0,1,1,1,2,2,3,3,4};
       int index = removeDuplicatesFromArray(sortedNums);
       System.out.println("Unique index is till: "+index);
        for (int j=0; j < index; j++) {
            System.out.println("Unique values: "+sortedNums[j]);
        }

        int index2 = removeDuplicatesFromArray(dupSortedNums);
        System.out.println("Unique index is till: "+index2);
        for (int j=0; j < index2; j++) {
            System.out.println("Unique values: "+dupSortedNums[j]);
        }

        //two sum solution
        int[] indices = twoSum(new int[]{2,5,11,15,7}, 9);
        System.out.println("the indices are: "+indices[0] +" "+indices[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums.length == 0) return null;
        Map<Integer, Integer> entries = new HashMap<>();
        for(int i =0; i < nums.length; i++) {
            int compliment = target - nums[i];
            if (entries.containsKey(compliment)) {
                return new int[] {i, entries.get(compliment)};
            }
            entries.put(nums[i], i);
        }
        return null;
    }


    private static int removeDuplicatesFromArray(int[] sortedNums) {
        int i = 0;
        for (int j=1; j < sortedNums.length; j++) {
            if (sortedNums[j] != sortedNums[i]) {
                i++;
                sortedNums[i] = sortedNums[j];
            }
        }
        return i+1;
    }
}
