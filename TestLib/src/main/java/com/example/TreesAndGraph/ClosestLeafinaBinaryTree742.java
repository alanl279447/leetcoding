package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ClosestLeafinaBinaryTree742 {

//    https://leetcode.com/problems/closest-leaf-in-a-binary-tree/
//    Input:
//    root = [1, 3, 2], k = 1
//    Diagram of binary tree:
//            1
//            / \
//            3   2
//
//    Output: 2 (or 3)
//
//    Explanation: Either 2 or 3 is the nearest leaf node to the target of 1.
//    Time complexity 0(n) no of nodes in given tree.

    public static TreeNode root;
    private static TreeNode ans = null;

    public static void main(String[] args) {
        addNode(4);
        int result = findClosestLeaf(root, 1);
        System.out.println(result);
    }

    //DFS starting from root, find the treeNode
    //BFS from the start node to the leaf node
    public static int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, TreeNode> backMap = new HashMap<>();   // store all edges that trace node back to its parent
        Queue<TreeNode> queue = new LinkedList<>();          // the queue used in BFS
        Set<TreeNode> visited = new HashSet<>();             // store all visited nodes

        // DFS: search for node whoes val == k
        TreeNode kNode = DFS(root, k, backMap);
        queue.add(kNode);
        visited.add(kNode);

        // BFS: find the shortest path
        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if(curr.left == null && curr.right == null) {
                return curr.val;
            }
            if(curr.left != null && visited.add(curr.left)) {
                queue.add(curr.left);
            }
            if(curr.right != null && visited.add(curr.right)) {
                queue.add(curr.right);
            }
            if(backMap.containsKey(curr) && visited.add(backMap.get(curr))) {  // go alone the back edge
                queue.add(backMap.get(curr));
            }
        }
        return -1; // never hit
    }

    private static TreeNode DFS(TreeNode root, int k, Map<TreeNode, TreeNode> backMap) {
        if(root.val == k) {
            return root;
        }
        if(root.left != null) {
            backMap.put(root.left, root);        // add back edge
            TreeNode left = DFS(root.left, k, backMap);
            if(left != null) return left;
        }
        if(root.right != null) {
            backMap.put(root.right, root);       // add back edge
            TreeNode right = DFS(root.right, k, backMap);
            if(right != null) return right;
        }
        return null;
    }

    public static void addNode(int value) {
        root = new TreeNode(value);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(6);
        root.left.right.right.left = new TreeNode(2);

        root.right = new TreeNode(9);
        root.right.left = new TreeNode(6);
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
