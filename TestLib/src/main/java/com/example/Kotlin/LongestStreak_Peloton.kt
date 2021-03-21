package com.example.Kotlin

import java.util.*

/**
A weekly streak is defined as one or more consective active weeks in which a user has worked out.
Given an array of active user days, find the length of the longest active weekly streak.
  
Each element in the array represents an offset from an arbitrary Monday in the calendar (e.g. Monday January 2nd 2017). 
The offsets are zero indexed.

Some helpful definitions:
- Active day
    There is at least one exercise for the user during a calendar day
- Active week
    A calendar week, starting on a monday, with at least one active day for a user
- Weekly streak
    One or more weeks (consecutive) active weeks in a user's workout history
    The length of the streak is defined as the number of active weeks in the streak
 **/
val streak1 = arrayOf<Int>()                        // 0
val streak2 = arrayOf(100)                          // 1
val streak3 = arrayOf(9, 14, 203, 405)              // 2
val streak4 = arrayOf(203, 14, 405, 9)              // 2
val streak5 = arrayOf(9, 14, 365, 366, 367)         // 2
val streak6 = arrayOf(2, 22, 29, 37, 43, 366, 391)  // 4

fun main (args: Array<String>) {
    val streaks = arrayOf(streak1, streak2, streak3, streak4, streak5, streak6)
    streaks.map {findLongestStreak(it) }.forEach(::print)
    streaks.mapIndexed{idx, value -> findLongestStreak(value)}.forEach(::println)
}

fun findLongestStreak(exerciseDays: Array<Int>):Int {
   if (exerciseDays.isNullOrEmpty()) return 0
    Arrays.sort(exerciseDays)
    var weekDays = IntArray(exerciseDays.size)
   for (i in 0 until exerciseDays.size) {
       weekDays[i] = exerciseDays[i]/7+1
   }
   var temp = 1
   var result = temp
   for (j in 1 until exerciseDays.size) {
       if (j < exerciseDays.size && exerciseDays[j] == exerciseDays[j-1]+1) {
           temp++
           result = Math.max(result, temp)
       }
   }
    return result
}