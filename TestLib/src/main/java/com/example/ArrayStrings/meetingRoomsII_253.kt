package com.example.ArrayStrings

import java.util.*
import kotlin.Comparator

//Input: [[0, 30],[5, 10],[15, 20]]
//Output: 2
//https://leetcode.com/problems/meeting-rooms-ii/

fun main (args: Array<String>) {
    println(minMeetingRooms(arrayOf(intArrayOf(0,30), intArrayOf(5,10), intArrayOf(15,20))))
}

fun minMeetingRooms(intervals: Array<IntArray>): Int {
   if (intervals == null || intervals.size==0) return 0
   intervals.sortWith(Comparator<IntArray>{a,b->a[0]-b[0]})  //sort based on start time

   var interval = intervals[0]
   var pq:PriorityQueue<IntArray> = PriorityQueue<IntArray>{a,b-> a[1]-b[1]} //get the meeting end the soonest
   pq.offer(interval)
    for (i in 1 until intervals.size) {
        if (intervals[i][0] >= interval[1]) {
            pq.poll()
        }
        pq.offer(intervals[i])
    }
    return pq.size
}