package com.example.Kotlin

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

fun main (args: Array<String>) {
    val reviews = arrayOf("I love Google", "I love Apple",
            "I love Google more than Apple but Apple products are nice as well",
            "Apple products are great", "I love Microsoft")
    val competitors = arrayOf("Google", "Apple", "Netflix", "Microsoft")
    val topNCompetitors = 2
    val result = topKfrequent(reviews, competitors, topNCompetitors)
    for (res in result) {
        System.out.println(res)
    }
}

fun topKfrequent(reviews: Array<String>, competitors: Array<String>, topNCompetitors: Int) : MutableList<String> {
    var map: MutableMap<String, Int> = hashMapOf()
    var visitedSet: HashSet<String> = hashSetOf()

    for (review in reviews) {
        var result = review.split("\\s+".toRegex())
        for (word in result) {
            if (visitedSet.add(word) && competitors.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1)
            }
        }
        visitedSet.clear()
    }
    var pq:PriorityQueue<String> = PriorityQueue<String>{a,b->
        if (map.get(a) == map.get(b)) a.compareTo(b)
        else map.getOrDefault(a, 0)- map.getOrDefault(b,0)
    }
    for (entry in map.entries) {
        pq.add(entry.key)
        if (pq.size > topNCompetitors) {
            pq.poll()
        }
    }
    var result: MutableList<String> = ArrayList()
    while(!pq.isEmpty()) {
        result.add(pq.poll())
    }
    return result
}