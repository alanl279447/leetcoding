package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest_1110 {
//    https://leetcode.com/problems/delete-nodes-and-return-forest/
//    Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
//    Output: [[1,2,null,4],[6],[7]]

    public static TreeNode root;
    private static TreeNode ans = null;

    public static void main(String[] args) {
        addNode(1);
        int[] to_delete = {3,5};
        List<TreeNode>  result = delNodes(root, to_delete);
        for (TreeNode res: result)
          System.out.println(result);
    }

    //move the to_delete entries to a set/
    //bottom up approach to check and delete the nodes
    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> forest = new ArrayList<>();
        if (root == null) return forest;
        Set<Integer> set = new HashSet<>();
        for(int i : to_delete) {
            set.add(i);
        }
        deleteNodes(root, set, forest);
        if (!set.contains(root.val)) {
            forest.add(root);
        }
        return forest;
    }

    private static TreeNode deleteNodes(TreeNode node, Set<Integer> set, List<TreeNode> forest) {
        if (node == null) return null;

        node.left = deleteNodes(node.left, set, forest);
        node.right = deleteNodes(node.right, set, forest);

        //check the child nodes, before deleting
        if (set.contains(node.val)) {
            if (node.left != null) forest.add(node.left);
            if (node.right != null) forest.add(node.right);
            return null;
        }
        return node;
    }

    public static void addNode(int value) {
        root = new TreeNode(value);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
//        root.left.right.right = new TreeNode(6);
//        root.left.right.right.left = new TreeNode(2);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
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
