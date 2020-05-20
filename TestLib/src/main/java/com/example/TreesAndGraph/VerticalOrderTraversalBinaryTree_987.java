package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversalBinaryTree_987 {
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
        for(List<Integer> res: result)
            System.out.println(res.toString());
    }

   // (-2,+2)(-1,+1)(0,0),(+1,+1), (+2,+2)
    static List<Location> locations;
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        // Each location is a node's x position, y position, and value
        locations = new ArrayList();
        dfs(root, 0, 0);

        Collections.sort(locations);
        List<List<Integer>> ans = new ArrayList();
        ans.add(new ArrayList<Integer>());

        int prev = locations.get(0).x;
        for (Location loc: locations) {
            // If the x value changed, it's part of a new report.
            if (loc.x != prev) {
                prev = loc.x;
                ans.add(new ArrayList<Integer>());
            }

            // We always add the node's value to the latest report.
            ans.get(ans.size() - 1).add(loc.val);
        }

        return ans;
    }

    public static void dfs(TreeNode node, int x, int y) {
        if (node != null) {
            locations.add(new Location(x, y, node.val));
            dfs(node.left, x-1, y+1);
            dfs(node.right, x+1, y+1);
        }
    }

    static class Location implements Comparable<Location> {
        int x, y, val;

        Location(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Location that) {
            if (this.x != that.x)
                return Integer.compare(this.x, that.x);
            else if (this.y != that.y)
                return Integer.compare(this.y, that.y);
            else
                return Integer.compare(this.val, that.val);
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
