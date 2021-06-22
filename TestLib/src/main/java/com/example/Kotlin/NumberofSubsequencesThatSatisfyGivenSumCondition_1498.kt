package com.example.Kotlin

import java.util.*

//Input: nums = [3,3,6,8], target = 10
//Output: 6
//Explanation: There are 6 subsequences that satisfy the condition. (nums can have repeated numbers).
//[3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6]
//https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/
//https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/discuss/709227/JavaC%2B%2BPython-Two-Sum
// time complexity o(nlogn)
fun main (args: Array<String>) {
    var nums = intArrayOf(3,3,6,8)
    println(numSubSeq(nums, 10))
}

//8,6,3,3
//3,3,6,8
//2 ^ (right - left - 1 +1) == 2 ^ (right - left)
// for every left value, find the largest right value and add the dp[r-l] to the result
//Sort input A first,
//For each A[i], find out the maximum A[j]
//that A[i] + A[j] <= target.
//
//For each elements in the subarray A[i+1] ~ A[j],
//we can pick or not pick,
//so there are 2 ^ (j - i) subsequences in total.
//So we can update res = (res + 2 ^ (j - i)) % mod.

//3,5,6,7  9
//left+right <= target
//res += 2^(right-left)

// 3
// 3  3       3  3 3
// 3  3  6    3  3 3  3  6  3 3 6
// 3  3  6  8

fun numSubSeq(nums: IntArray, target: Int) :Int{
    Arrays.sort(nums)
    var res = 0
    val n: Int = nums.size
    var l = 0
    var r = n - 1
    val mod = 1e9.toInt() + 7
    val pows = IntArray(n)
    pows[0] = 1
    for (i in 1 until n) {
        pows[i] = pows[i - 1] * 2 % mod   // multiply by 2 since there are two cases for every digit 3,3  3,x
    }
    while (l <= r) {
        if (nums[l] + nums[r] > target) {
            r--
        } else {
            res = (res + pows[r-l]) % mod
            l++
        }
    }
    return res
}