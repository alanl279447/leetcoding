package com.example.ArrayStrings

//    Input: [[1,2],[2,3],[3,4],[1,3]]
//    (1,11),(12,100),(13,14),(14,15),(15,16).
//    Output: 1
//    Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
//            https://leetcode.com/problems/non-overlapping-intervals/

fun main (args: Array<String>) {
    println(eraseOverlapIntervalsTest(arrayOf(intArrayOf(1,2),
                                              intArrayOf(2,3), intArrayOf(3,4), intArrayOf(1,3))))
}
//    sort based on the end time!!
//    (1,11), (13,14), (14,15), (15,16), (12,100)
fun eraseOverlapIntervalsTest(nums: Array<IntArray>) : Int {
         nums.sortWith(Comparator<IntArray>{a,b-> a[1]-b[1]})
         var end = nums[0][1]
         var count = 0
         for (i in 1..nums.size) {
             if (nums[i][0] >= end) {
                 end = nums[i][1]
                 count++
             }
         }
    return nums.size-count
}