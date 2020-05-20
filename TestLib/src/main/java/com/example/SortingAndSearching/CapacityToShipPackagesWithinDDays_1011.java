package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.List;

public class CapacityToShipPackagesWithinDDays_1011 {
//    Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
//    Output: 15
//    Explanation:
//    A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
//            1st day: 1, 2, 3, 4, 5
//            2nd day: 6, 7
//            3rd day: 8
//            4th day: 9
//            5th day: 10
//
//    Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and
//    splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
//    https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(shipWithinDays(weights, 5));
    }

    //min = max weight
    //max = Sum(weights)
    public static int shipWithinDays(int[] weights, int D) {
        int lo = 0, high =0;
        for (int weight:weights) {
            lo = Math.max(lo, weight);
            high += weight;
        }
        while (lo<=high) {
            int midpt = lo+(high-lo)/2;
            if (canFitWeight(weights, D, midpt)) {
                high=midpt-1;
            } else {
                lo=midpt+1;
            }
        }
        return lo;
    }

    private static boolean canFitWeight(int[] weights, int D, int midpt) {
        int curr =0, need =1;
        for (int weight: weights) {
            if (curr + weight > midpt) {
                need++;
                curr=0;
            }
            curr +=weight;
        }
        return need<=D;
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
