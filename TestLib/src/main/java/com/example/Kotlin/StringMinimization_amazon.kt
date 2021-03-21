package com.example.Kotlin

//    aabcccabba
//    left: aabcc   right:cabba
//    https://leetcode.com/discuss/interview-question/883784/amazon-string-minimization

fun main (args: Array<String>) {
    println(stringMinimization("aabcccabba"))
}

fun stringMinimization(input: String) :Int {
    if (input == null) return 0

    var left = 0; var right = input.length-1
      while (left < right && input[left] == input[right]) {
          var c = input[left]
          while(left<right && input[left]==c) left++
          while(left<right && input[right]==c) right--
      }
    return right-left+1
}

