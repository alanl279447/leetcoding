package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor_III_1650 {
//    Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//    Output: 3
//    Explanation: The LCA of nodes 5 and 1 is 3.
//    https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/
//    O(h1 + h2) where h1 and h2 are heights of the two given nodes
//    https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/discuss/933885/Java-100.-This-is-a-Linked-List-question.
    public static Node root;
    //private static Node ans = null;

    public static void main(String[] args) {
        addNode(3);
        Node ans = lowestCommonAncestorFast(root.left, root.left.right.right);
        System.out.print(ans.val);
    }

    public static Node lowestCommonAncestorFast(Node p, Node q) {
        Node p1 = p, p2 = q;
        while (p1 != p2) {
            p1 = p1 == null ? q : p1.parent;
            p2 = p2 == null ? p : p2.parent;
        }
        return p1;
    }

    public static Node lowestCommonAncestorSlow(Node p, Node q) {
         List<Node> pathNodes = findPath(p);
         while (q != null) {
             for (Node temp: pathNodes) {
                 if (q == temp) {
                     return q;
                 }
             }
             q = q.parent;
         }
         return q;
    }

    public static List<Node> findPath(Node p) {
        List<Node> pathNodes = new ArrayList<>();
        while (p != null) {
            pathNodes.add(p);
            p = p.parent;
        }
        return pathNodes;
    }

    public static void addNode(int value) {
        root = new Node(value);
        root.parent = null;

        root.left = new Node(5);
        root.left.parent = root;

        root.left.left = new Node(6);
        root.left.left.parent = root.left;

        root.left.right = new Node(2);
        root.left.right.parent = root.left;

        root.left.right.left = new Node(7);
        root.left.right.left.parent = root.left.right;

        root.left.right.right = new Node(4);
        root.left.right.right.parent = root.left.right;

        root.right = new Node(1);
        root.right.parent = root;

        root.right.left = new Node(0);
        root.right.left.parent = root.right;

        root.right.right = new Node(8);
        root.right.right.parent = root.right;
    }

    public static class Node {
        int val;
        Node left;
        Node right;
        Node parent;

        Node(int x) {
            val = x;
        }
    }
}