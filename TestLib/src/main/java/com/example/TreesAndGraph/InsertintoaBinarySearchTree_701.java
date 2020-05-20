package com.example.TreesAndGraph;

public class InsertintoaBinarySearchTree_701 {
//    Given the tree:
//             4
//            / \
//           2   7
//          / \
//        1   3
//    And the value to insert: 5
//    https://leetcode.com/problems/insert-into-a-binary-search-tree/

    public static TreeNode root = null;
    public static void main(String[] args) {
        addNode(4);
        insertIntoBST(root, 5);
        System.out.print(root);
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode currentNode = root;
        if (root == null) {
           return new TreeNode(val);
        }

        while (currentNode != null) {
            if (currentNode.val < val) {
                if (currentNode.right == null) {
                 currentNode.right = new TreeNode(val);
                 return root;
                } else {
                    currentNode = currentNode.right;
                }
            } else {
                if(currentNode.left == null) {
                    currentNode.left = new TreeNode(val);
                    return root;
                } else {
                    currentNode = currentNode.left;
                }
            }
        }
        return root;
    }

    public static void addNode(int value) {
        if (root == null) {
            root = new TreeNode(value);
        }
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(7);
//        root.right.right = new TreeNode(9);
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
   }
}
