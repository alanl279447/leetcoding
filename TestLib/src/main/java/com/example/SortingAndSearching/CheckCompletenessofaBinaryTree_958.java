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

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        addNode(1);
        System.out.println(isCompleteTreeTest(root));
    }

    //queue with the root added
    //if queue.peek != null, add both the left & right
    //while queue !isEmpty && queue.peek() == null poll elements
    public static boolean isCompleteTreeTest(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<TreeNode>();
        bfs.offer(root);
        while (bfs.peek() != null) {
            TreeNode node = bfs.poll();
            bfs.offer(node.left);
            bfs.offer(node.right);
        }
        while (!bfs.isEmpty() && bfs.peek() == null)
            bfs.poll();
        return bfs.isEmpty();
    }

    public static boolean isCompleteTree(TreeNode root) {
      if (root == null) return true;
      Queue<TreeNode> queue = new LinkedList();
      queue.offer(root);
      boolean isEnd = false;
      while (!queue.isEmpty()) {
          TreeNode curr = queue.poll();
          if (curr == null) isEnd = true;
          else {
              if(isEnd) return false;
              queue.add(curr.left);
              queue.add(curr.right);
          }
      }
      return false;
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
