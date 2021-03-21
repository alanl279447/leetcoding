package com.example.ArrayStrings

//Input: m = 3, n = 3, ops = [[2,2],[3,3]]
//Output: 4
//Explanation: The maximum integer in M is 2, and there are four of it in M. So return 4.
//https://leetcode.com/problems/range-addition-ii/

fun main (args: Array<String>) {
    println(maxCount(3,3,arrayOf(intArrayOf(2,2), intArrayOf(3,3))))
}

fun maxCount(m: Int, n: Int, ops: Array<IntArray>): Int {
    if (ops == null || ops.size==0) return 0
    var row  =0; var col = 0
    for (op:IntArray in ops) {
        row = Math.min(row, op[0])
        col = Math.min(col, op[1])
    }
   return row*col
}