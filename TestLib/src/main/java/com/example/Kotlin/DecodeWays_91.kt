package com.example.Kotlin

//    Input: "226"
//    Output: 3
//    Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
//    https://leetcode.com/problems/decode-ways/

fun main (args: Array<String>) {
    println(numDecodings("226"))
}

fun numDecodings(s: String): Int {
    var dpArray = Array<Int>(s.length+1) {-1}
    dpArray[0] = 1
    dpArray[1] = if(s[0]=='0') 0 else 1

    for (i in 2 until s.length) {
        var firstItem = Integer.parseInt(s.substring(i-1, i))
        var secondItem = Integer.parseInt(s.substring(i-2, i))

        if (firstItem> 0) {
            dpArray[i] += dpArray[i-1]
        }
        if (secondItem>=10 && secondItem<=26) {
            dpArray[i] +=dpArray[i-2]
        }
    }
    return dpArray[s.length]
}