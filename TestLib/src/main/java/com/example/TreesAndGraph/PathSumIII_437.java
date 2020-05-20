package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathSumIII_437 {
//    root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//            10
//            /  \
//           5   -3
//         / \    \
//         3   2   11
//       / \   \
//     3  -2   1
//
//    Return 3. The paths that sum to 8 are:
//
//            1.  5 -> 3
//            2.  5 -> 2 -> 1
//            3. -3 -> 11

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        addNode(10);
        System.out.print(pathSum(root, 8));
    }

    static int count = 0;
    public static int pathSum(TreeNode node, int sum) {
       Map<Integer, Integer> map = new HashMap<>();
       map.put(0,1);
       helper(node, 0, map, sum);
       return count;
    }

    public static void helper(TreeNode node, int currSum, Map<Integer, Integer> map, int target) {
      if (node == null) return;
      currSum = currSum + node.val;

      if (map.containsKey(currSum-target)) {
            count += map.get(currSum-target);
        }

      map.put(currSum, map.getOrDefault(currSum, 0)+1);
      helper(node.left, currSum, map, target);
      helper(node.right, currSum, map, target);
      map.put(currSum, map.get(currSum)-1);
    }


//    public static int pathSum(TreeNode root, int sum) {
//        HashMap<Integer, Integer> preSum = new HashMap();
//        preSum.put(0,1);
//        helper(root, 0, sum, preSum);
//        return count;
//    }
//
//    public static void helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
//        if (root == null) {
//            return;
//        }
//
//        currSum += root.val;
//
//        if (preSum.containsKey(currSum - target)) {
//            count += preSum.get(currSum - target);
//        }
//
//        preSum.put(currSum, preSum.getOrDefault(currSum, 0)+1);
//
//        helper(root.left, currSum, target, preSum);
//        helper(root.right, currSum, target, preSum);
//        preSum.put(currSum, preSum.get(currSum) - 1);
//    }

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
