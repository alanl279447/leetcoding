package com.example.DynamicProgramming

//Input: costs = [[17,2,17],[16,16,5],[14,3,19]]
//Output: 10
//Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
//Minimum cost: 2 + 5 + 3 = 10.
//https://leetcode.com/problems/paint-house/

fun main (args: Array<String>) {
    println(minCost(arrayOf(intArrayOf(17,2,17), intArrayOf(16,16,5), intArrayOf(14,3,19))))
}

fun minCost(costs: Array<IntArray>): Int {
    var r = 0; var g = 0; var b = 0
    for (i in 0 until costs.size) {
        var rr = r; var gg =g; var bb = b
        r = costs[i][0] + Math.min(gg, bb)
        b = costs[i][1] + Math.min(rr, gg)
        g = costs[i][2] + Math.min(rr, bb)
    }
    return Math.min(r, Math.min(b,g))
}