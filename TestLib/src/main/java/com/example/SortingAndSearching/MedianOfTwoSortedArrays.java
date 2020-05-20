package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.List;

public class MedianOfTwoSortedArrays {

//    nums1 = [1, 3]
//    nums2 = [2]
//    The median is 2.0
//
//    nums1 = [1, 2]
//    nums2 = [3, 4]
//    The median is (2 + 3)/2 = 2.5
//    Solution
// * Take minimum size of two array. Possible number of partitions are from 0 to m in m size array.
//            * Try every cut in binary search way. When you cut first array at i then you cut second array at (m + n + 1)/2 - i
// * Now try to find the i where a[i-1] <= b[j] and b[j-1] <= a[i]. So this i is partition around which lies the median.
//     * Time complexity is O(log(min(x,y))
//            * Space complexity is O(1)
//    https://www.youtube.com/watch?v=LPFhl65R7ww
//    https://leetcode.com/problems/median-of-two-sorted-arrays/submissions/
    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[] nums1 = { 0, 0 };
        int[] nums2 = { 0, 0 };
        System.out.print(findMedianSortedArraysBinarySearch(nums1, nums2));
    }

    public static double findMedianSortedArraysBinarySearch(int input1[], int input2[]) {
        //if input1 length is greater than switch them so that input1 is smaller than input2.
        if (input1.length > input2.length) {
            return findMedianSortedArraysBinarySearch(input2, input1);
        }
        int x = input1.length;
        int y = input2.length;

        int low = 0;
        int high = x;
        while (low <= high) {
            int partitionX = (low + high)/2;
            int partitionY = (x + y + 1)/2 - partitionX;

            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //We have partitioned array at correct place
                // Now get max of left elements and min of right elements to get the median in case of even length combined array size
                // or get max of left for odd length combined array size.
                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side.
                high = partitionX - 1;
            } else { //we are too far on left side for partitionX. Go on right side.
                low = partitionX + 1;
            }
        }

        //Only we we can come here is if input arrays were not sorted. Throw in that scenario.
        throw new IllegalArgumentException();
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p1 = 0, p2 = 0, m = nums1.length, n = nums2.length;
        int totalLength = m + n;

        if (totalLength % 2 == 0) {  //odd length
            return (findKthNumber(nums1, 0, nums2, 0, totalLength/2) +
                    findKthNumber(nums1, 0, nums2, 0, totalLength/2 + 1))/2;
        } else {
            return findKthNumber(nums1, 0, nums2, 0, totalLength/2 +1);
        }
    }

    public static int findKthNumber(int[] nums1, int aStart, int[] nums2, int bStart, int k) {
       if(aStart >= nums1.length) {
            return nums2[bStart + k -1];
       } else if (bStart > nums2.length) {
           return nums1[aStart + k -1];
       }
       if (k == 1) {
           return Math.min(nums1[aStart], nums2[bStart]);
       }

       int key1Index = aStart + k/2 -1;
       int key2Index = bStart + k/2 -1;

       int key1 = key1Index < nums1.length ? nums1[key1Index] : Integer.MAX_VALUE;
       int key2 = key2Index < nums2.length ? nums2[key2Index] : Integer.MAX_VALUE;

       if (key1 < key2) {
           return findKthNumber(nums1, aStart+k/2, nums2, bStart, k-k/2);
       } else {
           return findKthNumber(nums1, aStart, nums2, bStart+k/2, k-k/2);
       }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void addNode(int value) {
        root = addNodeRecursive(root, value);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
    }

    public static TreeNode addNodeRecursive(TreeNode node, int value) {
//        TreeNode newNode = null;
        if (node == null) {
            node = new TreeNode(value);
            return node;
        }

        if (value < node.val) {
            node.left = addNodeRecursive(node.left, value);
        } else if (value > node.val){
            node.right = addNodeRecursive(node.right, value);
        } else {
            return node;
        }
        return node;
    }
}
