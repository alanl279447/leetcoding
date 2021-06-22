package com.example.TreesAndGraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Input: root1 = [2,1,4], root2 = [1,0,3]
//Output: [0,1,1,2,3,4]
//https://leetcode.com/problems/all-elements-in-two-binary-search-trees/

public class AllElementsinTwoBinarySearchTrees_1305 {
    public static TreeNode root = null;
    public static TreeNode root1 = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        addNode();
        addNode2();
        List<Integer> result = getAllElements(root, root1);
        for (Integer res: result) {
            System.out.println(res);
        }
    }

    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayDeque<TreeNode> stack1 = new ArrayDeque(), stack2 = new ArrayDeque();
        List<Integer> output = new ArrayList();

        while (root1 != null || root2 != null || !stack1.isEmpty() || !stack2.isEmpty()) {
            // update both stacks
            // by going left till possible
            while (root1 != null) {
                stack1.push(root1);
                root1 = root1.left;
            }
            while (root2 != null) {
                stack2.push(root2);
                root2 = root2.left;
            }

            // Add the smallest value into output,
            // pop it from the stack,
            // and then do one step right
            if (stack2.isEmpty() || !stack1.isEmpty() && stack1.peek().val <= stack2.peek().val) {
                root1 = stack1.pop();
                output.add(root1.val);
                root1 = root1.right;
            }
            else {
                root2 = stack2.pop();
                output.add(root2.val);
                root2 = root2.right;
            }
        }
        return output;
    }

//    public static List<Integer> getAllElementsTwoPass(TreeNode root1, TreeNode root2) {
//        List<Integer> result = new ArrayList<>();
//        inOrderTraversal(root1, result);
//        inOrderTraversal(root2, result);
//        Collections.sort(result);
//        return result;
//    }
//
//    private static List<Integer> inOrderTraversalRecursive(TreeNode node, List<Integer> result) {
//        if (node == null) return result;
//        inOrderTraversalRecursive(node.left, result);
//        result.add(node.val);
//        inOrderTraversalRecursive(node.right, result);
//        return result;
//    }
//
//    private static List<Integer> inOrderTraversal(TreeNode node, List<Integer> result) {
//        Deque<TreeNode> stack = new ArrayDeque<>();
//        while (!stack.isEmpty() || node != null) {
//            while (node != null) {
//                stack.offer(node);
//                node = node.left;
//            }
//            node = stack.pop();
//            result.add(node.val);
//            node = node.right;
//        }
//        return result;
//    }

    public static void addNode() {
        root = addNodeRecursive(root, 2);
        root.left = new TreeNode(1);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(7);
        root.right = new TreeNode(4);
//        root.right.right = new TreeNode(3);
//        root.right.right.right = new TreeNode(4);
    }

    public static void addNode2() {
        root1 = addNodeRecursive(root1, 10);
        root1.left = new TreeNode(5);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(7);
        root1.right = new TreeNode(13);
//        root.right.right = new TreeNode(3);
//        root.right.right.right = new TreeNode(4);
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
