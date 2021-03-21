package com.example.ArrayStrings;

import com.example.TreesAndGraph.BSTLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class inOrderTraversal {

    public static TreeNode root = null;
    public static void main(String[] args) {

        addNode(5);
        List<Integer> result = inorderTraversal(root);
        //Recursive
        for(Integer value: result) {
            System.out.println(value);
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

    public static List<Integer> inorderTraversalRecursive(TreeNode root) {
        if (root == null) return new LinkedList<>();
        return inOrderTraversalInner(root, new LinkedList<>());
    }

    public static List<Integer> inOrderTraversalInner(TreeNode node, List<Integer> list) {
        if (node == null) return list;
        inOrderTraversalInner(node.left, list);
        list.add(node.val);
        inOrderTraversalInner(node.right, list);
        return list;
    }


    public static void addNode(int value) {
//        root = addNodeRecursive(root, value);
        if (root == null) {
            root = new TreeNode(value);
        }
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
    }

//    public static class BTSInOrderTraversal {
//        private TreeNode root = null;
//
//        private void addNode(String data) {
//            if (data == null) return;
//            int intData = 0;
//            try {
//                intData = Integer.parseInt(data);
//            } catch (NumberFormatException e) {
//            }
//            if (root == null) {
//                root = new TreeNode(intData);
//                return;
//            }
//            addInteral(root, intData);
//        }
//
//        private TreeNode addInteral(TreeNode current, int data) {
//            if (current == null) {
//                current = new TreeNode(data);
//                return current;
//            }
//            if (data < current.data) {
//                current.left = addInteral(current.left, data);
//            } else if (data > current.data) {
//                current.right = addInteral(current.right, data);
//            } else {
//                return current;
//            }
//            return current;
//        }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
