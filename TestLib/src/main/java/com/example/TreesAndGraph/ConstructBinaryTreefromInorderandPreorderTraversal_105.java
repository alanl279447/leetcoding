package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConstructBinaryTreefromInorderandPreorderTraversal_105 {
//    preorder = [3,9,20,15,7]
//    inorder = [9,3,15,20,7]
//    https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
//    https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/34538/My-Accepted-Java-Solution

    public static TreeNode root = null;
//    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
//        addNode(1);
        int[] preorder = {3,9,20,15,7};
        int[] inorder =  {9,3,15,20,7};
        TreeNode result = buildTree(preorder, inorder);
        System.out.print(result.val);
    }

    //preOrder 3,9,20,15,7   node,left,right
    //inOrder  9,3,15,20,7   left,node,right
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    //preOrder start, inOrder start, inOrder end, preOrder, inOrder
    public static TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);

        // goal is to find right node position in pre-order traversal
        // root position + no of nodes left + 1  (right position in pre-order)..
        // on of nodes left (inIndex - inStart)    inIndex - index of root, inStart - start of inOrder traversal
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
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

