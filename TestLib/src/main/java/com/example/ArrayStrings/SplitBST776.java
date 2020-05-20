package com.example.ArrayStrings;
import java.util.Stack;

public class SplitBST776 {
//    Input: root = [4,2,6,1,3,5,7], V = 2
//    Output: [[2,1],[4,3,6,null,null,5,7]]
//    Explanation:
//    Note that root, output[0], and output[1] are TreeNode objects, not arrays.
//    The given tree [4,2,6,1,3,5,7] is represented by the following diagram:
//                4
//              /   \
//            2      6
//           / \    / \
//         1   3  5   7
//
//            while the diagrams for the outputs are:
//              4
//            /   \
//           3    6      and    2
//               / \           /
//              5   7         1
//    https://leetcode.com/problems/split-bst/

    public static TreeNode root = null;
    public static void main(String args[]) {
        addNode(4);
        TreeNode[] result = splitBST(root, 2);
        //for(List<Integer> re: res) {
        System.out.println(result);
    }

    public static TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode[] ans = new TreeNode[2];
        if (root == null) {
            return ans;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            if (root.val > V) {
                root = root.left;
            }
            else {
                root = root.right;
            }
        }

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.val > V) {
                curr.left = ans[1];
                ans[1] = curr;
            }
            else {
                curr.right = ans[0];
                ans[0] = curr;
            }
        }
        return ans;
    }

    public static void addNode(int value) {
        if (root == null)
            root = new TreeNode(value);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(5);
    }

    // Definition for a Node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
