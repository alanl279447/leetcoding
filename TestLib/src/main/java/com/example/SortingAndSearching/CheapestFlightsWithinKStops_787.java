package com.example.SortingAndSearching;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import javafx.scene.layout.Priority;

//        Input:
//        n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
//        src = 0, dst = 2, k = 0
//        Output: 500
//         https://leetcode.com/problems/cheapest-flights-within-k-stops/
//         O(V 2 log V)   v - number of cities
public class CheapestFlightsWithinKStops_787 {
    public static void main(String[] args) {
        int[][] flights = {{0,1,100}, {1,2,100}, {0,2,500}};
        System.out.print(findCheapestPrice(3, flights, 0, 2, 0));
    }

    //adjacency list for the nodes, ie city1, <city2, price>
    //min heap sorted based on the cost, add the src node first
    //loop through all the adj nodes, until you find the dest.
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
        for (int[] f : flights) {
            if (!prices.containsKey(f[0])) prices.put(f[0], new HashMap<>());
            prices.get(f[0]).put(f[1], f[2]);
        }
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
        pq.add(new int[] {0, src, k + 1});
        while (!pq.isEmpty()) {
            int[] top = pq.remove();
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            if (city == dst) return price;
            if (stops > 0) {
                Map<Integer, Integer> adj = prices.getOrDefault(city, new HashMap<>());
                for (int a : adj.keySet()) {
                    pq.add(new int[] {price + adj.get(a), a, stops - 1});
                }
            }
        }
        return -1;
    }
}