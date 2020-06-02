package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.List;

public class BalancedBinaryTree_110 {
//    Input:
//            1
//            \
//            2
//          / \
//        3   4
//
//    Ouput:
//            [1, 3, 4, 2]
//
//    Explanation:
//    The root doesn't have left subtree, so the root itself is left boundary.
//    The leaves are node 3 and 4.
//    The right boundary are node 1,2,4. Note the anti-clockwise direction means you should output reversed right boundary.
//    So order them in anti-clockwise without duplicates and we have [1,3,4,2].
//    https://leetcode.com/problems/boundary-of-binary-tree/

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        addNode();
        List<Integer> result = boundaryOfBinaryTree(root);
        for (int boundary: result) {
            System.out.println(boundary);
        }
    }

    static List<Integer> result = null;
    // A function to do boundary traversal of a given binary tree
    public static List<Integer> boundaryOfBinaryTree(TreeNode node) {
        result = new ArrayList<>();
        if (node == null)
            return result;
        result.add(node.val);

        // Print the left boundary in top-down manner.
        printBoundaryLeft(node.left);

        // Print all leaf nodes
        printLeaves(node.left);
        printLeaves(node.right);

        // Print the right boundary in bottom-up manner
        printBoundaryRight(node.right);

        return result;
    }

    static void printLeaves(TreeNode node) {
        if (node == null) {
            return;
        }
        printLeaves(node.left);
        if (node.left == null && node.right == null) {
//            System.out.println(node.val);
            result.add(node.val);
        }
        printLeaves(node.right);
    }


    // A function to print all left boundary nodes, except a leaf node.
    // Print the nodes in TOP DOWN manner
    static void printBoundaryLeft(TreeNode node)
    {
        if (node == null)
            return;

        if (node.left != null) {
            // to ensure top down order, print the node
            // before calling itself for left subtree
//            System.out.print(node.val + " ");
            result.add(node.val);
            printBoundaryLeft(node.left);
        }
        else if (node.right != null) {
//            System.out.print(node.val + " ");
            result.add(node.val);
            printBoundaryLeft(node.right);
        }

        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }

    // A function to print all right boundary nodes, except a leaf node
    // Print the nodes in BOTTOM UP manner
    static void printBoundaryRight(TreeNode node)
    {
        if (node == null)
            return;

        if (node.right != null) {
            // to ensure bottom up order, first call for right
            // subtree, then print this node
            printBoundaryRight(node.right);
//            System.out.print(node.val + " ");
            result.add(node.val);
        }
        else if (node.left != null) {
            printBoundaryRight(node.left);
//            System.out.print(node.val + " ");
            result.add(node.val);
        }
        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }

//    public static List<Integer> boundaryOfBinaryTree(TreeNode root) {
//
//    }

    public static void addNode() {
        root = addNodeRecursive(root, 10);
        root.left = new TreeNode(15);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(17);
        root.right.left = new TreeNode(14);
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
