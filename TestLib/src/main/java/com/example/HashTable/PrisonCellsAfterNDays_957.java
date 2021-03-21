package com.example.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrisonCellsAfterNDays_957 {
//    Input: cells = [0,1,0,1,1,0,0,1], N = 7
//    Output: [0,0,1,1,0,0,0,0]
//    Explanation:
//    The following table summarizes the state of the prison on each day:
//    Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
//    Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
//    Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
//    Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
//    Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
//    Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
//    Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
//    Day 7: [0, 0, 1, 1, 0, 0, 0, 0]

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
//        addNode(-10);
//        int[] input = {0, 1, 0, 1, 1, 0, 0, 1};
        int[] input = {1,0,0,1,0,0,1,0};
        int[] result = prisonAfterNDays(input, 7000);
        for (int value : result) {
            System.out.print(value);
        }
    }

    public static int[] prisonAfterNDays(int[] cells, int N) {
        int[] firstSimulation = new int[8];
        for (int i = 1; i < 7; i++)
            firstSimulation[i] = (cells[i - 1] == cells[i + 1] ? 1 : 0);

        cells = firstSimulation.clone();
        N -= 1;
        int cycle = 1;
        int[] nextSimulation = new int[8];
        while (N-- > 0) {
            for (int i = 1; i < 7; i++) {
                nextSimulation[i] = (cells[i - 1] == cells[i + 1] ? 1 : 0);
            }
            if (Arrays.equals(firstSimulation, nextSimulation)) {
                N %= cycle;
            }
            cells = nextSimulation.clone();
            cycle++;
        }
        return cells;
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
