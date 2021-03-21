package com.example.ArrayStrings

import java.util.*

//https://leetcode.com/problems/excel-sheet-column-number/
//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28

fun main (args: Array<String>) {
    println(titleToNumber("ZY"))
}

fun titleToNumber(s: String): Int {
    if (s == null) return 0
    var i = 0; var temp = 0
    while (i < s.length) {
         temp = temp * 26 + (s[i++]-'A')+1
    }
    return temp
}