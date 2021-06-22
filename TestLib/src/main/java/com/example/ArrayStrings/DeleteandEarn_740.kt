package com.example.ArrayStrings;

//Input: nums = [2,2,3,3,3,4]
//Output: 9
//Explanation: Delete 3 to earn 3 points, deleting both 2's and the 4.
//Then, delete 3 again to earn 3 points, and 3 again to earn 3 points.
//9 total points are earned.
//https://leetcode.com/problems/delete-and-earn/

//class LastSubstringLexicographicalOrder_1163 {
fun main(args: Array<String>) {
//    System.out.println(heightChecker(intArrayOf(2,2,3,3,3,4)))
    System.out.println(deleteAndEarn(intArrayOf(3,2,4)))
}

//https://leetcode.com/problems/delete-and-earn/discuss/109895/JavaC%2B%2B-Clean-Code-with-Explanation

fun deleteAndEarnDP(nums: IntArray): Int {
    val buckets = IntArray(10001)
    for (num in nums) {
        buckets[num] += num
    }
    val dp = IntArray(10001)
    dp[0] = buckets[0]
    dp[1] = buckets[1]
    for (i in 2 until buckets.size) {
        dp[i] = Math.max(buckets[i] + dp[i - 2], dp[i - 1])
    }
    return dp[10000]
}


fun deleteAndEarn(nums: IntArray): Int {
    val n = 10001
    val values = IntArray(n)
    for (num in nums) {
        values[num] += num
    }
    var take = 0
    var skip = 0
    for (i in 0 until n) {
        val takei = skip + values[i]
        val skipi = Math.max(skip, take)
        take = takei
        skip = skipi
    }
    return Math.max(take, skip)
}
//}