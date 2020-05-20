package com.example.TreesAndGraph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class BinaryTreePaths_257 {

//    Input:
//
//              1
//            /   \
//           2     3
//            \
//            5
//           / \
//          4  6
//    Output: ["1->2->5", "1->3"]
//
//    Explanation: All root-to-leaf paths are: 1->2->5, 1->3
//    https://leetcode.com/problems/binary-tree-paths/

    public static TreeNode root;
    private static TreeNode ans = null;

    public static void main(String[] args) {
        addNode(1);
        List<String> result = binaryTreePaths(root);
        for (String res : result)
            System.out.println(res.toString());
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> paths = new LinkedList();
        construct_paths(root, "", paths);
        return paths;
    }

    public static void construct_paths(TreeNode root, String path, LinkedList<String> paths) {
        if (root != null) {
            path += Integer.toString(root.val);
            if ((root.left == null) && (root.right == null))  // if reach a leaf
                paths.add(path);  // update paths
            else {
                path += "->";  // extend the current path
                construct_paths(root.left, path, paths);
                construct_paths(root.right, path, paths);
            }
        }
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
