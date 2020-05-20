package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VerticalOrderTraversalBinaryTree_987_test {
//    Input: [3,9,20,null,null,15,7]
//
//              3
//            /  \
//           9   8
//        /   \ /  \
//       4    0 1   7
//
//    Output:
//
//            [
//            [4],
//            [9],
//            [3,0,1],
//            [8],
//            [7]
//            ]
//    Explanation:
//    Without loss of generality, we can assume the root node is at position (0, 0):
//    Then, the node with value 9 occurs at position (-1, -1);
//    The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
//    The node with value 20 occurs at position (1, -1);
//    The node with value 7 occurs at position (2, -2).
//    https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

    public static TreeNode root;
    private static TreeNode ans = null;

    public static void main(String[] args) {
        addNode(3);
        List<List<Integer>> result = verticalTraversal(root);
        for (List<Integer> res : result)
            System.out.println(res.toString());
    }

//    public static List<List<Integer>> verticalTraversalPrac(TreeNode root) {
//        List<List<Integer>> result = new ArrayList<>();
//
//
//
//    }
    static List<location> locations = new ArrayList<>();
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, 0);
        location prev = locations.get(0);
        result.add(new ArrayList<>());

        for (int i = 0; i < locations.size(); i++) {
            location current = locations.get(i);
            if (prev.x != current.x) {
                result.add(new ArrayList<>());
                prev = current;
            }
            result.get(result.size()-1).add(current.val);
        }

        return result;
    }

    public static void dfs(TreeNode root, int x, int y) {
        if (root == null) return;
        locations.add(new location(x,y, root.val));
        dfs(root.left, x-1, y+1);
        dfs(root.right, x+1, y+1);
    }

    public static class location implements Comparable<location> {
        int x;
        int y;
        int val;

        public location(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(location that) {
            if (this.x != that.x) {
                return Integer.compare(this.x, that.x);
            } else if (this.y != that.x) {
                return Integer.compare(this.y, that.y);
            } else {
                return Integer.compare(this.val, that.val);
            }
        }
    }

    // test API's
    public static void addNode(int value) {
        root = new TreeNode(value);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(0);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(7);
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
