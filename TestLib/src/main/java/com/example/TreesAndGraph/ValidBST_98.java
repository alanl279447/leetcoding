package com.example.TreesAndGraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ValidBST_98 {

//             2
//            / \
//           1   3
//
//    Input: [2,1,3]
//    Output: true

    public static TreeNode root = null;
    public static void main(String[] args) {
//        addNode(2);
//        addNode( 1);
//        addNode( 3);
        addNode(5);
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBSTPractice(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack();
        double minvalue = -Double.MAX_VALUE;
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val < minvalue) {
                return false;
            }
            minvalue = root.val;
            stack.push(root.right);
        }
        return true;
    }


    public static boolean isValidBST(TreeNode root) {
       if (root == null) return true;
       Stack<TreeNode> stack = new Stack<>();
       double minValue = -Double.MAX_VALUE;

       while(!stack.isEmpty() || root != null) {
           while(root != null) {
               stack.push(root);
               root = root.left;
           }

           root = stack.pop();
           if (root.val <=minValue) {
               return false;
           }
           minValue = root.val;
           root = root.right;
       }
       return true;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }





//    public static boolean isValidBST(TreeNode root) {
//        Stack<TreeNode> stack = new Stack();
//        double inorder = - Double.MAX_VALUE;
//
//        while (!stack.isEmpty() || root != null) {
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            // If next element in inorder traversal
//            // is smaller than the previous one
//            // that's not BST.
//            if (root.val <= inorder) return false;
//            inorder = root.val;
//            root = root.right;
//        }
//        return true;
//    }

    public static void addNode(int value) {
        root = addNodeRecursive(root, value);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(18);
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
