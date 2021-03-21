package com.example.ArrayStrings;

import com.example.ArrayStrings.MainTesting.arr




//Input: rating = [2,5,3,4,1]
//Output: 3
//Explanation: We can form three teams given the conditions. (2,3,4), (5,4,1), (5,3,1).
//https://leetcode.com/problems/count-number-of-teams/

//class LastSubstringLexicographicalOrder_1163 {
    fun main(args: Array<String>) {
        System.out.println(numTeams(intArrayOf(2,5,3,4,1)))
    }

//  time complexity 0(n^2)
   fun numTeams(rating: IntArray): Int {
       var count = 0
       val len = arr.size
       for (j in 0 until len) {
           var leftSmaller = 0
           var rightLarger = 0
           var leftLarger = 0
           var rightSmaller = 0
           for (i in 0 until j) {
               if (arr[i] < arr[j]) {
                   leftSmaller++
               } else if (arr[i] > arr[j]) {
                   leftLarger++
               }
           }
           for (k in j + 1 until len) {
               if (arr[j] < arr[k]) {
                   rightLarger++
               } else if (arr[j] > arr[k]) {
                   rightSmaller++
               }
           }
           count += leftSmaller * rightLarger + leftLarger * rightSmaller
       }

       return count
   }
//}