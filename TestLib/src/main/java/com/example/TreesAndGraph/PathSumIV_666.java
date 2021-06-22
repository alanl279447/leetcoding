package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathSumIV_666 {
//    Input: [113, 215, 221]
//    Output: 12
//    Explanation:
//    The tree that the list represents is:
//             3
//            / \
//           5   1
//
//    The path sum is (3 + 5) + (3 + 1) = 12.
//    https://leetcode.com/problems/path-sum-iv/
//    https://leetcode.com/problems/path-sum-iv/discuss/106892/Java-solution-Represent-tree-using-HashMap
//    Formula: For node xy (x-depth, y-pos) its left child is (x+1)*10 + (y*2-1)? and right child is (x+1)(y*2)?
      //time complexity is 0(n)
      //(depth+1)*10+ pos*2


    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        addNode(10);
        int[] nodes = {113,215,221};
        System.out.print(pathSum(nodes));
    }
    static int sum = 0;
    static Map<Integer, Integer> tree = new HashMap<>();

     public static int pathSum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        for (int num : nums) {
            int key = num / 10;  //DP
            int value = num % 10; //V
            tree.put(key, value);
        }
        traverse(nums[0] / 10, 0);   //key is depthPos - val
        return sum;
    }

    private static void traverse(int root, int preSum) {
        int depth = root / 10;  //quotient
        int pos = root % 10;    //remainder
        int left = (depth + 1) * 10 + pos * 2 - 1;
        int right = (depth + 1) * 10 + pos * 2;
        int curSum = preSum + tree.get(root);
        if (!tree.containsKey(left) && !tree.containsKey(right)) {
            sum += curSum;
            return;
        }
        if (tree.containsKey(left)) traverse(left, curSum);
        if (tree.containsKey(right)) traverse(right, curSum);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void addNode(int value) {
        root = addNodeRecursive(root, value);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);

        root.right = new TreeNode(-3);
        root.right.left = new TreeNode(11);
    }

    public static TreeNode addNodeRecursive(TreeNode node, int value) {
//        TreeNode newNode = null;
        if (node == null) {
            node = new TreeNode(value);
            return node;
        }
        if (value < node.val) {
            node.left = addNodeRecursive(node.left, value);
        } else if (value > node.val){
            node.right = addNodeRecursive(node.right, value);
        } else {
            return node;
        }
        return node;
    }
}