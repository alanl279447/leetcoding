package com.example.TreesAndGraph

import java.util.*

//Input: N = 3, connections = [[1,2,5],[1,3,9],[2,3,1]]
//Output: 6
//
//Choosing any 2 edges will connect all cities so we choose the minimum 2.
//https://leetcode.com/problems/connecting-cities-with-minimum-cost/
// time complexity 0(nlogn)
//https://leetcode.com/problems/connecting-cities-with-minimum-cost/discuss/344867/Java-Kruskal's-Minimum-Spanning-Tree-Algorithm-with-Union-Find

fun main (args: Array<String>) {
    var connections = arrayOf(intArrayOf(1,2,5), intArrayOf(1,3,2), intArrayOf(2,3,1))
    println(minimumCost(3, connections))
}

//sort based on cost
// find for all the nodes
// unions reduce the parent
// if parent == 1 return the sum

//union find algorithm
lateinit var parent: IntArray
lateinit var weights:IntArray
var n = 0
fun minimumCost(N: Int, connections: Array<IntArray>): Int {
    parent = IntArray(N + 1) {index -> index}
    weights = IntArray(N+1) {1}    //weighted union find
    n = N
    Arrays.sort(connections, { a, b -> a[2] - b[2] }) //ascending order of cost
    var res = 0
    for (c in connections) {
        val x = c[0]
        val y = c[1]
        if (find(x) != find(y)) {
            res += c[2]
            union(x, y)
        }
    }
    return if (n == 1) res else -1
}
//https://leetcode.com/problems/connecting-cities-with-minimum-cost/solution/
fun union(x: Int, y: Int) {
    val px = find(x)
    val py = find(y)
    if (px != py) {
        if (weights[px] > weights[py]) {
            parent[py] = px
            weights[px] += weights[py]
        } else {
            parent[px] = py
            weights[py] += weights[px]  //weighted union
        }
        n--
    }
}

fun find(x: Int): Int {
    var x = x
    while (parent[x] != x) {
        parent[x] = parent[parent[x]]; //path compression
        x = parent[x];
    }
    return x
}


//priority queue
//https://leetcode.com/problems/connecting-cities-with-minimum-cost/discuss/357446/Simple-Java-solution-for-slow-learners-like-myself
fun minimumCostPq(N: Int, connections: Array<IntArray>): Int {
    var graph: ArrayList<ArrayList<IntArray>> = ArrayList()
    for (i in 0..N) graph.add(ArrayList()) // start from 0
    for (c in connections) {
        graph[c[0]].add(intArrayOf(c[1], c[2]))
        graph[c[1]].add(intArrayOf(c[0], c[2]))
    }
    val pq: Queue<IntArray> = PriorityQueue { a, b -> a[1] - b[1] } // minHeap compare with cost
    val visited = BooleanArray(N + 1)
    pq.offer(intArrayOf(1, 0)) // suppose there is a start 0 node with 0-1 cost is 0.
    var numberOfCitiesVisited = 0
    var cost = 0
    while (!pq.isEmpty()) {
        val cur = pq.poll()
        if (visited[cur[0]]) continue
        cost += cur[1]
        visited[cur[0]] = true
        numberOfCitiesVisited++ // not all node may be visited.
        val neis: List<IntArray> = graph[cur[0]]
        for (nei in neis) {
            if (visited[nei[0]]) continue  // if already visted, it means there is a path with smaller cost that can get to it, so we do not need to access it again.
            pq.offer(nei)
        }
    }
    return if (numberOfCitiesVisited == N) cost else -1
}