package com.example.TreesAndGraph;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

public class MaximumWidthBinaryTree662 {
//                   1
//                 /   \
//                3     2
//               / \     \
//              5   3     9
//
//    Output: 4
//    Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        addNode(1);
        System.out.print(widthOfBinaryTree(root));
    }

    public static void addNode(int value) {
        root = addNodeRecursive(root, value);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);
    }

    public static int widthOfBinaryTree(TreeNode root) {
        return getWidth(root, 0, 1, new ArrayList<>());
    }

    public static int getWidth(TreeNode node, int depth, int position, List<Integer> starts) {
       if (node == null) return 0;

       if (starts.size() == depth) {
           starts.add(position);  //add the left position
       }
       int curr = position - starts.get(depth) + 1;
       int leftWidth = getWidth(node.left, depth+1, position*2+1, starts);
       int rightWidth = getWidth(node.right, depth+1, position*2+2, starts);
       return Math.max(curr, Math.max(leftWidth, rightWidth));
    }















//    public static int widthOfBinaryTree(TreeNode root) {
//        return dfs(root, 0, 1, new ArrayList<>());
//    }
//
//    private static int dfs(TreeNode node, int depth, int postion, List<Integer> starts) {
//        if (node == null) return 0;
//        if (starts.size() == depth) starts.add(postion);
//
//        int cur = postion - starts.get(depth) + 1;
//        int leftResult = dfs(node.left, depth + 1, postion * 2 + 1, starts);
//        int rightResult = dfs(node.right, depth + 1, postion * 2 + 2, starts);
//        return Math.max(cur, Math.max(leftResult, rightResult));
//    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
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
