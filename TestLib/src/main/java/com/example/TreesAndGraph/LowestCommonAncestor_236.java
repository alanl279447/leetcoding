package com.example.TreesAndGraph;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class LowestCommonAncestor_236 {

//    Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//    Output: 3
//    Explanation: The LCA of nodes 5 and 1 is 3.
//
//    Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//    Output: 5
//    Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
//    https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

    public static TreeNode root;
    private static TreeNode ans = null;

    public static void main(String[] args) {
        addNode(3);
        lowestCommonAncestor(root, root.left, root.left.right.right);
        System.out.print(ans.val);
    }

    //fastest solution
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null) return null;
        // case 2 in above figure
        if (root.equals(node1) || root.equals(node2)) return root;
        TreeNode left = lowestCommonAncestor(root.left, node1, node2);
        TreeNode right = lowestCommonAncestor(root.right, node1, node2);
        // case 1
        if (left != null && right != null) return root;
        // at this point, left and right can't be both non-null
        // case 4 and 5, report target node or LCA back to parent
        if (left != null) return left;
        if (right != null) return right;
        // case 4, not found return null
        return null;
    }


    public TreeNode lowestCommonAncestorTest(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        Map<TreeNode, Integer> depth = new HashMap<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);
        depth.put(root, 0);

        int currentDepth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            currentDepth++;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) {
                    parents.put(current.left, current);
                    depth.put(current.left, currentDepth);
                    queue.add(current.left);
                }

                if (current.right != null) {
                    parents.put(current.right, current);
                    depth.put(current.right, currentDepth);
                    queue.add(current.right);
                }
            }
        }



        while (p != q) {
            if (depth.get(p) < depth.get(q)) {
                q = parents.get(q);
            } else if (depth.get(p) == 0 || depth.get(q) == 0) {
                return root;
            } else {
                p = parents.get(p);
            }
        }

        return p;
    }


    public static void addNode(int value) {
        root = new TreeNode(value);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
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
