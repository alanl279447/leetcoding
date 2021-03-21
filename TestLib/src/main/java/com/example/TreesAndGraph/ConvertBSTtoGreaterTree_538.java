package com.example.TreesAndGraph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
//Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
//https://leetcode.com/problems/convert-bst-to-greater-tree/

public class ConvertBSTtoGreaterTree_538 {
    public static TreeNode root;
    private static TreeNode ans = null;

    public static void main(String[] args) {
        addNode(4);
        TreeNode result = convertBST(root);
        System.out.println(result.val);
    }

    public static TreeNode convertBST(TreeNode root) {
      if (root == null) return root;
      Queue<TreeNode> queue = new ArrayDeque();
      TreeNode curr = root;
      int sum=0;
      while (!queue.isEmpty() || curr != null) {
          while (curr != null) {
              queue.offer(curr);
              curr = curr.right;
          }
          TreeNode node = queue.poll();
          sum += node.val;
          node.val=sum;
          curr=node.left;
      }
      return root;
    }


    static int sum = 0;
    public TreeNode convertBSTRecursive(TreeNode root) {
        dfs(root);
        return root;
    }
    public void dfs(TreeNode root){
        if(root==null){
            return;
        }
        dfs(root.right);
        sum+=root.val;
        root.val = sum;
        dfs(root.left);
    }

    public static void addNode(int value) {
        root = new TreeNode(value);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);

        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(8);
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
