package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NumberofIslandsII_305 {
//    Input: m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]
//    Output: [1,1,2,3]
//    https://leetcode.com/problems/number-of-islands-ii/
//    https://leetcode.com/problems/number-of-islands-ii/discuss/75470/Easiest-Java-Solution-with-Explanations

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
//        addNode();
        int[][] input = {{0,0}, {0,1}, {1,2}, {2,1}};
        //int[][] input = {{0,0}, {0,1}, {1,0}, {1,1}};
        List<Integer> result = numIslands2(3,3, input);
        for (Integer res: result)
            System.out.println(result);
    }

    //setup roots equal to the number of points
    //Initially assume every cell are in non-island set {-1}. When point A is added, we create a new root, i.e., a new island.
    // Then, check if any of its 4 neighbors belong to the same island.
    // If not, union the neighbor by setting the root to be the same. Remember to skip non-island cells.
    public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if (positions == null || positions.length == 0) {
            return result;
        }
        int[] root = new int[m * n];
        Arrays.fill(root, -1);
        int count = 0;
        int[] xDelta = {1, -1, 0, 0};
        int[] yDelta = {0, 0, 1, -1};
        for (int[] position : positions) {

            int x = position[0];
            int y = position[1];
            int index = x * n + y;
            if (root[index] != -1) {    // duplicate position
                result.add(count);
                continue;
            }
            count++;
            root[index] = index;
            for (int i = 0; i < 4; i++) {
                int r = x + xDelta[i];
                int c = y + yDelta[i];
                if (isValid(m, n, r, c, root)) {
                    int neighborIndex = r * n + c;
                    int neighborRoot = findRoot(root, neighborIndex);
                    if (neighborRoot != index) {
                        root[neighborRoot] = index;
                        count--;
                    }
                }
            }
            result.add(count);
        }
        return result;
    }

    private static boolean isValid(int m, int n, int r, int c, int[] root) {
        if (r < 0 || c < 0 || r >= m || c >= n || root[r * n + c] == -1) {
            return false;
        }
        return true;
    }

    private static int findRoot(int[] root, int index) {
        while (index != root[index]) {
            root[index] = root[root[index]];  //path compression
            index = root[index];
        }
        return index;
    }

    public static void addNode() {
        root = addNodeRecursive(root, 10);
        root.left = new TreeNode(15);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(17);
        root.right.left = new TreeNode(14);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode addNodeRecursive(TreeNode node, int value) {
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
