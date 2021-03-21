package com.example.Kotlin

import java.util.*

//    Input: S = "aab"
//    Output: "aba"
//    https://leetcode.com/problems/reorganize-string/

fun main (args: Array<String>) {
    println(reorganizeString("aab"))
}

fun reorganizeString(S: String): String {
    var map: MutableMap<Char, Int> = mutableMapOf()

    var charArrays = S.toCharArray()
    for (item in charArrays) {
        map.put(item, map.getOrDefault(item, 0) +1)
    }
    var result: StringBuilder = StringBuilder()
    val pq: PriorityQueue<Char> = PriorityQueue<Char>
             {a,b-> map[b]!! - map[a]!!}
    pq.addAll(map.keys)
    while (pq.size>1) {
        var firstItem = pq.poll()
        var secondItem = pq.poll()
        result.append(firstItem).append(secondItem)
        map.put(firstItem, map.getValue(firstItem)-1)
        map.put(secondItem, map.getValue(firstItem)-1)

        if (map.get(firstItem)!! > 0) {
            pq.add(firstItem)
        }
        if (map.get(secondItem)!! > 0) {
            pq.add(secondItem)
        }
    }
    if (pq.size > 0) {
        var item = pq.poll()
        if (map.get(item)!! > 0) {
            return ""
        }
        result.append(item)
    }
    return result.toString()
}