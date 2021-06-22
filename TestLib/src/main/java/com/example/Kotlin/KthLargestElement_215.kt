package com.example.Kotlin

import java.util.*

//    Input: [3,2,1,5,6,4] and k = 2
//    Output: 5
//
//    Input: [3,2,3,1,2,4,5,5,6] and k = 4
//    Output: 4
//    https://leetcode.com/problems/kth-largest-element-in-an-array/

//similar KClosestPointstoOrigin

fun main (args: Array<String>) {
    println(findKthLargest(intArrayOf(3,2,1,5,6,4), 2))
//    println(findKthLargest(intArrayOf(3,2,3,1,2,4,5,5,6), 4))
}

fun findKthLargest(nums: IntArray, k: Int): Int {
    var start = 0
    var end = nums.size - 1
    val index = nums.size - k
    //shuffle(nums)
    while (start <= end) {
        val pivot = partionTest(nums, start, end)
        if (pivot < index) {
            start = pivot + 1
        } else if (pivot > index) {
            end = pivot - 1
        } else {
            return nums[pivot]
        }
    }
    return nums[start]
}

fun partionTest(nums: IntArray, start: Int, end: Int): Int {
    var partition = start;
    var start = start+1;
    var end = end

    while(start <= end) {
        if (nums[start] <= nums[partition]) start++;
        else if (nums[end] >= nums[partition]) end--;
        else {
            swap(nums, start, end)
        }
    }
    swap(nums, partition, end);
    return end;
}


fun partion(nums: IntArray, start: Int, end: Int): Int {
    var start = start
    var end = end
    val pivot = start
    var temp: Int
    while (start <= end) {
        while (start <= end && nums[start] <= nums[pivot]) start++
        while (start <= end && nums[end] > nums[pivot]) end--
        if (start > end) break
        swap(nums, start, end)
    }
    swap(nums, pivot, end)
    return end
}

fun shuffle(a: IntArray) {
    val random = Random()
    for (ind in 1 until a.size) {
        val r: Int = random.nextInt(ind + 1)
        swap(a, ind, r)
    }
}

fun swap(nums:IntArray, start:Int, end:Int) {
    var temp = nums[end]
    nums[end] = nums[start]
    nums[start] = temp
}