package com.example.ArrayStrings

//Input: nums = [2,7,9,3,1]
//Output: 12
//Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
//Total amount you can rob = 2 + 9 + 1 = 12.
//https://leetcode.com/problems/house-robber/
// f(k) = max (f(k-2)+Ak, f(k-1))

fun main (args: Array<String>) {
    println(rob(intArrayOf(2,7,9,3,1)))
}

fun rob(nums: IntArray): Int {
    if (nums.size == 0) return 0
    var prevMax = 0
    var currMax = 0
    for (x in nums) {
        val temp = currMax
        currMax = Math.max(prevMax + x, currMax)
        prevMax = temp
    }
    return currMax
}

fun robMemo(nums: IntArray) :Int {
    if (nums.size == 0) return 0
    var memo: IntArray = IntArray(nums.size+1)
    memo[0]=0
    memo[1]=nums[0]
    for (i in 1 until nums.size) {
        memo[i+1] = Math.max(memo[i-1] + nums[i], memo[i-1])
    }
    return memo[nums.size]
}