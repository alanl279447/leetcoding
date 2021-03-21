package com.example.ArrayStrings

//Input: cost = [10, 15, 20]
//Output: 15
//Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
//https://leetcode.com/problems/min-cost-climbing-stairs/

fun main (args: Array<String>) {
    println(minCostClimbingStairs(intArrayOf(10,15,20)))
}

fun minCostClimbingStairsSpaceOpt(cost: IntArray): Int {
    if (cost == null) return 0
    var len = cost.size
    if (len <=2) {
        return Math.max(cost[0], cost[1])
    }
    var first = cost[0]; var second = cost[1]
    for (i in 2 until len) {
        var curr = cost[i] + Math.min(first, second)
        first = second
        second = curr
    }
    return Math.min(first, second)

}

fun minCostClimbingStairs(cost: IntArray): Int {
    val n: Int = cost.size
    val dp = IntArray(n)
    for (i in 0 until n) {
        if (i < 2) {
            dp[i] = cost[i]
        } else {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2])
        }
    }
    return Math.min(dp[n - 1], dp[n - 2])
}