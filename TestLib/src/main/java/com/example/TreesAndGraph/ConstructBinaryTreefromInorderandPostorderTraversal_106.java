package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConstructBinaryTreefromInorderandPostorderTraversal_106 {
//    inorder = [9,3,15,20,7]
//    postorder = [9,15,7,20,3]
//    https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

    public static TreeNode root = null;
//    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[] inorder =   {9,3,15,20,7};
        int[] postorder =  {9,15,7,20,3};
        TreeNode result = buildTree(inorder, postorder);
        System.out.print(result.val);
    }

    private static int pS = 0;
    private static TreeNode buildTreePrac(int[] inorder, int[] postOrder) {
       int len = inorder.length;
       pS = len-1;
       TreeNode root = buildTreeHelper(inorder, 0, len, postOrder);
       return root;
    }

   private static TreeNode buildTreeHelper(int[] inorder, int iStart, int iEnd, int[] postorder) {
        if (iStart>iEnd || iStart < 0) return null;

        TreeNode root = new TreeNode(postorder[pS]);
        pS--;
        int iIndex = 0;
        for (int i= iStart;i<iEnd; i++) {
            if (inorder[i]==root.val) {
                iIndex=i;
                break;
            }
        }
       root.right = buildTreeHelper(inorder, iIndex+1, iEnd, postorder);
       root.left = buildTreeHelper(inorder, iStart, iIndex-1, postorder);
       return root;
   }


    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        pS = len-1;
        return buildTree(inorder, 0, len-1, postorder);
    }

    private static TreeNode buildTree(int[] inorder, int iStart, int iEnd, int[] postorder) {
        if(iEnd < iStart || iStart < 0) return null;
        TreeNode root = new TreeNode(postorder[pS]);
        pS--;
        int index = -1;
        for(int i=iStart;i<=iEnd;i++){
            if(inorder[i] == root.val) {
                index = i;
                break;
            }
        }
        root.right = buildTree(inorder, index+1, iEnd, postorder);
        root.left = buildTree(inorder, iStart, index-1, postorder);

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

