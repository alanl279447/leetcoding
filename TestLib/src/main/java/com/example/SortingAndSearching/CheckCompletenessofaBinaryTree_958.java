package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheckCompletenessofaBinaryTree_958 {
//    Input: [1,2,3,4,5,6]
//    Output: true
//    Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}),
//    and all nodes in the last level ({4, 5, 6}) are as far left as possible.
//    https://leetcode.com/problems/check-completeness-of-a-binary-tree/
//    https://leetcode.com/problems/check-completeness-of-a-binary-tree/discuss/205768/Java-easy-Level-Order-Traversal-one-while-loop

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        addNode(1);
        System.out.println(isCompleteTree(root));
    }

    public static boolean isCompleteTree(TreeNode root) {
        boolean end = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur == null) end = true;
            else{
                if(end) return false;
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        return true;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void addNode(int value) {
        root = addNodeRecursive(root, value);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
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