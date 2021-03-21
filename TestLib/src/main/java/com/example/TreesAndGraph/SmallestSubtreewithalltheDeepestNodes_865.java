package com.example.TreesAndGraph;

public class SmallestSubtreewithalltheDeepestNodes_865 {
//    Input: [3,5,1,6,2,0,8,null,null,7,4]
//    Output: [2,7,4]
//    Explanation: We return the node with value 2, colored in yellow in the diagram.
//    The nodes colored in blue are the deepest nodes of the tree.
//    The input "[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]" is a serialization of the given tree.
//    The output "[2, 7, 4]" is a serialization of the subtree rooted at the node with value 2.
//    Both the input and output have TreeNode type.
//    https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/

    public static TreeNode root = null;
    public static void main(String[] args) {
        addNode(3);
        TreeNode result = subtreeWithAllDeepest(root);
        System.out.print(result.val);
    }

    static int deepestLevel = 0;
    static TreeNode result = null;
    public static TreeNode subtreeWithAllDeepest(TreeNode root) {
       dfs(root, 0);
       return result;
    }

    public static int dfs(TreeNode node, int level) {
        if (node == null) {
            return level;
        }
        int left = dfs(node.left, level+1);
        int right = dfs(node.right, level+1);
        int currentMax = Math.max(left, right);
        deepestLevel = Math.max(deepestLevel, currentMax);

        if (left == deepestLevel && right == deepestLevel) {
            result = node;
        }
        return currentMax;
    }

    //added for tree creation
    public static void addNode(int value) {
        if (root == null) {
            root = new TreeNode(value);
        }
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
   }
}
