package com.example.TreesAndGraph;

public class BinaryTreeLongestConsecutiveSequence_ii_549 {
//    Input:
//             1
//            / \
//           2   3
//    Output: 2
//    Explanation: The longest consecutive path is [1, 2] or [2, 1].
//    https://leetcode.com/problems/binary-tree-longest-consecutive-sequence-ii/

    public static TreeNode root = null;
    public static void main(String[] args) {
        addNode(2);
        int result = longestConsecutive(root);
//        for (int res: result) {
            System.out.print(result);
//        }
    }

    static int max = 0;
    public static int longestConsecutive(TreeNode root) {
        helper(root);
        return max;
    }

    public static int[] helper(TreeNode root){
        if(root == null) return new int[]{0,0};
        int[] left = helper(root.left);
        int[] right= helper(root.right);
        int inc = 1, des = 1;
        if(root.left != null){
            if(root.val - root.left.val == 1){
                des = left[1]+1;
            }else if(root.val - root.left.val == -1){
                inc = left[0]+1;
            }
        }
        if(root.right != null){
            if(root.val - root.right.val == 1){
                des = Math.max(des,right[1]+1);
            }else if(root.val - root.right.val == -1){
                inc = Math.max(inc,right[0]+1);
            }
        }
        max = Math.max(max,inc+des-1);
        return new int[]{inc,des};
    }

    public static void addNode(int value) {
        if (root == null)
         root = new TreeNode(value);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
    }

    // Definition for a Node.
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}

