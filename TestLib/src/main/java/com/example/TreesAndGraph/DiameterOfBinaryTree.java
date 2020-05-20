package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DiameterOfBinaryTree {

//                    1
//                   / \
//                  2   3
//                / \
//              4   5
//    Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
//    https://leetcode.com/problems/diameter-of-binary-tree/

    public static TreeNode root;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        addNode(1);
        System.out.print(diameterOfBinaryTree(root));
    }

    static int ans;


    public static int diameterOfBinaryTree(TreeNode root) {
        //ans = 1;
        depth(root);
        return ans;
    }

    public static int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L+R);
        return Math.max(L, R) + 1;
    }

    public static void addNode(int value) {
        root = new TreeNode(value);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(7);
//        root.right.right = new TreeNode(8);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
