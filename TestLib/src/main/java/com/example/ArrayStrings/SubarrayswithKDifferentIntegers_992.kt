package com.example.ArrayStrings

//Input: A = [1,2,1,2,3], K = 2
//Output: 7
//Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
//https://leetcode.com/problems/subarrays-with-k-different-integers/

//similar
//1248. Count Number of Nice Subarrays https://leetcode.com/problems/count-number-of-nice-subarrays/


fun main (args: Array<String>) {
//    println(rodMemo(intArrayOf(2,7,9,3,1)))
    println(subarraysWithKDistinct(intArrayOf(1,2,1,2,3), 2))
}

fun subarraysWithKDistinct(A: IntArray, K: Int): Int {
    return subarraysWithMostKDistinct(A, K) - subarraysWithMostKDistinct(A, K - 1)
}

private fun subarraysWithMostKDistinct(A: IntArray, K: Int): Int {
    var left = 0
    var ans = 0
    val map = IntArray(A.size + 1)
    var count = 0
    for (right in A.indices) {
        if (++map[A[right]] == 1) count++
        while (count > K) {
            if (--map[A[left]] == 0) count--
            left++
        }
        ans += right - left + 1
    }
    return ans
}