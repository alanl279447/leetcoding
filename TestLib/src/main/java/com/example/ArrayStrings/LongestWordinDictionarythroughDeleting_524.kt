package com.example.ArrayStrings;

import com.example.ArrayStrings.IsSubsequence_392.isSubsequence




//Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//Output: "apple"
//https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/

//class LastSubstringLexicographicalOrder_1163 {
fun main(args: Array<String>) {
    System.out.println(findLongestWord("abpcplea", listOf("ale", "apple", "monkey", "plea")))
}

fun findLongestWord(s: String, dictionary: List<String>): String {
    var max_str = ""
    for (str in dictionary) {
        if (isSubsequenceInner(str, s)) {
            if (str.length > max_str.length || str.length == max_str.length && str.compareTo(max_str) < 0) {
                max_str = str
            }
        }
    }
    return max_str
}

fun isSubsequenceInner(dict: String, s: String): Boolean {
    var j = 0
    var i = 0
    while (i < s.length && j < dict.length) {
        if (dict[j] == s[i]) {
            j++
        }
        i++
    }
    return j == dict.length
}
//}