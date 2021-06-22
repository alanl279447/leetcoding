package com.example.ArrayStrings

import java.util.*

//Input:
//words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
//Output: "apple"
//Explanation:
//Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
//https://leetcode.com/problems/longest-word-in-dictionary/

fun main (args: Array<String>) {
    println(longestWord(arrayOf("a", "banana", "app", "appl", "ap", "apply", "apple")))
}

fun longestWord(words: Array<String>): String {
    Arrays.sort(words)
    val built: MutableSet<String> = HashSet()
    var res = ""
    for (w in words) {
        var temp = w.substring(0, w.length - 1)
        if (w.length == 1 || built.contains(temp)) {
            res = if (w.length > res.length) w else res
            built.add(w)
        }
    }
    return res
}