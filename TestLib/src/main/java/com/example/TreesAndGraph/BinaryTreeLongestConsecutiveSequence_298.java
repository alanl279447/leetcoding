package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLongestConsecutiveSequence_298 {
//    Input:
//            1
//             \
//              3
//            /  \
//           2   4
//                \
//                 5
//    Output: 3
//    Explanation: Longest consecutive sequence path is 3-4-5, so return 3.
//    https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/

    public static TreeNode root = null;
    public static void main(String[] args) {
        addNode(1);
        int result = longestConsecutive(root);
//        for (int res: result) {
            System.out.print(result);
//        }
    }

    static int maxSequence = 0;
    public static int longestConsecutive(TreeNode root) {
        helper(root, 0, root.val);
        return maxSequence;
    }

    //DFS solution
    public static void helper(TreeNode node, int currentValue, int target) {
        if (node == null) return;
        if (node.val == target) {
            currentValue++;
        } else {
            currentValue=1;
        }
        maxSequence = Math.max(maxSequence, currentValue);
        helper(node.left, currentValue, node.val+1);
        helper(node.right, currentValue, node.val+1);
    }


    public static void addNode(int value) {
        if (root == null)
         root = new TreeNode(value);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
    }

    // Definition for a Node.
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}

