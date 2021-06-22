package com.example.TreesAndGraph;

public class MaximumNestingDepthoftheParentheses_1614 {

//    https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
//    Input: s = "(1+(2*3)+((8)/4))+1"
//    Output: 3
//    Explanation: Digit 8 is inside of 3 nested parentheses in the string.

    public static TreeNode root;
    private static TreeNode ans = null;

    public static void main(String[] args) {
        addNode(4);
        int result = maxDepth("(1+(2*3)+((8)/4))+1");
        System.out.println(result);
    }

    public static int maxDepth(String s) {
        int res = 0, cur = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(')
                res = Math.max(res, ++cur);
            if (s.charAt(i) == ')')
                cur--;
        }
        return res;
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
