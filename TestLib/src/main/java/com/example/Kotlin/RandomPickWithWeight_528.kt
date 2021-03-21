package com.example.Kotlin

import kotlin.random.Random

//    Given an array w of positive integers, where w[i] describes the weight of index i,
//    write a function pickIndex which randomly picks an index in proportion to its weight.
//   https://leetcode.com/problems/random-pick-with-weight/

fun main (args: Array<String>) {
//    System.out.println(myNameTest)
}

class RandomPick {

    var list: ArrayList<Int>
    var total = 0
    constructor(nums: IntArray) {
        list = ArrayList()
        for(i in nums) {
            total += i
            list.add(total)
        }
    }

    fun pickIndex(): Int {
        var random = Random
        var target = random.nextInt(total)
        var left = 0; var right = list.size

        while (left <= right) {
            var midpt = left+ (right-left)/2
            if(list[midpt] == target) return midpt;
            else if (target <= list[midpt]) {
                left = midpt+1;
            } else {
                right = midpt-1;
            }
        }
         return left
    }
}