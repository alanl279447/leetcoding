package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class AllNodesDistanceKinBinaryTree_863 {
//    Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//    Output: [7,4,1]
//
//    Explanation:
//    The nodes that are a distance 2 from the target node (with value 5)
//    have values 7, 4, and 1.
//
//    Note that the inputs "root" and "target" are actually TreeNodes.
//    The descriptions of the inputs above are just serializations of these objects.
//    https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
//   time complexity 0(N).

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        addNode(3);
        List<Integer> result = distanceK(root, root.left, 2);
        for (int res: result) {
            System.out.print(res);
        }
    }

    //DFS to get all parent mapping
    // and then BFS queue starting from the target until the distance is K
    static Map<TreeNode, TreeNode> parentMapping = null;
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        List<Integer> result = new ArrayList<>();
        if (root == null || target == null) return result;

        parentMapping = new HashMap<>();
        dfs(root, null);

        //BFS
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> seen = new HashSet<>();
        int distance = 0;
        queue.offer(target);
        seen.add(target);

        while(!queue.isEmpty()) {
            int size = queue.size();
            if (distance == K) {
                for (int i = 0; i < size; i++) {
                    result.add(queue.poll().val);
                }
                return result;
            } else {
                for (int i = 0; i < size; i++) {
                  TreeNode currentNode = queue.poll();
                  if (currentNode.left != null && !seen.contains(currentNode.left)) {
                      queue.offer(currentNode.left);
                      seen.add(currentNode.left);
                  }
                    if (currentNode.right != null && !seen.contains(currentNode.right)) {
                        queue.offer(currentNode.right);
                        seen.add(currentNode.right);
                    }
                    TreeNode parentNode = parentMapping.get(currentNode);
                    if (parentNode != null && !seen.contains(parentNode)) {
                        queue.offer(parentNode);
                        seen.add(parentNode);
                    }
                }
                distance++;
            }
        }
        return result;
    }

    public static void dfs(TreeNode node, TreeNode parent) {
        parentMapping.put(node, parent);
        if (node != null) {
            dfs(node.left, node);
            dfs(node.right,node);
        }
    }


    public static void addNode(int value) {
        if (root == null)
         root = new TreeNode(value);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);

        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right = new TreeNode(1);
        root.right.right = new TreeNode(8);
        root.right.left = new TreeNode(0);
    }

    // Definition for a Node.
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}

