package com.example.DesignQuestions

import java.util.*
import kotlin.collections.HashMap

//    LRUCache cache = new LRUCache( 2 /* capacity */ );
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // returns 1
//cache.put(3, 3);    // evicts key 2
//cache.get(2);       // returns -1 (not found)
//cache.put(4, 4);    // evicts key 1
//cache.get(1);       // returns -1 (not found)
//cache.get(3);       // returns 3
//cache.get(4);       // returns 4
//https://leetcode.com/problems/lru-cache/

fun main(args: Array<String>) {

    val capacity = 4
    val obj = LRUCache(capacity)
    obj.put(1, 1)
//    val param_1 = obj[1]
//    System.out.println(param_1)
}

class LRUCache {
    var cache: Map<Int, DLinkedList>
    var head:DLinkedList
    var tail:DLinkedList
    var cap: Int = 0

    constructor(capacity: Int) {
        cache = HashMap()
        head = DLinkedList()
        tail = DLinkedList()
        head?.right = tail
        tail?.left = head
        cap = capacity
    }

    fun put(key:Int, value:Int) {
       if (cache.containsKey(key)) {
           //cache.
       } else {

       }


    }


    class DLinkedList {
        var key:Int = 0
        var value: Int = 0
        var left: DLinkedList? = null
        var right: DLinkedList? = null

    }
}


