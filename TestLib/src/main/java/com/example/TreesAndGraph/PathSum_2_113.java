package com.example.TreesAndGraph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PathSum_2_113 {
//    Given the below binary tree and sum = 22,
//
//             5
//            / \
//           4   8
//          /   / \
//         11  13  4
//        /  \    / \
//       7    2  5   1
//    https://leetcode.com/problems/path-sum-ii/

    //5+4+11+7 = 27

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        addNode(5);
        System.out.print(pathSum(root, 22 ));
    }


    public static List<List<Integer>> pathSumTest(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), root, sum);
        return result;
    }

    public static void helper(List<List<Integer>> result, List<Integer> temp, TreeNode node, int sum) {
        if (node == null) return;
        if (sum == node.val && node.left==null && node.right==null) {
            temp.add(node.val);
            result.add(new ArrayList<>(temp));
        } else {
            temp.add(node.val);

        }
    }


    //time complexity 0(n^2)
    // 0(n) to traverse all nodes, 0(n) to copy the list over
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> pathsList = new ArrayList<List<Integer>>();
        List<Integer> pathNodes = new ArrayList<Integer>();
        recurseTree(root, sum, pathNodes, pathsList);
        return pathsList;
    }

    private static void recurseTree(TreeNode node, int remainingSum,
                                    List<Integer> pathNodes, List<List<Integer>> pathsList) {
        if (node == null) {
            return;
        }
        // Add the current node to the path's list
        pathNodes.add(node.val);

        // Check if the current node is a leaf and also, if it
        // equals our remaining sum. If it does, we add the path to
        // our list of paths
        if (remainingSum == node.val && node.left == null && node.right == null) {
            pathsList.add(new ArrayList<>(pathNodes));
        } else {

            // Else, we will recurse on the left and the right children
            recurseTree(node.left, remainingSum - node.val, pathNodes, pathsList);
            recurseTree(node.right, remainingSum - node.val, pathNodes, pathsList);
        }

        // We need to pop the node once we are done processing ALL of it's
        // subtrees.
        pathNodes.remove(pathNodes.size() - 1);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void addNode(int value) {
        root = addNodeRecursive(root, value);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
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
