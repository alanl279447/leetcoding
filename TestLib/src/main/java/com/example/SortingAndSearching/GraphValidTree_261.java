package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class GraphValidTree_261 {

//    Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
//    Output: true
//    https://leetcode.com/problems/graph-valid-tree/

    public static void main(String[] args) {
        int[][] edges = {{0,1}, {0,2}, {0,3}, {1,4}};
        System.out.println(validTree(5, edges));
    }

//    For the graph to be a valid tree, it must have exactly n - 1 edges.
//    Any less, and it can't possibly be fully connected. Any more, and it has to contain cycles.
//    Additionally, if the graph is fully connected and contains exactly n - 1 edges,
//    it can't possibly contain a cycle, and therefore must be a tree!
    public static boolean validTreeBFS(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        // Make the adjacency list.
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        queue.offer(0);
        seen.add(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbour : adjacencyList.get(node)) {
                if (seen.contains(neighbour)) continue;
                seen.add(neighbour);
                queue.offer(neighbour);
            }
        }
        return seen.size() == n;
    }

    //https://leetcode.com/problems/graph-valid-tree/discuss/69018/AC-Java-Union-Find-solution
    public boolean validTreeUnionFind(int n, int[][] edges) {
        UnionFind set = new UnionFind(n);
        for(int[] edge: edges) {
            if(set.find(edge[0], edge[1])) return false;    // cycle check
            set.union(edge[0], edge[1]);
        }
        return set.size() == 1;                             // single tree check
    }

    class UnionFind {
        private int[] id, size;
        private int count;

        public UnionFind(int len) {
            id = new int[len];
            size = new int[len];
            for(int i = 0; i < len; i++) {
                id[i] = i;
                size[i] = 1;
            }
            count = len;
        }

        public int size() {
            return count;
        }

        private int root(int i) {
            while(i != id[i]) {
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }

        public boolean find(int p, int q) {
            return root(p) == root(q);
        }

        public void union(int p, int q) {
            int pi = root(p);
            int qi = root(q);
            if(size[pi] < size[qi]) {
                id[pi] = qi;
                size[qi] += size[pi];
            } else {
                id[qi] = pi;
                size[pi] += size[qi];
            }
            count--;
        }
    }

    public static boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i=0;i<n;i++) {
            adjacencyList.add(i, new ArrayList<>());
        }

        for (int i=0; i < edges.length; i++) {
            int[] edge = edges[i];
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        if (hasCycles(adjacencyList, 0, visited, -1)) {
            return false;
        }
        for (int i=0; i<n;i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasCycles(List<List<Integer>> adj, int u, boolean[] visited, int parent) {
        visited[u]=true;
        for (int i=0; i< adj.get(u).size(); i++) {
            int v = adj.get(u).get(i);
            if ((visited[v] && parent != v) || (!visited[v] && hasCycles(adj, v, visited,u))) {
                return true;
            }
        }
        return false;
    }

}
