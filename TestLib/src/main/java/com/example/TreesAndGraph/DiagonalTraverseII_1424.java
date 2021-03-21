package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagonalTraverseII_1424 {

//    Input:
//            [
//            [ 1, 2, 3 ],
//            [ 4, 5, 6 ],
//            [ 7, 8, 9 ]
//            ]
//
//    Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
//    Output: [1,4,2,7,5,3,8,6,9]
//    https://leetcode.com/problems/diagonal-traverse-ii/
//    https://leetcode.com/problems/diagonal-traverse-ii/discuss/597698/JavaC%2B%2B-HashMap-with-Picture-Clean-code-O(N)
//   Time complexity 0(n)
    public static TreeNode root;
    private static TreeNode ans = null;

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(1,2,3));
        input.add(Arrays.asList(4,5,6));
        input.add(Arrays.asList(7,8,9));

        int[] result = findDiagonalOrder(input);
         for(int res: result)
          System.out.println(res);
    }

    public static int[] findDiagonalOrder(List<List<Integer>> nums) {
        int n = 0, i = 0, maxKey = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int r = nums.size() - 1; r >= 0; --r) { // The values from the bottom rows are the starting values of the diagonals.
            for (int c = 0; c < nums.get(r).size(); ++c) {
                map.putIfAbsent(r + c, new ArrayList<>());
                map.get(r + c).add(nums.get(r).get(c));
                maxKey = Math.max(maxKey, r + c);
                n++;
            }
        }
        int[] ans = new int[n];
        for (int key = 0; key <= maxKey; ++key) {
            List<Integer> value = map.get(key);
            if (value == null) continue;
            for (int v : value) ans[i++] = v;
        }
        return ans;
    }

//    public static void addNode(int value) {
//        root = new TreeNode(value);
//        root.left = new TreeNode(2);
//        root.left.right = new TreeNode(5);
//        root.left.right.left = new TreeNode(4);
//        root.left.right.right = new TreeNode(6);
//        root.right = new TreeNode(3);
//    }

//    public static class Node {
//        TreeNode node;
//        int hd;
//
//        public Node(TreeNode node, int hd) {
//            this.node = node;
//            this.hd = hd;
//        }
//    }
//
//    public static class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//        TreeNode(int x) {
//            val = x;
//        }
//    }
}
