package com.example.ArrayStrings

//Sample Input
//2
//earthproblem
//letsgosomewhere
//Sample Output
//3
//2
//https://leetcode.com/discuss/interview-question/233724/Amazon-online-assessment-Longest-string-made-up-of-only-vowels

fun main (args: Array<String>) {
    println(longestString("earthproblem"))
}

fun isVowel(c: Char): Boolean {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
}

//find the subString at the start and end
//largest vowel subString in the middle
//E.g earthproblem
// start = 2, end = 11,  res = 2+11-11 = 2
// sum = 1
//total 1+2 = 3
fun longestString(s: String): Int {
    val len = s.length
    var start = 0
    var end = len - 1
    while (start < len && isVowel(s[start])) {
        ++start
    }
    while (end >= 0 && isVowel(s[end])) {
        --end
    }
    // checking area come to [start, end]
    if (start >= len) return len
    val res = start + len - 1 - end
    var longest = 0
    var sum = 0
    for (i in start + 1..end) {
        if (isVowel(s[i])) {
            ++sum
        } else {
            sum = 0
        }
        longest = Math.max(sum, longest)
    }
    return longest + res
}