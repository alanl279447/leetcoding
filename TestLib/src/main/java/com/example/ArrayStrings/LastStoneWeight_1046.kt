package com.example.ArrayStrings

import java.util.*

//Input: [2,7,4,1,8,1]
//Output: 1
//Explanation:
//We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
//we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
//we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
//we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
//https://leetcode.com/problems/last-stone-weight/
//time complexity 0(nlogn)

fun main (args: Array<String>) {
    val items: IntArray = intArrayOf(2,7,4,1,8,1)
    println(lastStoneWeight(items))
}

fun lastStoneWeight(stones: IntArray): Int {
    if (stones == null || stones.size == 0) return 0
    var pq = PriorityQueue<Int> { a, b -> b-a }

    for (i in 0 until stones.size) {
        pq.offer(stones[i])
    }

    while(pq.size >= 2) {
        var item1 = pq.poll()
        var item2 = pq.poll()
        if (item1 > item2)
          pq.offer(item1-item2)
    }
    return if (pq.isEmpty()) 0 else pq.peek()
}