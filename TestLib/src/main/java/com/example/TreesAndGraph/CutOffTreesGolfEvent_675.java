package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.List;

public class CutOffTreesGolfEvent_675 {
//    Input:
//            [
//            [1,2,3],
//            [0,0,4],
//            [7,6,5]
//            ]
//    Output: 6

//    https://leetcode.com/problems/cut-off-trees-for-golf-event/

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        addNode(-10);
        //System.out.print(cutOffTree(root));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

//    public static int cutOffTree(List<List<Integer>> forest) {
//
//    }

    public static void addNode(int value) {
        root = addNodeRecursive(root, value);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
    }

    public static TreeNode addNodeRecursive(TreeNode node, int value) {
//        TreeNode newNode = null;
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
