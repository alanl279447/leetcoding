package com.example.Kotlin

//Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
//        Output: true
//        Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
//        https://leetcode.com/problems/verifying-an-alien-dictionary/

fun main (args: Array<String>) {
    println(isAlienSorted(arrayOf("hello","leetcode"), "hlabcdefgijkmnopqrstuvwxyz"))
}

fun isAlienSorted(words: Array<String>, order: String): Boolean {
    var charMap =  IntArray(26)
    for (i in 0 until order.length) {
        charMap[order[i]-'a'] = i    //set the order based on the position
    }
    for (i in 1 until words.size) {
        if (compare(words[i-1], words[i], charMap) > 0) { //has to be less than zero
            return false;
        }
    }
    return true
}

fun compare(word1: String, word2: String, charMap: IntArray) : Int {
    var currentcount = 0
    var i=0; var j=0
    while(i < word1.length && j < word2.length && currentcount ==0) {
        currentcount +=  charMap[word1[i]-'a'] - charMap[word2[j]-'a']
        i++
        j++
    }
    if (currentcount==0) {
        return word1.length-word2.length
    }
    return currentcount
}