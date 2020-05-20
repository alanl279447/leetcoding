package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.List;

public class RecoverBinarySearchTree_99 {
//    Input: [1,3,null,null,2]
//
//            1
//            /
//            3
//            \
//            2
//
//    Output: [3,1,null,null,2]
//
//            3
//            /
//            1
//            \
//            2
//    https://leetcode.com/problems/recover-binary-search-tree/

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        addNode();
        recoverTree(root);
//        while(root.left!= null) {
//            System.out.println();
//        }
    }


    static TreeNode firstItem =null;
    static TreeNode secondItem = null;
    static TreeNode prevNode = null;

    public static void recoverTree(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root);
        System.out.println(root.val);
        int temp = firstItem.val;
        firstItem.val = secondItem.val;
        secondItem.val = temp;
    }

    public static void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);

        if (prevNode != null){
            if (prevNode.val > node.val) {
            if (firstItem == null) {
                   firstItem = prevNode;
                }
            secondItem = node;
            }
        }
        prevNode = node;
        System.out.println(node.val);
        inOrderTraversal(node.right);
    }

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
