package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.List;

public class SumofNodeswithEvenValuedGrandparent_1315 {
//    Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
//    Output: 18
//    Explanation: The red nodes are the nodes with even-value grandparent
//                 while the blue nodes are the even-value grandparents.
//    https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        addNode();
        System.out.println(sumEvenGrandparent(root));
    }

    public static int sumEvenGrandparent(TreeNode root) {
        return helper(root,null,null); //Perform DFS
    }
    private static int helper(TreeNode current,TreeNode parent,TreeNode grandParent){
        int sum=0;
        if(current==null) return 0;
        if(grandParent!=null && grandParent.val % 2 == 0){
            sum+=current.val;
        }
        sum+= helper(current.left,current,parent);
        sum+=helper(current.right,current,parent);
        return sum;

    }

    public static void addNode() {
        root = addNodeRecursive(root, 6);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(9);
        root.left.right = new TreeNode(7);

        root.right = new TreeNode(8);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
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
