package com.example.Kotlin

//Input: num = 16
//Output: true
//https://leetcode.com/problems/valid-perfect-square/

fun main (args: Array<String>) {
    println(isPerfectSquare(808201))
}

fun isPerfectSquare(num: Int): Boolean {
    if (num < 2) {
        return true
    }

    var left: Long = 2
    var right = (num / 2).toLong()
    var x: Long
    var guessSquared: Long
    while (left <= right) {
        x = left + (right - left) / 2
        guessSquared = (x * x)
        if (guessSquared == num.toLong()) {
            return true
        }
        if (guessSquared > num) {
            right = x - 1
        } else {
            left = x + 1
        }
    }
    return false
}