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
        TreeNode result = deleteNode(root, 5);
          System.out.println(result);
    }


    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private static TreeNode findMin(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
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
