package com.example.SortingAndSearching;

import com.example.TreesAndGraph.SmallestSubtreewithalltheDeepestNodes_865;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class LowestCommonAncestorofDeepestLeaves_1123 {

//    Input: root = [1,2,3]
//    Output: [1,2,3]
//    Explanation:
//    The deepest leaves are the nodes with values 2 and 3.
//    The lowest common ancestor of these leaves is the node with value 1.
//    The answer returned is a TreeNode object (not an array) with serialization "[1,2,3]".
//    https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/

    public static TreeNode root = null;
    public static void main(String[] args) {
        TreeNode result = lcaDeepestLeaves(root);
        System.out.print(result.val);
    }

    static int deepestLevel = 0;
    static TreeNode result = null;
    public static TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    private static int dfs(TreeNode node, int level) {
        if (node == null) {
            return level;
        }
        int left = dfs(node.left, level+1);
        int right = dfs(node.right, level+1);
        int currentMax = Math.max(left, right);
        deepestLevel = Math.max(deepestLevel, currentMax);

        if (left == deepestLevel && right == deepestLevel) {
            result = node;
        }
        return currentMax;
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
