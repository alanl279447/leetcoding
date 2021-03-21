package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class
FindKPairswithSmallestSums_373 {

//    Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//    Output: [[1,2],[1,4],[1,6]]
//    Explanation: The first 3 pairs are returned from the sequence:
//            [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
//    https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
//    https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

    public static TreeNode root;
    private static TreeNode ans = null;

    public static void main(String[] args) {
        addNode(1);
        int[] nums1 ={1,7,11};
        int[] nums2 ={2,4,6};
        List<List<Integer>> result = kSmallestPairs(nums1, nums2, 2);
        //for(String res: result)
        System.out.println(result);
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        int m = nums1.length, n = nums2.length;
        List<List<Integer>> res = new ArrayList<>();
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0) return res;
        for(int j = 0; j <= n-1; j++) {
            pq.offer(new Tuple(0, j, nums1[0]+nums2[j]));
        }
        for(int i = 0; i < Math.min(k, m *n); i++) {
            Tuple t = pq.poll();
            res.add(new ArrayList<>(Arrays.asList(nums1[t.x], nums2[t.y])));
            if(t.x == m - 1) continue;
            pq.offer(new Tuple (t.x + 1, t.y, nums1[t.x + 1] + nums2[t.y]));
        }
        return res;
    }

    static class Tuple implements Comparable<Tuple> {
        int x, y, val;
        public Tuple (int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo (Tuple that) {
            return this.val - that.val;
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
