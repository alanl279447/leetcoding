package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingScheduler_1229 {

//    Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
//    Output: [60,68]
//    https://leetcode.com/problems/meeting-scheduler/

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[][] slots1 = {{10,50},{60,120}, {140,210}};
        int[][] slots2 = {{0,15},{60,70}};
        List<Integer> result = minAvailableDuration(slots1, slots2, 8);
        for (int res:result)
           System.out.print(res);
    }

    public static List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a,b)->a[0]-b[0]);  //sort based on starting time  0(nlogn)
        Arrays.sort(slots2, (a,b)->a[0]-b[0]);  //sort based on starting time  0(nlogn)

        int len1 = 0, len2= 0;
        while (len1 < slots1.length && len2< slots2.length) {
            int[] intersection = new int[2];

            intersection[0] = Math.max(slots1[len1][0], slots2[len2][0]);//10, 60, 60
            intersection[1] = Math.min(slots1[len1][1], slots2[len2][1]);//15, 50, 70

            if (intersection[1] - intersection[0] >= duration) { //6
                intersection[1]=intersection[0]+duration;
                return Arrays.asList(intersection[0], intersection[1]);
            } else {
                if (slots1[len1][1] < slots2[len2][1]) {
                    len1++;  //len1=1
                } else {
                    len2++;   //len2=1
                }
            }
        }
        return new ArrayList<>();
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
