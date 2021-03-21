package com.example.ArrayStrings;

//Given nums = [1,1,1,2,2,3],
//        Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
//        It doesn't matter what you leave beyond the returned length.
//        https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/discuss/27970/Share-my-O(N)-time-and-O(1)-solution-when-duplicates-are-allowed-at-most-K-times
public class RemoveDuplicatesfromSortedArrayII_80 {

    public static void main(String[] args) {
        int nums[] = {0,0,0,1,1,1,1,2,3,3};
        int returnValue = removeDuplicates(nums);
        System.out.println("Length is: " + returnValue);
        for (int i = 0; i < returnValue; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        return removeDuplicates(nums, 2);
    }

    public static int removeDuplicates(int[] nums, int k) {
        if (nums.length < k) return nums.length;
        int i,j;
        for (i=k,j=k; i<nums.length;i++) {
            if (nums[j-k] != nums[i]) {
                nums[j++]=nums[i];
            }
        }
        return j;
    }

//    public static int removeDuplicatesOld(int[] nums) {
//        int i =0, twiceCount = 1, len = nums.length;
//        for (int j=1; j < len; j++) {
//            if (nums[i]==nums[j]) {
//                twiceCount++;
//            } else {
//                twiceCount = 1;
//            }
//            if (twiceCount <=2) {
//               i++;
//               nums[i]=nums[j];
//            }
//        }
//        return i+1;
//    }
}
