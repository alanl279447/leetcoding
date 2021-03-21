package com.example.ArrayStrings

import java.util.*
import kotlin.Comparator

//Input: [[5,4],[6,4],[6,7],[2,3]]
//[[1, 3], [1, 4], [1, 5], [2, 3]]
//Output: 3
//Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
//https://leetcode.com/problems/russian-doll-envelopes/

fun main (args: Array<String>) {
    println(maxEnvelopes(arrayOf(intArrayOf(5,4), intArrayOf(6,4), intArrayOf(6,7), intArrayOf(2,3))))
//    println(maxEnvelopes(arrayOf(intArrayOf(1,3), intArrayOf(6,4), intArrayOf(6,7), intArrayOf(2,3))))
}

fun lengthOfLIS(nums: IntArray): Int {
    val dp = IntArray(nums.size)
    var len = 0
    for (num in nums) {
        var i: Int = Arrays.binarySearch(dp, 0, len, num)
        if (i < 0) {
            i = -(i + 1)
        }
        dp[i] = num
        if (i == len) {
            len++
        }
    }
    return len
}

fun maxEnvelopes(envelopes: Array<IntArray>): Int {
    // sort on increasing in first dimension and decreasing in second
    Arrays.sort(envelopes, { arr1, arr2 -> if (arr1[0] == arr2[0]) {
                arr2[1] - arr1[1]
            } else {
                arr1[0] - arr2[0]
            }
        })
    // extract the second dimension and run LIS
    val secondDim = IntArray(envelopes.size)
    for (i in envelopes.indices) secondDim[i] = envelopes[i][1]
    return lengthOfLIS(secondDim)
}