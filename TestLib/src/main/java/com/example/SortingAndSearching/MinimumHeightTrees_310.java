package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class MinimumHeightTrees_310 {

//    [0,1,3,5,6,8,12,17]
//
//    There are a total of 8 stones.
//    The first stone at the 0th unit, second stone at the 1st unit,
//    third stone at the 3rd unit, and so on...
//    The last stone at the 17th unit.
//
//    Return true. The frog can jump to the last stone by jumping
//1 unit to the 2nd stone, then 2 units to the 3rd stone, then
//2 units to the 4th stone, then 3 units to the 6th stone,
//4 units to the 7th stone, and 5 units to the 8th stone.
//    https://leetcode.com/problems/frog-jump/

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[] nums1 = {0,1,3,5,6,8,12,17};
        System.out.print(canCross(nums1));
    }

    public static boolean canCross(int[] stones) {
        for (int i=3; i < stones.length; i++) {
           if (stones[i]>stones[i-1]*2) {
               return false;
           }
        }
        HashSet<Integer>set = new HashSet<>();
        for (int stone:stones) {
            set.add(stone);
        }

        int lastStone = stones[stones.length-1];
        Stack<Integer> positions = new Stack<>();
        Stack<Integer> jumps = new Stack<>();
        positions.add(0);
        jumps.add(0);

        while(!positions.isEmpty()) {
            int position = positions.pop();
            int jump = jumps.pop();

            for (int i = jump-1; i <= jump+1;i++) {
                if (i <=0) {
                    continue;
                }
                int newPosition = position+i;
                if (newPosition == lastStone) {
                    return true;
                } else if (set.contains(newPosition)) {
                    positions.push(newPosition);
                    jumps.add(i);
                }
            }
        }
        return false;
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
