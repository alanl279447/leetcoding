package com.example.Kotlin

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

//    Input:
//    routes = [[1, 2, 7], [3, 6, 7]]
//    S = 1
//    T = 6
//    Output: 2
//    Explanation:
//    The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
//    https://leetcode.com/problems/bus-routes/

fun main (args: Array<String>) {
    println(numBusesToDestination(arrayOf(intArrayOf(1,2,7), intArrayOf(3,6,7)), 1,6))
}

//map stop  - List<buses>
//      1 - 1 ,  2 - 1, 3 - 2, 6 -1, 7 - 1,2
//      queue - Starting 1




fun numBusesToDestination(routes: Array<IntArray>, S: Int, T: Int): Int {
    if (S==T) return 0

    var queue: Deque<Int> = ArrayDeque()
    var map:HashMap<Int, ArrayList<Int>> = HashMap()  //route, buses
    var visited: HashSet<Int> = HashSet()

    for (i in 0 until routes.size) {
        for (j in 0 until routes[i].size) {
            var list = map.getOrDefault(routes[i][j], ArrayList());
            list.add(i);
            map.put(routes[i][j], list)
        }
    }
    queue.offer(S)
    var busCount = 0
    while(!queue.isEmpty()) {
        var size = queue.size
        busCount++
        for (i in 0 until size) {
            var route = queue.poll()
            var buses = map.getOrDefault(route, ArrayList())
            for (i in 0 until buses.size) {
                if (visited.contains(buses[i])) continue
                visited.add(buses[i])
                for (j in 0 until routes[buses[i]].size) {
                    var route = routes[buses[i]][j]
                    if (route == T) return busCount
                    queue.offer(route)
                }
            }
        }
    }
    return -1
}