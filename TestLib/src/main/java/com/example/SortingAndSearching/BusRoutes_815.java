package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class BusRoutes_815 {
//    Input:
//    routes = [[1, 2, 7], [3, 6, 7]]
//    S = 1
//    T = 6
//    Output: 2
//    Explanation:
//    The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
//    https://leetcode.com/problems/bus-routes/

    public static void main(String[] args) {
        int[][] routes = {{1,2,7}, {3,6,7}};
        System.out.print(numBusesToDestination(routes, 1, 6));
    }

    public static int numBusesToDestination(int[][] routes, int S, int T) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int ret = 0;

        if (S==T) return 0;

        for(int i = 0; i < routes.length; i++){
            for(int j = 0; j < routes[i].length; j++){
                ArrayList<Integer> buses = map.getOrDefault(routes[i][j], new ArrayList<>());
                buses.add(i);
                map.put(routes[i][j], buses);
            }
        }
        q.offer(S);
        while (!q.isEmpty()) {
            int len = q.size();
            ret++;
            for (int i = 0; i < len; i++) {
                int cur = q.poll();
                ArrayList<Integer> buses = map.get(cur);
                for (int bus: buses) {
                    if (visited.contains(bus)) continue;
                    visited.add(bus);
                    for (int j = 0; j < routes[bus].length; j++) {
                        if (routes[bus][j] == T) return ret;
                        q.offer(routes[bus][j]);
                    }
                }
            }
        }
        return -1;
    }
}