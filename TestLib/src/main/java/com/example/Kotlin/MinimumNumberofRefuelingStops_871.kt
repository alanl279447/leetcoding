package com.example.Kotlin

import javafx.scene.layout.Priority
import java.util.*
import kotlin.math.max

//Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
//Output: 2
//Explanation:
//We start with 10 liters of fuel.
//We drive to position 10, expending 10 liters of fuel.  We refuel from 0 liters to 60 liters of gas.
//Then, we drive from position 10 to position 60 (expending 50 liters of fuel),
//and refuel from 10 liters to 50 liters of gas.  We then drive to and reach the target.
//We made 2 refueling stops along the way, so we return 2.
//https://leetcode.com/problems/minimum-number-of-refueling-stops/

fun main (args: Array<String>) {
    var stations:Array<IntArray> = arrayOf(intArrayOf(10,60),
            intArrayOf(20,30), intArrayOf(30,30), intArrayOf(60,40))
    println(minRefuelStops(100, 10, stations))
}

fun minRefuelStops(target: Int, tank: Int, stations: Array<IntArray>): Int {
   if (tank >= target) {
       return 0
   }
   var queue = PriorityQueue<Int> {a,b -> b-a}
   var maxDistance = tank
   var n = stations.size; var i = 0
   var stops = 0
    while (maxDistance < target) {
      while (i < n && stations[i][0] <= maxDistance) {
            queue.offer(stations[i++][1])
      }
      if (queue.isEmpty()) return -1
      maxDistance += queue.poll()
      stops++
    }
    return stops
}