package com.example.ArrayStrings


//Input: s = "egg", t = "add"
//Output: true
//https://leetcode.com/problems/isomorphic-strings/

fun main (args: Array<String>) {
    println(isIsoTest("egg", "add"))
    println(isIsoTest("ab", "aa"))
}

fun isIsoTest(s: String, t: String) : Boolean {
    var m1 = IntArray(256){-1}; var m2 = IntArray(256){-1};

    for (i in 0 until s.length) {
        val index1 = s[i]-'0'
        val index2 = t[i]-'0'
        if (m1[index1] != m2[index2]) {
            return false
        }
        m1[index1] = i
        m2[index2] = i
    }
    return true;
}