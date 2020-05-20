package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FlattenBinaryTreetoLinkedList_114 {

//                 1
//                / \
//                2   5
//               / \   \
//              3   4   6
//    https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

    public static TreeNode root;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        addNode();
        flatten(root);
        while(root != null)
         System.out.print(root.val);
    }

    public static void flatten(TreeNode root) {
         if(root == null) return;
         Stack<TreeNode> stack = new Stack<>();
         stack.push(root);

         while(!stack.isEmpty()){
            TreeNode currentNode = stack.pop();

            if(currentNode.right != null) {
                stack.push(currentNode.right);
            }

            if(currentNode.left != null) {
                stack.push(currentNode.left);
            }

            if (!stack.isEmpty()) {
                currentNode.right = stack.peek();
            }
            currentNode.left = null;
         }
    }

    public static void addNode() {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
