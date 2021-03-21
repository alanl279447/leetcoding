package com.example.Kotlin

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

//    Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]
//
//            0          3
//            |          |
//            1 --- 2    4
//
//    Output: 2
//    https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/

fun main (args: Array<String>) {
    val items = arrayOf(intArrayOf(0,1), intArrayOf(1,2), intArrayOf(3,4))
    //println(countComponentsdfs(5,  items))
    println(countComponentsBfs(5,  items))
}

//BFS approach
fun countComponentsBfs(n: Int, edges: Array<IntArray>): Int {
    if (n <= 1) {
        return n;
    }
    var adList: MutableList<MutableList<Int>> = mutableListOf()
    for (i in 0 until n) {
        adList.add(mutableListOf())
    }
    for (i in 0 until edges.size) {
        adList.get(edges[i][0]).add(edges[i][1])
        adList.get(edges[i][1]).add(edges[i][0])
    }

    var count = 0
    var visited = BooleanArray(n){false}
    for (i in 0 until n) {
        if (!visited[i]) {
           count++
            var queue: Deque<Int> = ArrayDeque()
            queue.offer(i)
            while(!queue.isEmpty()) {
                var item = queue.poll()
                visited[item] = true
                var items = adList.get(item)
                for(item in items) {
                    if (!visited[item]) {
                        queue.offer(item)
                    }
                }
            }
        }
    }
    return count
}

//dfs approach
fun countComponentsdfs(n: Int, edges: Array<IntArray>): Int {
     var map:MutableMap<Int, MutableList<Int>> = HashMap()
     for (i in 0 until n) {
         map[i] = ArrayList()
     }

    for (i in 0 until edges.size) {
        map[edges[i][0]]?.add(edges[i][1])
        map[edges[i][1]]?.add(edges[i][0])
    }

    var count = 0
    var visited: MutableSet<Int> = HashSet()
    for (i in 0 until n) {
        if(visited.add(i)) {
            dfs(i, visited, map);
            count++
        }
    }
     return count
}

fun dfs(edge: Int, visited: MutableSet<Int>, map: MutableMap<Int, MutableList<Int>>) {
    var items = map.get(edge)
    for (item in items!!) {
        if(visited.add(item)) {
           dfs(item, visited, map)
        }
    }
}