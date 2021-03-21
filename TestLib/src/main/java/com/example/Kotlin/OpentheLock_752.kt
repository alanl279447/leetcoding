package com.example.Kotlin

import java.util.*
import kotlin.collections.HashSet

//        Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//        Output: 6
//        Explanation:
//        A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
//        Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
//        because the wheels of the lock become stuck after the display becomes the dead end "0102".
//        https://leetcode.com/problems/open-the-lock/

fun main (args: Array<String>) {
    println(numDecodings("226"))
}

fun openLock(deadends: Array<String>, target: String) : Int{
    var queue: Queue<String> = LinkedList()
    var seen: HashSet<String> = HashSet()
    queue.offer("0000")
    queue.offer(null)
    seen.add("0000")

    var deadEndSet: HashSet<String> = HashSet()
    for (item in deadends) {
        deadEndSet.add(item)
    }

    var depth = -1
    while(!queue.isEmpty()) {
      var node = queue.poll()
      if (node == null) {
          depth++
          if(queue.peek() != null) {
              queue.offer(null)
          }
      } else if (node.equals(target)) {
          return depth;
      } else if (!deadends.contains(node)) {
         for (i in 0 until 4) {
           for (j in -1..1 step 2) {
               var y: Int = ((node[i] - '0') + j + 10)%10
               var nextString = node.substring(0, i)+y+node.substring(i+1)
               if (!seen.contains(nextString)) {
                   seen.add(nextString)
                   queue.add(nextString)
               }
           }
         }
      }
    }
    return depth
}