package com.example.ArrayStrings

//Input: pattern = "abba", str = "dog cat cat dog"
//Output: true
//https://leetcode.com/problems/word-pattern/

fun main (args: Array<String>) {
    println(wordPattern("abba", "dog cat cat dog"))
}



fun wordPattern(pattern: String, str: String): Boolean {
   val strSplit = str.split(" ")
   var map: MutableMap<Char, String> = mutableMapOf()

   if (strSplit.size != pattern.length) {
       return false
   }

   for((index, value) in strSplit.withIndex()) {
     var c = pattern.get(index)
     if (map.containsKey(c)) {
         if (!map.get(c).equals(strSplit[index])) {
             return false
         }
     } else {
         if (map.containsValue(strSplit[index])) {
             return false
         }
         map.put(c, strSplit[index])
     }
   }
    return true
}