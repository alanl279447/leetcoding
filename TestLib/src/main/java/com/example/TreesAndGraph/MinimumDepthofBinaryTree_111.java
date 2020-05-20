package com.example.TreesAndGraph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumDepthofBinaryTree_111 {

//    Input:
//
//              1
//            /   \
//           2     3
//            \
//            5
//           / \
//          4  6
//    return its minimum depth = 2.
//
//    Explanation: All root-to-leaf paths are: 1->2->5, 1->3
//    https://leetcode.com/problems/minimum-depth-of-binary-tree/

    public static TreeNode root;
    private static TreeNode ans = null;

    public static void main(String[] args) {
        addNode(1);
        int result = minDepth(root);
          System.out.println(result);
    }

    public static int minDepth(TreeNode root) {
       if (root == null) return 0;
       Queue<TreeNode> queue = new LinkedList<>();
       queue.offer(root);
       int level = 1;

       while(!queue.isEmpty()) {
           int size = queue.size();
           while (size >0) {
               TreeNode node = queue.poll();
               if (node.left == null && node.right == null) {
                   return level;
               }
               if (node.left != null) {
                   queue.offer(node.left);
               }
               if (node.right != null) {
                   queue.offer(node.right);
               }
               size--;
           }
           level++;
       }
       return level;
    }


    public static void addNode(int value) {
        root = new TreeNode(value);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
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
