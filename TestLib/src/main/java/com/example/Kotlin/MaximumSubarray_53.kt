package com.example.Kotlin

import java.util.*

//Input: [-2,1,-3,4,-1,2,1,-5,4],
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
//https://leetcode.com/problems/maximum-subarray/

fun main (args: Array<String>) {
//    val input = mutableListOf<Int>(-2,1,-3,4,-1,2,1,-5,4)
//    println(maxSubArray(input))
}

  //-2,-1,-3,4,-1,2,1,-5,4
fun maxSubArray(inputs: MutableList<Int>) :Int {
    if (inputs == null || inputs.size == 0) return 0
    var current = inputs.get(0)
    var maxSum = inputs.get(0)

    for (i in 0 until inputs.size) {
        current = Math.max(inputs.get(i), current+inputs.get(i))
        maxSum = Math.max(maxSum, current)
    }
    return maxSum
}


