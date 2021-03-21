package com.example.TreesAndGraph;

import java.util.LinkedList;
import java.util.List;

public class InorderSuccessorinBST_285 {

//    Input: root = [5,3,6,2,4,null,null,1], p = 3
//    Output: 4
//    Explanation: There is no in-order successor of the current node, so the answer is null.//
//    https://leetcode.com/problems/inorder-successor-in-bst/

    public static TreeNode root;
    private static TreeNode ans = null;

    public static void main(String[] args) {
        addNode(5);
        TreeNode result = inorderSuccessor(root, root.left);
        System.out.println(result.val);
    }

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode ret = null;
        while (root != null) { //5,3,4,null
               if (p.val >= root.val) {  //3 >=5, 3>=3
                   root = root.right;
               } else {
                   ret = root; //5,4
                   root = root.left; //3,null
               }
           }
        return ret;//4
    }

    public static void addNode(int value) {
        root = new TreeNode(value);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.right = new TreeNode(6);
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
