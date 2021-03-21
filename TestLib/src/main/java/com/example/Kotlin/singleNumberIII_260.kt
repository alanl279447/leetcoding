package com.example.Kotlin

//    Input: nums = [1,2,1,3,2,5]
//    Output: [3,5]
//    Explanation:  [5, 3] is also a valid answer.
//   https://leetcode.com/problems/single-number-iii/

fun main (args: Array<String>) {

    var res = singleNumberIII(arrayOf(1,2,1,3,2,5))
    for (i in res) {
        println(i)
    }
}

//first find the XOR of all the nums
//find the lowest bit (x & -x)
//bucket the numbers in two sets
public fun singleNumberIII(nums: Array<Int>): Array<Int> {
    var diff = 0
    for (i in nums) {
        diff = diff xor i
    }
    diff = diff and (-diff)
    var result = Array<Int>(2) {0}
    for (i in nums) {
        if (i and diff ==0) {
            result[0] = result[0] xor i
        } else {
            result[1] = result[1] xor i
        }
    }
    return result
}