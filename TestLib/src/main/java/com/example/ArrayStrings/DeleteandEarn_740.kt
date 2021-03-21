package com.example.ArrayStrings;

//Input: nums = [2,2,3,3,3,4]
//Output: 9
//Explanation: Delete 3 to earn 3 points, deleting both 2's and the 4.
//Then, delete 3 again to earn 3 points, and 3 again to earn 3 points.
//9 total points are earned.
//https://leetcode.com/problems/delete-and-earn/

//class LastSubstringLexicographicalOrder_1163 {
fun main(args: Array<String>) {
//    System.out.println(heightChecker(intArrayOf(2,2,3,3,3,4)))
    System.out.println(deleteAndEarn(intArrayOf(3,2,4)))
}

//take[i] = skip[i-1] + values[i];
//skip[i] = Math.max(skip[i-1], take[i-1]);
//take[i] can only be derived from: if you skipped the [i-1]th bucket, and you take bucket[i].
//skip[i] through, can be derived from either take[i-1] or skip[i-1], whatever the bigger;

fun deleteAndEarn(nums: IntArray): Int {
    val n = 10001
    val values = IntArray(n)
    for (num in nums) {
        values[num] += num
    }
    var take = 0
    var skip = 0
    for (i in 0 until n) {
        val takei = skip + values[i]
        val skipi = Math.max(skip, take)
        take = takei
        skip = skipi
    }
    return Math.max(take, skip)
}
//}