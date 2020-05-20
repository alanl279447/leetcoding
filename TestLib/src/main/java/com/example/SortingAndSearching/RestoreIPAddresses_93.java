package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class RestoreIPAddresses_93 {

//    Input: "25525511135"
//    Output: ["255.255.11.135", "255.255.111.35"]
//    https://leetcode.com/problems/restore-ip-addresses/

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        System.out.print(restoreIpAddresses("25525511135"));
    }

    public static List<String> restoreIpAddresses(String s) {
        final List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0 || s.length() > 12) {
            return result;
        }
        final List<String> path = new ArrayList<>();
        match(result, path, 0, s);
        return result;
    }

    private static void match(List<String> result, List<String> path, int index, String s) {
        if (path.size() == 4) {
            if (index == s.length()) {
                result.add(String.join(".", path));
            }
            return;
        }

        // can have "0" but not "00" or "01"
        for (int i = index; i < index + 3 && i < s.length(); i++) {
            String current = s.substring(index, i + 1);
            int value = Integer.valueOf(current);
            if (value > 255) {
                break;
            }
            // remove "0xx"
            if (i != index && current.charAt(0) == '0') {
                break;
            }
            path.add(current);
            match(result, path, i + 1, s);
            path.remove(path.size() - 1);
        }
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
