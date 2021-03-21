package com.example.ArrayStrings;

import java.util.*

//Input: nums = [3,1,4,1,5], k = 2
//Output: 2
//Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
//Although we have two 1s in the input, we should only return the number of unique pairs.
//https://leetcode.com/problems/k-diff-pairs-in-an-array/

//class LastSubstringLexicographicalOrder_1163 {
fun main(args: Array<String>) {
    System.out.println(findPairs(intArrayOf(3,1,4,1,5), 2))
}

//3,1,4,1,5   K = 2
// 1-2, 3-1, 4-1, 5-1

fun findPairs(nums: IntArray, k: Int): Int {
    var result = 0
    var map: HashMap<Int, Int> = HashMap()

    for (i in 0 until nums.size) {
        map.put(nums[i], map.getOrDefault(nums[i], 0) +1)
    }

    for (entry in map.keys) {
        var key = entry
        var value = map.get(key)
        if (k >0 && map.containsKey(key+k)) {
            result++
        } else if (k ==0 && value!! > 1) {
            result++
        }
    }
    return result
}

//brute force https://leetcode.com/problems/k-diff-pairs-in-an-array/solution/
fun findPairsBR(nums: IntArray, k: Int): Int {
    Arrays.sort(nums)    //1,1,3,4,5
    var left = 0; var right = 0; var result = 0
    for (i in 0 until nums.size) {
        if (i > 0 && nums[i] == nums[i-1]) continue
        for (j in i+1 until nums.size) {
            if (j > i+1 && nums[j] == nums[j-1]) continue
            if (Math.abs(nums[j] - nums[i]) == k) result++
        }
    }
   return result
}
//}