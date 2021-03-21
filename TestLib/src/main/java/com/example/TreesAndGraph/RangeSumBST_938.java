package com.example.TreesAndGraph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class RangeSumBST_938 {
//    Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
//    Output: 32
//    https://leetcode.com/problems/range-sum-of-bst/

    public static TreeNode root;
    private static TreeNode ans = null;

    public static void main(String[] args) {
        addNode(10);
        System.out.println(rangeSumBST(root, 7,15));
    }

    //dfs
    public static int rangeSumBST(TreeNode root, int L, int R) {
       if (root == null) return 0;
       Deque<TreeNode> stack = new ArrayDeque();
       stack.offer(root);
       int ans = 0;
       while (!stack.isEmpty()) {
           TreeNode curr = stack.poll();
           if (curr== null) continue;
           if (L<= curr.val && curr.val <= R) {
               ans += curr.val;
           }
           if (L < curr.val && curr.left != null) {
               stack.offer(curr.left);
           }
           if (curr.val < R  && curr.right != null) {
               stack.offer(curr.right);
           }
       }
       return ans;
    }

    public static void addNode(int value) {
        root = new TreeNode(value);
        root.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.left.left = new TreeNode(3);

        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);
    }

    public static class Node {
        TreeNode node;
        int hd;

        public Node(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
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
