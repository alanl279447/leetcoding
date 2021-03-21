package com.example.Kotlin

fun main (args: Array<String>) {
    val items = mutableListOf(1,7,3,6,5,6);
    println(pivotIndex(items))
}

fun pivotIndex(nums: MutableList<Int>): Int {
    var leftSum = 0; var totalSum = 0
    for (num in nums) {
        totalSum += num
    }

    for ((index, value) in nums.withIndex()) {
        if (leftSum == totalSum - leftSum - nums[index]) {
            return index
        }
        leftSum += nums[index]
    }
    return -1
 }