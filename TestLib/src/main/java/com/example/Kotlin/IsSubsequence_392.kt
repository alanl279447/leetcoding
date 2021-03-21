package com.example.Kotlin

//Input: s = "abc", t = "ahbgdc"
//Output: true
//https://leetcode.com/problems/is-subsequence/

fun main (args: Array<String>) {
    System.out.println(isSubsequence("abc", "ahbgdc"))
}

fun isSubsequence(s: String, t: String): Boolean {
    if (s.length > t.length) return false

    var leftBound = s.length; var rightBound = t.length
    var left = 0;  var right = 0

    while (left < leftBound && right < rightBound) {
        if (s[left] == t[right]) {
            left++
        }
        right++
    }
    return left == leftBound
}