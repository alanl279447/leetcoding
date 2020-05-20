package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {

//    Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//    Output: 3
//    Explanation: The LCA of nodes 5 and 1 is 3.
//
//    Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//    Output: 5
//    Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

    public static TreeNode root;
    private static TreeNode ans = null;

    public static void main(String[] args) {
        addNode(3);
        lowestCommonAncestor(root, root.left, root.left.right.right);
        System.out.print(ans.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (p.val < root.val && q.val < root.val) {
            lowestCommonAncestor(root.left, p,q);
        }

        if (p.val > root.val && q.val > root.val) {
            lowestCommonAncestor(root.right, p,q);
        }
        return root;
    }

//    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        // Traverse the tree
//        recurseTree(root, p, q);
//        return ans;
//    }

//    private static boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
//        // If reached the end of a branch, return false.
//        if (currentNode == null) {
//            return false;
//        }
//
//        // Left Recursion. If left recursion returns true, set left = 1 else 0
//        int left = recurseTree(currentNode.left, p, q) ? 1 : 0;
//
//        // Right Recursion
//        int right = recurseTree(currentNode.right, p, q) ? 1 : 0;
//
//        // If the current node is one of p or q
//        int mid = (currentNode == p || currentNode == q) ? 1 : 0;
//
//        // If any two of the flags left, right or mid become True
//        if (mid + left + right >= 2) {
//            ans = currentNode;
//        }
//        // Return true if any one of the three bool values is True.
//        return (mid + left + right > 0);
//    }

    public static void addNode(int value) {
        root = new TreeNode(value);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
