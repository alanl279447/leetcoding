package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode_116 {
//    Input: root = [1,2,3,4,5,6,7]
//    Output: [1,#,2,3,#,4,5,6,7,#]
//    Explanation: Given the above perfect binary tree (Figure A),
//    your function should populate each next pointer to point to its next right node,
//    just like in Figure B. The serialized output is in level order as connected by the next pointers,
//    with '#' signifying the end of each level.
//    https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

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

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i < size; i++) {
                Node curr = queue.poll();
                if (i < size-1) {
                    curr.next=queue.peek();
                }
                if (curr.left!=null) {
                    queue.offer(curr.left);
                }
                if (curr.right!=null) {
                    queue.offer(curr.right);
                }
            }
        }
        return root;
    }

    public static void addNode(int value) {
        if (root == null)
         root = new Node(value);
        root.left = new Node(2);
//        root.left.left = new TreeNode(5);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(4);
//        root.right.left = new TreeNode(15);
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

