package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
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

        return Arrays.copyOfRange(points ,0, K);
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

    private static int distance(int[] p1, int[] p2){
        return (p1[0]*p1[0] - p2[0]*p2[0] + p1[1]*p1[1] - p2[1]*p2[1]);
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
