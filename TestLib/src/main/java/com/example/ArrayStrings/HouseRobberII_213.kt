package com.example.ArrayStrings

//Input: nums = [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//Total amount you can rob = 1 + 3 = 4.
//https://leetcode.com/problems/house-robber-ii/

fun main (args: Array<String>) {
    println(rob2(intArrayOf(1,2,3,1)))
}

// 1 until nums.len-1  //skip the firs
// 0 until num.len-2   //skip the last

fun rob2(nums: IntArray): Int {
  if (nums.size == 0) return 0
  if (nums.size == 1) return nums[0]

  var max1 = robSimple(nums, 0, nums.size-1)
  var max2 = robSimple(nums, 1, nums.size)

  return Math.max(max1, max2)
}

fun robSimple(nums: IntArray, start: Int, end: Int): Int{
    var prevMax = 0
    var currMax = 0
    for (x in start until end) {
        val temp = currMax
        currMax = Math.max(prevMax + x, currMax)
        prevMax = temp
    }
    return currMax
}