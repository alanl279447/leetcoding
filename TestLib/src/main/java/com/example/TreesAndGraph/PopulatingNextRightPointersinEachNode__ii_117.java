package com.example.TreesAndGraph;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode__ii_117 {
//    Input: root = [1,2,3,4,5,null,7]
//    Output: [1,#,2,3,#,4,5,7,#]
//    Explanation: Given the above binary tree (Figure A),
//    your function should populate each next pointer to point to its next right node,
//    just like in Figure B. The serialized output is in level order as connected by the next pointers,
//    with '#' signifying the end of each level.
//    https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
    public static Node root = null;
//    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        addNode(1);
        Node result = connect(root);
//        for (int res: result) {
            System.out.print(result);
//        }
    }

    public static Node connect(Node root) {

        if (root == null) {
            return root;
        }

        // Initialize a queue data structure which contains
        // just the root of the tree
        Queue<Node> Q = new LinkedList<Node>();
        Q.add(root);

        // Outer while loop which iterates over
        // each level
        while (Q.size() > 0) {

            // Note the size of the queue
            int size = Q.size();

            // Iterate over all the nodes on the current level
            for(int i = 0; i < size; i++) {

                // Pop a node from the front of the queue
                Node node = Q.poll();

                // This check is important. We don't want to
                // establish any wrong connections. The queue will
                // contain nodes from 2 levels at most at any
                // point in time. This check ensures we only
                // don't establish next pointers beyond the end
                // of a level
                if (i < size - 1) {
                    node.next = Q.peek();
                }

                // Add the children, if any, to the back of
                // the queue
                if (node.left != null) {
                    Q.add(node.left);
                }
                if (node.right != null) {
                    Q.add(node.right);
                }
            }
        }

        // Since the tree has now been modified, return the root node
        return root;
    }

    public static void addNode(int value) {
        if (root == null)
         root = new Node(value);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(7);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}

