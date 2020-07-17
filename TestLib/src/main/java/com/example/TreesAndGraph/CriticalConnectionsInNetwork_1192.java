package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class CriticalConnectionsInNetwork_1192 {
//    Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
//    Output: [[1,3]]
//    Explanation: [[3,1]] is also accepted.
//    https://leetcode.com/problems/critical-connections-in-a-network/

    public static Node root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
//        addNode(3);
        Integer[][] in = {{0,1}, {1,2}, {2,0}, {1,3}};
        List<List<Integer>> input = Arrays.stream(in).map(Arrays::asList).collect(Collectors.toList());
        List<List<Integer>> res = criticalConnections(4, input);
        for (List<Integer> re:res) {
            System.out.print(re);
        }
    }

    static int time = -1;
    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer>[] graph = new List[n];
        buildGraph(connections, graph);

        int[] disc = new int[n];
        int[] low = new int[n];
        int[] parents = new int[n];
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parents, -1);
        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) {
                dfs(i, parents, disc, low, graph, res);
            }
        }

        return res;
    }

//    low[u] records the lowest vertex u can reach
//    disc[u] records the time when u was discovered
    private static void dfs(int u, int[] parents, int[] disc, int[] low,
                     List<Integer>[] graph, List<List<Integer>> res) {
        if (disc[u] != -1) return;

        low[u] = disc[u] = ++time;

        for (int v : graph[u]) {
            if (disc[v] == -1) {
                parents[v] = u;
                dfs(v, parents, disc, low, graph, res);
                if (low[v] > disc[u]) {
                    res.add(Arrays.asList(u, v));
                }

                low[u] = Math.min(low[u], low[v]);
            } else if (parents[u] != v) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    private static void buildGraph(List<List<Integer>> connections, List<Integer>[] graph) {
        for (List<Integer> c : connections) {
            int from = c.get(0);
            int to = c.get(1);
            if (graph[from] == null) {
                graph[from] = new ArrayList<>();
            }

            if (graph[to] == null) {
                graph[to] = new ArrayList<>();
            }

            graph[from].add(to);
            graph[to].add(from);
        }
    }

    // Definition for a Node.
   public static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}

