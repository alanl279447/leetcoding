package com.example.TreesAndGraph

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

//Input: N = 3, relations = [[1,3],[2,3]]
//Output: 2
//Explanation:
//In the first semester, courses 1 and 2 are studied. In the second semester, course 3 is studied.
//https://leetcode.com/problems/parallel-courses/

fun main (args: Array<String>) {
    println(minimumSemesters(3, arrayOf(intArrayOf(1,3), intArrayOf(2,3))))
}

fun minimumSemesters(N: Int, relations: Array<IntArray>): Int {
    var inDegree = IntArray(N){0}
    var map: HashMap<Int, ArrayList<Int>> = HashMap()
    var N = N
    for (rel in relations) {
        map.putIfAbsent(rel[0], ArrayList())
        map.get(rel[0])?.add(rel[1])
    }

    var queue:Queue<Int> = LinkedList()
    for (i in 0..N) {
        if (inDegree[i] == 0) {
          queue.offer(i)
        }
    }
    var semister = 0
    while(!queue.isEmpty()) {
        var size  = queue.size
        for (i in 0..size) {
            --N
            var node = queue.poll()
            if (!map.containsKey(node)) continue
            for (neigh in map.remove(node)!!) {
               if (--inDegree[neigh] == 0) {
                   queue.offer(neigh)
               }
            }
        }
        semister++
    }
    return if(N ==0) semister else -1
}