package com.example.TreesAndGraph;

import java.util.*
import kotlin.collections.HashSet


//class MinCostToRepairEdge_Amazon {

//    Example 1:
//    Input:
//    n = 5, edges = [[1, 2], [2, 3], [3, 4], [4, 5], [1, 5]], edgesToRepair = [[1, 2, 12], [3, 4, 30], [1, 5, 8]]
//    Output: 20
//    Explanation:
//    There are 3 connected components due to broken edges: [1], [2, 3] and [4, 5].
//    We can connect these components into a single component by repearing the edges between nodes 1 and 2, and nodes 1 and 5 at a minimum cost 12 + 8 = 20.
//    https://leetcode.com/discuss/interview-question/357310

    fun main(args: Array<String>) {
      println(minCostToRepairEdgesNodes(5,
            arrayOf(intArrayOf(1,2), intArrayOf(2,3), intArrayOf(3,4), intArrayOf(4,5), intArrayOf(1,5)),
            arrayOf(intArrayOf(1,2,12), intArrayOf(3,4,30), intArrayOf(1,5,8))))
    }

    fun minCostToRepairEdgesNodes(nodeCount: Int, edges: Array<IntArray>, edgesToRepair: Array<IntArray>) : Int {
        var cost = 0
        var totalEdges = 0
        var disjointSet = DisjointSet(nodeCount)
        val hset: MutableSet<String> = HashSet()

        val pq: PriorityQueue<IntArray> = PriorityQueue { a, b -> a.get(2) - b[2] }
        for (e in edgesToRepair) {
            pq.add(e)
            hset.add(e[0].toString() + " " + e[1])
        }

        for (e in edges) {
            val s = e[0].toString() + " " + e[1]
            if (hset.contains(s)) continue
            val ne = intArrayOf(e[0], e[1], 0)
            pq.add(ne)
        }

        while (!pq.isEmpty()) {
            var connection = pq.poll()
            if (disjointSet.isSameSet(connection[0], connection[1])) continue

            disjointSet.union(connection[0], connection[1])
            cost += connection[2]
            totalEdges++
            if (totalEdges == nodeCount-1) return cost
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
                parents[root2] = root1
                weights[root1] += weights[root2]
            } else {
                parents[root1] = root2
                weights[root2] +=weights[root1]
            }
        }

        fun find(node: Int):Int {
            var node = node
            while (parents[node] != node) {
                parents[node] = parents[parents[node]];
                node = parents[node]
            }
            return node
        }

        fun isSameSet(node1: Int, node2:Int):Boolean {
            return find(node1) == find(node2)
        }
    }

//}