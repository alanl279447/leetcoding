package com.example.TreesAndGraph;

public class SymmetricTree {

//               1
//              / \
//             2   2
//            / \ / \
//           3  4 4  3

    public static TreeNode root = null;
    public static void main(String[] args) {
        addNode(1);
        System.out.println(isSymmetric(root));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static boolean isSymmetric(TreeNode root) {
        boolean status = isMirror(root.left, root.right);
        return status;
    }

    public static boolean isMirror(TreeNode left, TreeNode right) {
       if (left == null && right == null) return true;

       else if (left == null || right == null) return false;

       else if (left.val == right.val &&
               isMirror(left.right, right.left) &&
               isMirror(left.left, right.right))
           return true;

       return false;
    }

    public static void addNode(int value) {
        root = addNodeRecursive(root, value);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
    }


    public static TreeNode addNodeRecursive(TreeNode node, int value) {
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
