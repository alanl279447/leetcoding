package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class KClosestPointstoOrigin {

//    Input: points = [[1,3],[-2,2]], K = 1
//    Output: [[-2,2]]
//    Explanation:
//    The distance between (1, 3) and the origin is sqrt(10).
//    The distance between (-2, 2) and the origin is sqrt(8).
//    Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
//    We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
//
//    Input: points = [[3,3],[5,-1],[-2,4]], K = 2
//    Output: [[3,3],[-2,4]]
//    (The answer [[-2,4],[3,3]] would also be accepted.)
//    https://www.baeldung.com/java-distance-between-two-points
//    https://leetcode.com/problems/k-closest-points-to-origin/
    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[][] nums1 = {{5,5}, {3,3}, {1,1}, {-2,2}};
//        int[][] nums1 = {{5,-1},{3,3}, {-2,4}};
        int[][] result = kClosest(nums1, 2);
        for (int[] res: result)
           System.out.println(res[0] +"  "+res[1]);
    }

    public static int[][] kClosest(int[][] points, int K) {
        int left = 0, right = points.length - 1;
        while(left <= right){
            int pivot = findPivot(points, left, right);
            if(pivot == K)
                break;
            if(pivot < K){
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    private static int findPivot(int[][] points, int left, int right){
        int[] pivotVal = points[left];
        int pivotIndex = left;
        left++;
        while(left <= right){
            if(distance(points[left], pivotVal) <= 0){
                left++;
            } else if(distance(points[right], pivotVal) >= 0){
                right--;
            } else {
                swap(points, left, right);
            }
        }
        swap(points, pivotIndex, right);
        return right;
    }

    private static void swap(int[][] points, int left, int right){
        int[] temp = points[left];
        points[left] = points[right];
        points[right] = temp;
    }

//    Assume your location is [m, n] and the location of a post office is [p, q],
//    the Euclidean distance between the office and you is SquareRoot((m - p) * (m - p) + (n - q) * (n - q)).
    private static int distance(int[] p1, int[] p2){
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }

//    public static int[][] kClosest(int[][] points, int K) {
//        int len =  points.length, l = 0, r = len - 1;
//        while (l <= r) {
////            int mid = helper(points, l, r);
////            int mid = getPartitionId(points, l,r);
//            int mid = getPartitionIdPrac(points, l, r);
//            if (mid == K) break;
//            if (mid < K) {
//                l = mid + 1;
//            } else {
//                r = mid - 1;
//            }
//        }
//        return Arrays.copyOfRange(points, 0, K);
//    }
//
//    private static int getPartitionIdPrac(int[][] A, int low, int high) {
//        int pivot = low;
//        while (low<high) {
//            if (low<high && compare(A[low], A[pivot]) <=0) low++;
//            else if (low<high && compare(A[high], A[pivot]) >0) high--;
//            else swap(A, low,high);
//        }
//        swap(A, high, pivot);
//        return high;
//    }
//
//    private static void swap(int[][] A, int index1, int index2) {
//        int[] temp = A[index1];
//        A[index1] = A[index2];
//        A[index2] = temp;
//    }
//
//    // returns random pivot index between low and high inclusive.
//    private static int getPivot(int low, int high) {
//        Random rand = new Random();
//        return rand.nextInt((high - low) + 1) + low;
//    }
//
//    private static int getPartitionId(int[][] A, int low, int high) {
//        int pivot = getPivot(low, high);
//        swap(A, pivot,low);
//        int border = low+1;
//        for (int i=border; i <=high; i++) {
//            if (compare(A[i],A[low]) < 0) {
//                swap(A, i, border++);
//            }
//        }
//        swap(A, low, border-1);
//        return border-1;
//    }
//
//    //improve on quick sort logic
//    private static int helper(int[][] A, int l, int r) {
//        int[] pivot = A[l];
//        while (l < r) {
//            while (l < r && compare(A[r], pivot) >= 0) r--;
//            A[l] = A[r];
//            while (l < r && compare(A[l], pivot) <= 0) l++;
//            A[r] = A[l];
//        }
//        A[l] = pivot;
//        return l;
//    }
//
//    private static int compare(int[] p1, int[] p2) {
//        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
//    }


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
