package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DeleteNodeinaBST_450 {
//    root = [5,3,6,2,4,null,7]
//    key = 3
//
//             5
//            / \
//           3   6
//          / \   \
//        2   4   7
//
//    Given key to delete is 3. So we find the node with value 3 and delete it.
//   https://leetcode.com/problems/delete-node-in-a-bst/

    public static TreeNode root;
    private static TreeNode ans = null;

    public static void main(String[] args) {
        addNode(5);
        TreeNode result = deleteNode(root, 3);
        System.out.println(result);
    }

    /*
    One step right and then always left
    */
    public static int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) root = root.left;
        return root.val;
    }

    /*
    One step left and then always right
    */
    public static int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) root = root.right;
        return root.val;
    }

    public static TreeNode deleteNodeTest(TreeNode root, int key) {
      if (root == null) return root;

      if (key > root.val) {
         // right subTree
         root.right = deleteNodeTest(root.right, key);
      } else if (key < root.val) {
          root.left = deleteNodeTest(root.left, key);
      } else {
          if (root.left == null && root.right == null) return null;
          else if (root.right != null) {
              root.val = successor(root);
              root.right = deleteNodeTest(root.right, root.val);
          } else {
              root.val = predecessor(root);
              root.left = deleteNodeTest(root.left, root.val);
          }
      }
       return root;
    }




    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // delete from the right subtree
        if (key > root.val) root.right = deleteNode(root.right, key);
            // delete from the left subtree
        else if (key < root.val) root.left = deleteNode(root.left, key);
            // delete the current node
        else {
            // the node is a leaf
            if (root.left == null && root.right == null) root = null;
                // the node is not a leaf and has a right child
            else if (root.right != null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            }
            // the node is not a leaf, has no right child, and has a left child
            else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    public static void addNode(int value) {
        root = new TreeNode(value);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
//        root.left.right.left = new TreeNode(2);
        //root.left.right.right.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
    }

    public static class Node {
        TreeNode node;
        int hd; //horiozntal distance

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
