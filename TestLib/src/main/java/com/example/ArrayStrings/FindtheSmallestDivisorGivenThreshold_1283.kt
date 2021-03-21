package com.example.ArrayStrings;

import com.example.ArrayStrings.MainTesting.arr
import kotlin.concurrent.thread

//Input: nums = [1,2,5,9], threshold = 6
//Output: 5
//Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1.
//If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2).
//https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
//Left shift: x << 1. The same as multiplying by 2: x * 2.
//Right shift: x >> 1. The same as dividing by 2: x / 2.

//class LastSubstringLexicographicalOrder_1163 {
fun main(args: Array<String>) {
    System.out.println(smallestDivisor(intArrayOf(1,2,5,9), 6))
}

fun  smallestDivisorTest(nums: IntArray, threshold:Int):Int {
     var left = 0; var right = 1e6.toInt()
     while (left < right) {
         var sum:Int  = 0
         var divisor = left +(right-left)/2
         for (i in 0 until nums.size) {
             sum += ((nums[i]+divisor-1)/divisor)
         }
         if (sum > threshold) {
             left = divisor+1
         } else {
             right = divisor
         }
     }
    return left
}


//TLE
fun  smallestDivisor(nums: IntArray, threshold:Int):Int {
    var d =1
    while (computeSum(nums, d) > threshold) {
        d++;
    }
    return d
}

fun computeSum(nums: IntArray, d: Int):Int {
    var sum = 0
    for (num in nums) {
        sum += num/d  + if(num%d==0) 0 else 1
    }
    return sum
}

//}