package com.example.ArrayStrings

//Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
//Output: 16
//Explanation: The bookstore owner keeps themselves not grumpy for the last 3 minutes.
//The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.
//https://leetcode.com/problems/grumpy-bookstore-owner/

fun main (args: Array<String>) {
    println(maxSatisfied(intArrayOf(1,0,1,2,1,1,7,5), intArrayOf(0,1,0,1,0,1,0,1), 3))
}

fun maxSatisfied(customers: IntArray, grumpy: IntArray, X: Int): Int {
    var satisfied = 0; var maxMakeSatisfied = 0; var curChange = 0
    for (i in 0..customers.size) {
        if (grumpy[i] == 0) {
            satisfied += customers[i]
        } else {
            curChange += customers[i]
        }
        if (i >= X && grumpy[i-X] == 1) {
            curChange -= customers[i-X]
        }
        maxMakeSatisfied = Math.max(maxMakeSatisfied, curChange)
    }
    return maxMakeSatisfied+satisfied
}