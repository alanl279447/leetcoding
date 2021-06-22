package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/diameter-of-n-ary-tree/
//        Input: root = [1,null,2,null,3,4,null,5,null,6]
//        Output: 4

public class DiameterofNAryTree_1522 {
    public static Node root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        addNode();
    }

    protected int diameter = 0;
    public int diameter(Node root) {
        this.diameter = 0;
        height(root);
        return diameter;
    }

    /**
     * return the height of the node
     */
    protected int height(Node node) {
        if (node.children.size() == 0)
            return 0;

        // select the top two largest heights
        int maxHeight1 = 0, maxHeight2 = 0;
        for (Node child : node.children) {
            int parentHeight = height(child) + 1;
            if (parentHeight > maxHeight1) {
                maxHeight2 = maxHeight1;
                maxHeight1 = parentHeight;
            } else if (parentHeight > maxHeight2) {
                maxHeight2 = parentHeight;
            }
            // calculate the distance between the two farthest leaves nodes.
            int distance = maxHeight1 + maxHeight2;
            this.diameter = Math.max(this.diameter, distance);
        }
        return maxHeight1;
    }

    public static void addNode() {
        root = new Node();
    }

    static class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val,ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
