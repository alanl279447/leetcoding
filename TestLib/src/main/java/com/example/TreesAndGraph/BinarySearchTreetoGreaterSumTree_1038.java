package com.example.TreesAndGraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

//Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
//        Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
//        https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/

public class BinarySearchTreetoGreaterSumTree_1038 {
    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        addNode();
    }

    public static TreeNode bstToGst(TreeNode root) {
      Deque<TreeNode> stack = new ArrayDeque<>();
      int sum = 0;
      TreeNode curr = root;
      while (!stack.isEmpty() || curr != null) {
          while (curr != null) {
              stack.offer(curr);
              curr = curr.right;
          }
          curr = stack.poll();
          curr.val = curr.val + sum;
          sum = curr.val;
          curr = curr.left;
      }
      return root;
    }


    public static void addNode() {
        root = addNodeRecursive(root, 4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);

        root.right = new TreeNode(6);
        root.right.left = new TreeNode(26);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
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
