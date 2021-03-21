package com.example.SortingAndSearching;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import javafx.scene.layout.Priority;

public class CampusBikes_1057 {
//    Input: workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
//    Output: [0,2,1]
//    Explanation:
//    Worker 0 grabs Bike 0 at first. Worker 1 and Worker 2 share the same distance to Bike 2,
//    thus Worker 1 is assigned to Bike 2, and Worker 2 will take Bike 1. So the output is [0,2,1].
//    https://leetcode.com/problems/campus-bikes/
//    time complexity  Log(MN) * O(MN)

    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[][] workers = {{0,0}, {1,1}, {2,0}};
        int[][] bikes = {{1,0}, {2,2}, {2,1}};
        int[] result = assignBikes(workers, bikes);
        for (int res: result) {
            System.out.println(res);
        }
    }

    public static int[] assignBikesTest(int[][] workers, int[][] bikes) {

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> {
            int comp = Integer.compare(a[0], b[0]);
            if (comp ==0) {
               if (Integer.compare(a[1], b[1]) ==0) {
                   return Integer.compare(a[2], b[2]);
               } else {
                   return Integer.compare(a[1], b[1]);
               }
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });

        for (int i=0; i < workers.length; i++) {
            int[] worker = workers[i];
            for (int j = 0; j < bikes.length; j++) {
               int[] bike = bikes[j];
               int dist = Math.abs(bike[0]-worker[0])+ Math.abs(bike[1]-worker[1]);
               pq.add(new int[] {dist, i, j});
            }
        }

        int[] res = new int[workers.length];
        Arrays.fill(res, -1);
        Set<Integer>visitedBikes = new HashSet<>();
        while(visitedBikes.size() < workers.length) {
            int[] workerBikePair = pq.poll();
            if (res[workerBikePair[1]] == -1 && !visitedBikes.contains(workerBikePair[2])) {
                res[workerBikePair[1]] = workerBikePair[2];
                visitedBikes.add(workerBikePair[2]);
            }
        }
        return res;
    }

    public static int[] assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length;

        // order by Distance ASC, WorkerIndex ASC, BikeIndex ASC
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> {
            int comp = Integer.compare(a[0], b[0]);
            if (comp == 0) {
                if (a[1] == b[1]) {
                    return Integer.compare(a[2], b[2]);
                }
                return Integer.compare(a[1], b[1]);
            }
            return comp;
        });

        // loop through every possible pairs of bikes and people,
        // calculate their distance, and then throw it to the pq.
        for (int i = 0; i < workers.length; i++) {
            int[] worker = workers[i];
            for (int j = 0; j < bikes.length; j++) {
                int[] bike = bikes[j];
                int dist = Math.abs(bike[0] - worker[0]) + Math.abs(bike[1] - worker[1]);
                q.add(new int[]{dist, i, j});
            }
        }

        // init the result array with state of 'unvisited'.
        int[] res = new int[n];
        Arrays.fill(res, -1);

        // assign the bikes.
        Set<Integer> bikeAssigned = new HashSet<>();
        while (bikeAssigned.size() < n) {
            int[] workerAndBikePair = q.poll();
            if (res[workerAndBikePair[1]] == -1
                    && !bikeAssigned.contains(workerAndBikePair[2])) {

                res[workerAndBikePair[1]] = workerAndBikePair[2];
                bikeAssigned.add(workerAndBikePair[2]);
            }
        }
        return res;
    }
}
