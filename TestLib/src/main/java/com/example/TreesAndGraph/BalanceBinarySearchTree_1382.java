package com.example.TreesAndGraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

//Input: root = [1,null,2,null,3,null,4,null,null]
//Output: [2,1,3,null,null,null,4]
//Explanation: This is not the only correct answer, [3,1,4,null,2,null,null] is also correct.
//https://leetcode.com/problems/balance-a-binary-search-tree/

public class BalanceBinarySearchTree_1382 {
    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        addNode();
        TreeNode result = balanceBST(root);
    }

    static List<Integer> sortedList = new ArrayList<>();
    public static TreeNode balanceBST(TreeNode root) {
         if(root == null) return root;
         inOrderTraversal(root);
         return SortedArrayToBST(0, sortedList.size()-1);
    }

    public static TreeNode SortedArrayToBST(int start, int end) {
        if (start > end) return null;
        int mid = start + (end-start)/2;
        TreeNode root = new TreeNode(sortedList.get(mid));
        root.left = SortedArrayToBST(start, mid - 1);
        root.right = SortedArrayToBST(mid + 1, end);
        return root;
    }

    public static void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        sortedList.add(root.val);
        inOrderTraversal(root.right);
    }

    public static void addNode() {
        root = addNodeRecursive(root, 1);
//        root.left = new TreeNode(15);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(7);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
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
