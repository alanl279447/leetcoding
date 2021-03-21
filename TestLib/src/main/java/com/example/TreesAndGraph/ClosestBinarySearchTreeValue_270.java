package com.example.TreesAndGraph;

public class ClosestBinarySearchTreeValue_270 {
//    Input: root = [4,2,5,1,3], target = 3.714286
//
//             4
//            / \
//            2   5
//            / \
//            1   3
//
//    Output: 4
//    https://leetcode.com/problems/closest-binary-search-tree-value/

    public static TreeNode root = null;
    public static void main(String[] args) {
        addNode(4);
        int result = closestValue(root, 3.714286);
        System.out.print(result);
    }

    public static int closestValue(TreeNode root, double target) {
        if (root == null) return 0;
        int closest = root.val;
        while(root != null) {
            if (Math.abs(root.val - target) < Math.abs(closest-target)) {
                closest = root.val;
            }
            if (root.val > target) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return closest;
    }

    public static void addNode(int value) {
//        root = addNodeRecursive(root, value);
        if (root == null) {
            root = new TreeNode(value);
        }
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
   }
}
