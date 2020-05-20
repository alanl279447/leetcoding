package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestElementinaSortedMatrix_378 {

//    matrix = [
//            [ 1,  5,  9],
//            [10, 11, 13],
//            [12, 13, 15]
//            ],
//    k = 8,
//
//            return 13.
//    https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

    public static TreeNode root;
    private static TreeNode ans = null;

    public static void main(String[] args) {
        addNode(1);
        int[][] input={{1,5,9}, {10,11,13},{12,13,15}};
        int result = kthSmallest(input, 8);
        //for(String res: result)
        System.out.println(result);
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int column = matrix[0].length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();

        for (int i=0; i < row; i++) {
            pq.offer(new Tuple(0, i, matrix[0][i]));
        }
        for (int i=0; i< k-1; i++) {
            Tuple curr = pq.poll();
            if (curr.x == column-1) continue;
            pq.offer(new Tuple(curr.x+1, curr.y, matrix[curr.x+1][curr.y]));
        }
        return pq.poll().value;
    }

    static class Tuple implements Comparable<Tuple> {
        int x;
        int y;
        int value;

        public Tuple(int x, int y, int value) {
           this.x = x;
           this.y = y;
           this.value = value;
        }

        @Override
        public int compareTo(Tuple that) {
            return this.value - that.value;
        }

    }

    public static void addNode(int value) {
        root = new TreeNode(value);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
    }

    public static class Node {
        TreeNode node;
        int hd;

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
