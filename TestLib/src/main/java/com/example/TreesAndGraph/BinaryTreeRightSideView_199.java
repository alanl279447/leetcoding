package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeRightSideView_199 {
//    Input: [1,2,3,null,5,null,4]
//    Output: [1, 3, 4]
//    Explanation:
//
//              1            <---
//            /   \
//            2     3         <---
//            \     \
//            5     4       <---
//    https://leetcode.com/problems/binary-tree-right-side-view/

    public static TreeNode root = null;
//    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        addNode(1);
        List<Integer> result = rightSideView(root);
        for (int res: result) {
            System.out.print(res);
        }
    }

    public static List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
          int size = queue.size();
          for (int i=0; i < size; i++) {
              TreeNode currentNode = queue.poll();
              if(i == 0) {
                  result.add(currentNode.val);
              }
              if(currentNode.right != null) {
                  queue.offer(currentNode.right);
              }
              if(currentNode.left != null) {
                  queue.offer(currentNode.left);
              }
          }
        }
        return result;
    }

    public static void addNode(int value) {
        if (root == null)
         root = new TreeNode(value);
        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
//        root.right.left = new TreeNode(15);
    }

    // Definition for a Node.
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}

