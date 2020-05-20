package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeVerticalOrderTraversal_314 {
//    Input: [3,9,20,null,null,15,7]
//
//              3
//            /  \
//           9   8
//        /   \ /  \
//       4    0 1   7
//
//    Output:
//
//            [
//            [4],
//            [9],
//            [3,0,1],
//            [8],
//            [7]
//            ]
//    If two nodes are in the same row and column, the order should be from left to right.
//     https://leetcode.com/problems/binary-tree-vertical-order-traversal/

    public static TreeNode root;
    private static TreeNode ans = null;

    public static void main(String[] args) {
        addNode(3);
        List<List<Integer>> result = verticalOrder(root);
        for(List<Integer> res: result)
          System.out.println(res.toString());
    }

    private static int min = 0, max = 0;

    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)    return list;
        computeRange(root, 0);
        for(int i = min; i <= max; i++) {
            list.add(new ArrayList<>());
        }
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> idx = new LinkedList<>();
        idx.add(-min);
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            int i = idx.poll();
            list.get(i).add(node.val);
            if(node.left != null){
                q.add(node.left);
                idx.add(i - 1);
            }
            if(node.right != null){
                q.add(node.right);
                idx.add(i + 1);
            }
        }
        return list;
    }
    private static void computeRange(TreeNode root, int idx){
        if(root == null)    return;
        min = Math.min(min, idx);
        max = Math.max(max, idx);
        computeRange(root.left, idx - 1);
        computeRange(root.right, idx + 1);
    }

    public static void addNode(int value) {
        root = new TreeNode(value);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(0);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(1);
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
