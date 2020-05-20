package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SimilarStringGroups_839 {
//    Input: A = ["tars","rats","arts","star"]
//    Output: 2
//    https://leetcode.com/problems/similar-string-groups/

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        String[] inputs = {"tars","rats","arts","star"};
        System.out.print(numSimilarGroups(inputs));
    }

    public static int numSimilarGroups(String[] a) {
        int r = 0;
        for (int i = 0; i < a.length; i++)
            if (a[i] != null) {
                r++;
                dfs(i, a);
            }
        return r;
    }

    // {"tars","rats","arts","star"};
    static void  dfs(int j, String[] a) {
        String s = a[j];
        a[j] = null;
        for (int i = 0; i < a.length; i++)
            if (a[i] != null && similarGroup(a[i], s))
                dfs(i, a);
    }

    static boolean similarGroup(String s, String t) {
        int diff = 0, i = 0;
        while (i < s.length() && diff <= 2)
            if (s.charAt(i) != t.charAt(i++))
                diff++;
        return  diff == 2 || diff == 0;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

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
