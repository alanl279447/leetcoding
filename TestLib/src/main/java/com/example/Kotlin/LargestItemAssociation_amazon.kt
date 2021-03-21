package com.example.Kotlin

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

//[Item1, Item2],
//[Item3, Item4],
//[Item4, Item5]
//
//[Item3, Item4, Item5]
//
//Explanation:
//There are two item association groups:
//group1: [Item1, Item2]
//group2: [Item3,Item4,Item5]
//In the available associations, group2 has the largest association. So, the output is [Item3, Item4, Item5].
//
//https://leetcode.com/discuss/interview-question/782606/

fun main (args: Array<String>) {
    val pairs = Arrays.asList( //
            PairString("item3", "item2"),  // -> item1, item3, item2
            PairString("item3", "item4"),  //
            PairString("item2", "item1")) //
    println(largestItemAssociation(pairs))
}

 fun largestItemAssociation(itemAssociation: List<PairString>?): List<String?>? {
    if (itemAssociation == null || itemAssociation.size == 0) {
        return ArrayList()
    }
    val map: MutableMap<String, MutableSet<String>> = HashMap()
    for (pair in itemAssociation) {
        val set = map.getOrDefault(pair.first, TreeSet())
        set.add(pair.first)
        set.add(pair.second)
        set.addAll(map.getOrDefault(pair.second, TreeSet()))
        map[pair.first] = set
        map[pair.second] = set
    }
    val checked: MutableSet<String> = HashSet()
    val pq: PriorityQueue<MutableList<String>> = PriorityQueue {
        l1, l2 -> if (l1.size !== l2.size) l2.size - l1.size else l1.get(0).compareTo(l2[0]) }

    for (item in map.keys) {
        if (checked.contains(item)) {
            continue
        }
        pq.add(ArrayList(map[item]))
        checked.addAll(map[item]!!)
    }
    return pq.remove()
}

class PairString(var first: String, var second: String)