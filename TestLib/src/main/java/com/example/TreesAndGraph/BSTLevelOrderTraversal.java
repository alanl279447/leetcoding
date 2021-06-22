package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BSTLevelOrderTraversal {
//                3
//               / \
//               9  20
//               /  \
//               15   7
//
//                        [
//                        [3],
//                        [9,20],
//                        [15,7]
//                        ]

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        addNode(3);
        List<List<Integer>> output = levelOrderTest(root);
        for (List<Integer> item: output) {
          for (Integer it: item) {
              System.out.print(it);
          }
            System.out.println();
        }
    }

    public static List<List<Integer>> levelOrderTest(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return result;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> subItem = new ArrayList<>();
            for (int i=0; i < count; i++) {
                TreeNode item = queue.poll();
                subItem.add(item.val);

                if (item.left!= null) {
                    queue.offer(item.left);
                }
                if (item.right!=null) {
                    queue.offer(item.right);
                }
            }
            result.add(subItem);
        }
        return result;
    }


    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helperBFS(root, result, 0);
        return result;
    }

    public static void helperBFS(TreeNode node, List<List<Integer>> result, int level) {
        if (node == null) {
            return;
        }
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        helperBFS(node.left, result, level+1);
        helperBFS(node.right, result, level+1);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

//    public static List<List<Integer>> levelOrder(TreeNode root) {
//        if (root != null) {
//            helper(root, 0);
//        }
//        return levelOrder;
//    }
//
//    public static void helper(TreeNode node, Integer level) {
//        if (node == null) return;
//        if (levelOrder.size() == level) {
//             levelOrder.add(new ArrayList<Integer>());
//        }
//        levelOrder.get(level).add(node.val);
//        helper(node.left, level+1);
//        helper(node.right, level+1);
//    }

    public static void addNode(int value) {
        root = addNodeRecursive(root, value);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);
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
