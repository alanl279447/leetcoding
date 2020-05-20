package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeAgerageEachLevel_FBDemo {
//    Input: [3,9,20,null,null,15,7]
//
//              4
//            /  \
//           7   9
//        /   \    \
//       10   2    7
//            \
//             6
//             /
//             2
//    Output:
//   [4,8,6,6,2]
//    If two nodes are in the same row and column, the order should be from left to right.

    public static TreeNode root;
    private static TreeNode ans = null;

    public static void main(String[] args) {
        addNode(4);
        List<Integer> result = binaryAverageLevel(root);
        for(Integer res: result)
          System.out.println(res.toString());
    }

    public static List<Integer> binaryAverageLevel(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            int average = 0;
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                average +=currNode.val;
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
            result.add(average/size);
        }
        return result;
    }

    public static void addNode(int value) {
        root = new TreeNode(value);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(6);
        root.left.right.right.left = new TreeNode(2);

        root.right = new TreeNode(9);
        root.right.left = new TreeNode(6);
    }

    public static class Node {
        TreeNode node;
        int hd; //horiozntal distance

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
