package com.example.Kotlin

import java.util.*

//Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
//Output: "leetcode"
//Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.
//https://leetcode.com/problems/shuffle-string/

fun main (args: Array<String>) {
//    println(restoreString("codeleet", intArrayOf(4,5,6,7,0,2,1,3)))

    println(arrangeWords("Leetcode is cool"))
}

// time complexity 0(n)
// space complexity 0(n)
fun restoreString(s: String, indices: IntArray): String {
    if (s == null || s.length != indices.size) return s
    var charArray =  CharArray(s.length)

    for (i in 0 until indices.size) {
       charArray[indices[i]] =  s.get(i)
    }
    return String(charArray)
}

fun arrangeWords(text: String) :String{
    var splitWords = text.toLowerCase().split("\\s+".toRegex())
    splitWords.sortedBy { it.length }
    var result = splitWords.joinToString(" ")
    return Character.toUpperCase(result[0])+result.substring(1)
}