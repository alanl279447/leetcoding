package com.example.ArrayStrings

//    Input: [[1,3],[2,6],[8,10],[15,18]]
//    Output: [[1,6],[8,10],[15,18]]
//    Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
//
//    Input: [[1,4],[4,5]]
//    Output: [[1,5]]
//    Explanation: Intervals [1,4] and [4,5] are considered overlapping.

fun main (args: Array<String>) {
    println(merge(arrayOf(intArrayOf(1,3), intArrayOf(2,6), intArrayOf(8,10), intArrayOf(15,18))))
}

fun merge(intervals: Array<IntArray>): Array<IntArray> {
    intervals.sortWith(Comparator { a, b -> a[0] - b[0] }) //sort based on the start time
    var currentInterval = intervals[0]
    var result: ArrayList<IntArray> = ArrayList()
    result.add(currentInterval)

    for (i in 1..intervals.size) {
        var currentStartTime = currentInterval[0]
        var currentEndtime = currentInterval[1]

        var nextInterval = intervals[i]
        if (currentEndtime > nextInterval[0]) {
            currentInterval[1] = if (currentInterval[1] > nextInterval[1]) currentInterval[1] else nextInterval[1]
        } else {
            result.add(nextInterval)
            currentInterval = nextInterval
        }
    }
    return result.toTypedArray()
}