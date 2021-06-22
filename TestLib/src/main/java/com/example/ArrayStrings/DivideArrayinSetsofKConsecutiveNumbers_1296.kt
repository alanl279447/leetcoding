package com.example.ArrayStrings;

import java.util.*

//Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
//Output: true
//Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,11].
//https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/

//class LastSubstringLexicographicalOrder_1163 {
    fun main(args: Array<String>) {
        System.out.println(numTeams(intArrayOf(3,2,1,2,3,4,3,4,5,9,10,11)))
    }

//create a map item, count
//create a PQ(minHeap) of the items or sort the array
//get the count of first item, and check if i+k items satisfy the times check
//check if len == 0
fun isPossibleDivide(nums: IntArray, k: Int): Boolean {
    var len: Int = nums.size
    if (len % k !== 0) return false
    val map: MutableMap<Int, Int> = HashMap()
    val pq: PriorityQueue<Int> = PriorityQueue()
    for (n in nums) {
        map[n] = map.getOrDefault(n, 0) + 1
    }
    for (n in map.keys) {
        pq.add(n)
    }
    while (!pq.isEmpty()) {
        val cur = pq.poll()
        if (map[cur] == 0) continue
        val times = map[cur]!!
        for (i in 0 until k) {
            if (!map.containsKey(cur + i) || map[cur + i]!! < times) return false
            map[cur + i] = map[cur + i]!! - times
        }
        len -= k * times
    }
    return len == 0
}

//faster than PQ
fun possibleDivideSort(nums: IntArray, k: Int): Boolean {
    if (nums.size % k !== 0) return false
    val freqMap: MutableMap<Int, Int> = HashMap()
    for (currNum in nums) freqMap[currNum] = freqMap.getOrDefault(currNum, 0) + 1
    Arrays.sort(nums)
    for (currNum in nums) {
        val occurrences = freqMap[currNum]!!
        if (occurrences == 0) continue
        for (i in 0 until k) {
            if (!freqMap.containsKey(currNum + i) || freqMap[currNum + i]!! < occurrences) {
                return false
            } else {
                freqMap[currNum + i] = freqMap[currNum + i]!! - occurrences
            }
        }
    }
    return true // we successfully created nums.length/k consecutive sequences of length k using integers in nums
}
//}