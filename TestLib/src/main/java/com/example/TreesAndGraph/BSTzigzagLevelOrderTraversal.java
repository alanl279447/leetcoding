package com.example.TreesAndGraph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSTzigzagLevelOrderTraversal {
//                3
//               / \
//              9  20
//                /  \
//               15   7
//                        [
//                        [3],
//                        [20, 9],
//                        [15,7]
//                        ]
    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        addNode(3);
        List<List<Integer>> output = zigzagLevelOrder(root);
        for (List<Integer> item: output) {
          for (Integer it: item) {
              System.out.print(it+"  ");
          }
            System.out.println();
        }
    }

    public static List<List<Integer>> zigzagLevelOrderIterative(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i=0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (result.size() %2 ==0) {
                    temp.add( curr.val);
                } else {
                    temp.add(0, curr.val);
                }
                if (curr.left!= null) {
                    queue.offer(curr.left);
                }
                if (curr.right!= null) {
                    queue.offer(curr.right);
                }
            }
            result.add(temp);
        }
          return result;
    }


    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        DFS(root, 0, results);
        return results;
    }

    public static void DFS(TreeNode node, int level, List<List<Integer>> results) {
        if (node == null) return;

        if (results.size()==level) {
            results.add(new ArrayList<>());
        }
        if (level %2==0) {
            results.get(level).add(node.val);
        } else {
            results.get(level).add(0, node.val);
        }
        if (node.left != null) DFS(node.left, level + 1, results);
        if (node.right != null) DFS(node.right, level + 1, results);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void addNode(int value) {
        root = addNodeRecursive(root, value);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
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
