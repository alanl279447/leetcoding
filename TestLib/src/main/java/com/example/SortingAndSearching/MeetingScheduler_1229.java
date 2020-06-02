package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingScheduler_1229 {

//    Input: [[0, 30],[5, 10],[15, 20]]
//    Output: 2
//
//    Input: [[7,10],[2,4]]
//    Output: 1

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        //int[][] nums1 = {{0,30}, {5, 10}, {15,20}};
        int[][] nums1 = {{13,15},{1,13}};
        System.out.print(minMeetingRooms(nums1));
    }

    public static int minMeetingRooms(int[][] intervals) {
         int length = intervals.length;
        if (intervals.length == 0) {
            return 0;
        }

         Arrays.sort(intervals, new Comparator<int[]>() {
             @Override
             public int compare(int[] o1, int[] o2) {
                 return o1[0] - o2[0];   //sort based on start time
             }
         });

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        queue.offer(intervals[0]);
        for (int i =1; i < length; i++) {
           if (intervals[i][0] >= queue.peek()[1]) {
               queue.poll();
               queue.offer(intervals[i]);
           } else {
               queue.offer(intervals[i]);
           }
        }
        return queue.size();
    }








//    public static int[][] kClosest(int[][] points, int K) {
//
//        int length = points.length;
//        int[] distances = new int[length];
//
//        int i=0;
//        for (int[] point: points) {
//            distances[i++] = dist(point);
//        }
//        Arrays.sort(distances);
//        int distK = distances[K-1];    //distance threshold is distK
//
//        int[][] ans = new int[K][2];
//        int t =0;
//        for (i = 0; i < length; i++) {
//            if (dist(points[i]) <= distK) {
//              ans[t++] = points[i];
//            }
//        }
//        return ans;
//    }
//
//    public static int dist(int[] point) {
//        if (point.length ==2) {
//            return point[0] * point[0] + point[1] * point[1];
//        }
//        return -1;
//    }









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
