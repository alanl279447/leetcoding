package com.example.TreesAndGraph;

public class LowestCommonAncestor_II_1644 {

//    Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//    Output: 3
//    Explanation: The LCA of nodes 5 and 1 is 3.
//    https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/

    public static TreeNode root;
    public static void main(String[] args) {
        addNode(3);
        TreeNode ans = lowestCommonAncestor(root, root.left, root.left.right.right);
        System.out.print(ans.val);
    }

    //difference from 236 is
//    It is NOT guaranteed that both p and q are in the tree.
//    A node can still be a descendant of itself. Hence
//    We need a way to record if we've seen both p and q
//    We need to traverse the entire tree even after we've found one of them.

    static int count = 0;
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        TreeNode LCA = dfsHelper(root, node1, node2);
        return count ==2 ? LCA : null;
    }

    public static TreeNode dfsHelper(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null) return root;

        TreeNode leftNode = dfsHelper(root.left, node1, node2);
        TreeNode rightNode = dfsHelper(root.right, node1, node2);

        if(root == node1 || root == node2) {
            count++;
            return root;
        }

        if (leftNode != null && rightNode != null) return root;
        return (leftNode != null) ? leftNode : rightNode;
    }


    public static void addNode(int value) {
        root = new TreeNode(value);
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

        TreeNode(int x) {
            val = x;
        }
    }
}
