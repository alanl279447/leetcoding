package com.example.TreesAndGraph;

import java.util.*

class MinCostToConnectAllNode_Amazon {
//    Input: n = 6, edges = [[1, 4], [4, 5], [2, 3]], newEdges = [[1, 2, 5], [1, 3, 10], [1, 6, 2], [5, 6, 5]]
//    Output: 7
//    Explanation:
//    There are 3 connected components [1, 4, 5], [2, 3] and [6].
//    We can connect these components into a single component by connecting node 1 to node 2 and
//    node 1 to node 6 at a minimum cost of 5 + 2 = 7.
//    https://leetcode.com/discuss/interview-question/356981

    fun main(args: Array<String>) {
      println(minCostToConnectAllNodes(6, arrayOf(intArrayOf(1,4), intArrayOf(4,5), intArrayOf(2,3)),
            arrayOf(intArrayOf(1,2,5), intArrayOf(1,3,10), intArrayOf(1,6,2), intArrayOf(5,6,5))))
    }

    fun minCostToConnectAllNodes(nodeCount: Int, edges: Array<IntArray>, newEdges: Array<IntArray>) : Int {
        var cost = 0
        var totalEdges = 0
        var disjointSet: DisjointSet = DisjointSet(nodeCount)
        for (edge in edges) {
            if(disjointSet.isSameSet(edge[0], edge[1])) continue
            disjointSet.union(edge[0], edge[1])
            totalEdges++
        }
        if (totalEdges == nodeCount-1) return cost
        Arrays.sort(newEdges, {a,b -> a[2] -b [2]}) //ascending order

        for (newEdge in newEdges) {
            if (disjointSet.isSameSet(newEdge[0], newEdge[1])) continue
            disjointSet.union(newEdge[0], newEdge[1])
            cost += newEdge[2]
            if (++totalEdges == nodeCount-1) return cost
        }
        return -1
    }


    class DisjointSet {
        var parents:IntArray
        var weights: IntArray

        constructor(count: Int) {
            parents = IntArray(count+1) {index->index}
            weights = IntArray(count+1) {1}
        }

        fun union(node1: Int, node2: Int) {
            var root1 = find(node1)
            var root2 = find(node2)

            if (root1 == root2) return
            if (weights[root1] > weights[root2]) {
                parent[root2] = root1
                weights[root1] += weights[root2]
            } else {
                parent[root1] = root2
                weights[root2] +=weights[root1]
            }
        }

        fun find(node: Int):Int {
            var node = node
            while (parent[node] != node) {
                parent[node] = parent[parent[node]];
                node = parent[node]
            }
            return node
        }

        fun isSameSet(node1: Int, node2:Int):Boolean {
            return find(node1) == find(node2)
        }
    }

}