package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class CutWoodFacebook {

//    Input: wood = [5, 9, 7], k = 3
//    Output: 5
//    Explanation:
//            5 -> 5
//            9 -> 5 + 4
//            7 -> 5 + 2
//    https://leetcode.com/discuss/interview-question/354854/Facebook-or-Phone-Screen-or-Cut-Wood

    public static TreeNode root;
    private static TreeNode ans = null;

    public static void main(String[] args) {
        addNode(3);
//        int[] input = {232, 124, 456};
        int[] input = {5, 9, 7};
        int result = cutWood(input, 4);
//        for(List<Integer> res: result)
          System.out.println(result);
    }

    public static int cutWood(int[] wood, int k){
        // corner cases:
        if(wood.length == 0 || k == 0) return 0;

        int left = 1, right = Integer.MIN_VALUE;
        int res = 0;
        if(!isValid(wood, left, k)) return 0;

        for (int i =0; i < wood.length;i++) {
           right = Math.max(right, wood[i]);
        }

        while(left < right){
            int mid = left + (right - left)/2;
            boolean valid = isValid(wood, mid, k);
            if(valid){
                left = mid + 1;
                res = mid;
            }
            else
                right = mid;
        }
        return res;
    }

    private static boolean isValid (int[] woods, int cutLength, int k) {

        int count = 0;
        for (int wood: woods) {
            count += wood/cutLength;
        }
        return count>=k;
    }


    public static void addNode(int value) {
        root = new TreeNode(value);
        root.left = new TreeNode(9);
//        root.right = new TreeNode(6);
//        root.left.right = new TreeNode(5);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
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
