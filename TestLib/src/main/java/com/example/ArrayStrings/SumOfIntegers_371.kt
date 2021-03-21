package com.example.ArrayStrings

//Input: a = -2, b = 3
//Output: 1
//https://leetcode.com/problems/sum-of-two-integers/
//https://stackoverflow.com/questions/48474520/how-do-i-use-javas-bitwise-operators-in-kotlin

fun main (args: Array<String>) {
//    println(rodMemo(intArrayOf(2,7,9,3,1)))
    println(getSum(-2,3))
}

fun getSum(a: Int, b: Int): Int {
     var a = a; var b = b
     var ans = 0; var carry = 0
     while (b != 0) {
         ans = a xor b
         carry  = (a and b) shl 1
         a = ans
         b = carry
     }
    return a
}
