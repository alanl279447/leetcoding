package com.example

import com.sun.javafx.scene.control.skin.VirtualFlow
import java.util.*
import kotlin.Comparator
import kotlin.collections.HashMap

var stack1: MutableList<Char> = mutableListOf()

fun main (args: Array<String>) {
    enqueue('a')
    enqueue('b')
    enqueue('c')
    System.out.println(dequeue())
    enqueue('d')
    System.out.println(dequeue())

    val list = mutableListOf(0,1,2,3)
    list.swap(0,2)
}

fun enqueue(input: Char) {
    stack1.add(input)
}

fun dequeue(): Char? {
    if (stack1 != null && stack1.size > 0) {
        return stack1.removeAt(0)
    }
    return null
}

fun MutableList<Int>.swap(index1: Int, index2:Int) {
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}


fun topKFrequentWords(prices:Array<String>, target: Int): MutableList<String?> {
    val map: MutableMap<String, Int> = HashMap()

    for (word in prices) {
        map[word] = map.getOrDefault(word, 0) + 1
    }
    val pq = PriorityQueue(Comparator
    { a: String, b: String -> if (map[a] === map[b]) a.compareTo(b) else map[a]!! - map[b]!! })


    val pq1 = PriorityQueue(Comparator {
        a:String, b:String -> if (map[a]==map[b]) a.compareTo(b) else map[a]!!-map[b]!!
    })

    for (word in prices) {
        pq.offer(word)
        if (pq.size > target) {
            pq.poll()
        }
    }

    val result: MutableList<String?> = ArrayList()
    for (item in pq) {
        result.add(item)
    }
    Collections.reverse(result)
    return result
}



fun coinChangeBottomUp(prices: Array<Int>, target: Int) : Int {
    var dp = IntArray(target+1) { i -> target +1}
    dp[0]=0
    for (i in 0..target) {
       for (j in 0..prices.size) {
           if (i > prices[j]) {
               dp[i]=Math.min(dp[i], dp[i-prices[j]]+1)
           }
       }
    }
     return dp[target+1]
}


fun longestPalindromSubString(input: String) : String? {
    if (input == null || input.length==0) {
        return null
    }

    var start = 0; var end = 0
    for (i in 0..input.length-1) {
      val len1 = expandAroundCenter(input, i, i)
      val len2 = expandAroundCenter(input, i, i+1)
      val len = Math.max(len1, len2)
      if (len > end - start) {
          start = i - (len-1)/2
          end = i + len/2
      }
    }
    return input.substring(start, end+1)
}

fun expandAroundCenter(input: String, start: Int, end: Int): Int {
    var L = start; var R = end;
    while (L>=0 && R < input.length && input[L]==input[R]) {
        L--
        R++
    }
    return R-L-1
}