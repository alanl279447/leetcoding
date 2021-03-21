package com.example.ArrayStrings

import java.util.*

//Input: intervals = [[1,3],[1,4],[2,5],[3,5]]
//Output: 3
//Explanation: Consider the set S = {2, 3, 4}.  For each interval, there are at least 2 elements from S in the interval.
//Also, there isn't a smaller size set that fulfills the above condition.
//Thus, we output the size of this set, which is 3.
//https://leetcode.com/problems/set-intersection-size-at-least-two/

fun main (args: Array<String>) {
    println(intersectionSizeTwo(arrayOf(intArrayOf(1,3), intArrayOf(1,4), intArrayOf(2,5), intArrayOf(3,5))))
}


fun intersectionSizeTwo(intervals: Array<IntArray>): Int {
    Arrays.sort(intervals, { interval1, interval2 -> interval1[1] - interval2[1] })
    var max = -1
    var min = -1
    var ans = 0
    for (`in` in intervals) {
        val start = `in`[0]
        val end = `in`[1]
        if (start > max) {  // [Case1] no intersection with collected ones.
            ans += 2
            min = end - 1
            max = end
        } else if (start > min) {  // [Case2] has intersection
            ans++
            min = if (max == end) max - 1 else max
            max = end
        }
        // [Case 3] end > max1 > start
        // 'max1' is already intersects with 'interval' and previous 'interval' from which 'max1' is collected.
        // This means 'max1' already intersects more than or equal to 2 times.
    }
    return ans
}