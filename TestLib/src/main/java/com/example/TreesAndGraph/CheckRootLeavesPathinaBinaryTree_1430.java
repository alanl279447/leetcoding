package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
//        Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
//        Output: true
//        Explanation:
//        The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure).
//        Other valid sequences are:
//        0 -> 1 -> 1 -> 0
//        0 -> 0 -> 0
//https://leetcode.com/problems/check-if-a-string-is-a-valid-sequence-from-root-to-leaves-path-in-a-binary-tree/
public class CheckRootLeavesPathinaBinaryTree_1430 {


    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        addNode();
        int[] input = {0,1,0,1};
        boolean result = isValidSequence(root, input);
        System.out.println(result);
    }

    public static boolean isValidSequence(TreeNode root, int[] arr) {
        return dfs(root, arr, 0);
    }

    private static boolean dfs(TreeNode n, int[] a, int depth) {
        if (n == null || depth >= a.length || a[depth] != n.val) { // base cases.
            return false;
        }// key base case: a leave found.
        if (n.left == null && n.right == null) { // credit to @The_Legend_ for making the code clean
            return depth + 1 == a.length; // valid sequence?
        }
        return dfs(n.left, a, depth + 1) || dfs(n.right, a, depth + 1); // recurse to the children.
    }

    public static void addNode() {
        root = addNodeRecursive(root, 0);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.left.left = new TreeNode(1);

        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(0);
        root.left.right.right = new TreeNode(0);

        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode addNodeRecursive(TreeNode node, int value) {
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
