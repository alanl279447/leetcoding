package com.example.TreesAndGraph;

import java.util.Stack;

public class TwoSumBST_1214 {

//    Input: root1 = [2,1,4], root2 = [1,0,3], target = 5
//    Output: true
//    Explanation: 2 and 3 sum up to 5.
//    https://leetcode.com/problems/two-sum-bsts/

    public static TreeNode root1;
    public static TreeNode root2;
    private static TreeNode ans = null;

    public static void main(String[] args) {
        addNode();
        addNode2();
        boolean result = twoSumBSTs(root1, root2, 18);
        System.out.println(result);
    }

    public static boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null || root2 == null) {
            return false;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

       while (root1 != null && root2 != null) {
           while(root1 != null) {
               stack1.push(root1);
               root1 = root1.left;
           }

           while(root2 != null) {
               stack2.push(root2);
               root2 = root2.right;
           }

           if (stack1.isEmpty() || stack2.isEmpty()) {
               break;
           }

           TreeNode t1 = stack1.peek();
           TreeNode t2 = stack2.peek();
           if (t1.val+t2.val == target) return true;
           else if (t1.val+t2.val > target) {
               stack2.pop();
               root2 = t2.left;
           } else {
               stack1.pop();
               root1=t1.right;
           }
       }
        return false;
    }

    public static void addNode() {
        root1 = new TreeNode(0);
        root1.left = new TreeNode(-10);
//        root1.left.right = new TreeNode(5);
//        root1.left.right.left = new TreeNode(4);
//        root1.left.right.right = new TreeNode(6);
        root1.right = new TreeNode(10);
    }

    public static void addNode2() {
        root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.left.left = new TreeNode(0);
        root2.left.right = new TreeNode(2);
        root2.right = new TreeNode(7);
    }

    public static class Node {
        TreeNode node;
        int hd;

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
