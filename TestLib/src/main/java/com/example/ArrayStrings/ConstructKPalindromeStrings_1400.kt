package com.example.ArrayStrings

//Input: s = "annabelle", k = 2
//Output: true
//Explanation: You can construct two palindromes using all characters in s.
//Some possible constructions "anna" + "elble", "anbna" + "elle", "anellena" + "b"
//https://leetcode.com/problems/construct-k-palindrome-strings/

fun main (args: Array<String>) {
    println(canConstruct("annabelle", 2))
}

//Condition 1. odd characters <= k
//Condition 2. k <= s.length()
fun canConstruct(s: String, K:Int):Boolean {
   var count = IntArray(26)
   var odd = 0
   for (i in 0..s.length) {
       count[s[i]-'a']++
    }
    var oddOccuringCharacter = 0
    for (i in 0..26) {
        oddOccuringCharacter += count[i]%2
    }
    return (odd <=K) and (K <= s.length)
}
