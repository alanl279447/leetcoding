package com.example.Kotlin

//Input: s = "PAYPALISHIRING", numRows = 4
//Output: "PINALSIGYAHRPI"
//Explanation:
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
//https://leetcode.com/problems/zigzag-conversion/
// 0(n)

fun main (args: Array<String>) {
    val result = convert("PAYPALISHIRING", 4)
    println(result)
}

fun convert(s: String, numRows: Int): String {
    if (numRows==1) return s

    var items : MutableList<StringBuilder> = ArrayList()
    for (i in 0 until s.length) {
        items.add(StringBuilder())
    }
    var count=0
    var toggleSide=false
    for (c in s.toCharArray()) {
        items[count].append(c)
        if (count==0 || count == numRows-1) toggleSide = !toggleSide
        count += if (toggleSide) 1 else -1
    }

    var result=StringBuilder()
    for (item in items) {
        result.append(item)
    }
    return result.toString()
}