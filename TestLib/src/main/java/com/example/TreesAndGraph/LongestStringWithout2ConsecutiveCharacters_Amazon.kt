package com.example.TreesAndGraph

import java.util.*
import kotlin.collections.HashMap

//Given A, B, C, find any string of maximum length that can be created such that no 3 consecutive
// characters are same. There can be at max A 'a', B 'b' and C 'c'.
//
//Example 2:
//Input: A = 1, B = 2, C = 3
//Output: "acbcbc"
//https://aonecode.com/amazon-online-assessment-questions

class LongestStringWithout2ConsecutiveCharacters_Amazon {
    var root: TreeNode? = null

    fun main(args: Array<String>) {
        addNode(5)
        var map = hashMapOf('A' to 1, 'B' to 2, 'C' to 3)
        var output = longestConsecutiveCharacters(map)
        System.out.println(output)
    }

   fun longestConsecutiveCharacters(map: HashMap<Char, Int>) : String {
       var pq = PriorityQueue<Pair<Char,Int>>( {a,b -> b.second - a.second})
       for (i in map.keys) {
           pq.offer(Pair(i, map.getOrDefault(i, 0)))
       }
       var sb: StringBuilder = StringBuilder()
       while (!pq.isEmpty()) {
           var pair = pq.poll()
           var sum  = 0
           if (pair.second > 2) {
               sum = 2
           }
           for (i in 0..sum) {
               sb.append(pair.first)
           }
           sum = pair.second-sum

       }
       return sb.toString()
   }



}