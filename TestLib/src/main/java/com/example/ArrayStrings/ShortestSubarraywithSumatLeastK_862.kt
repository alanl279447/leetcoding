package com.example.ArrayStrings

import java.util.*

//Input: A = [2,-1,2], K = 3
//Output: 3
//https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/

//related https://leetcode.com/problems/minimum-size-subarray-sum/
//https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/discuss/189039/Detailed-intuition-behind-Deque-solution

fun main (args: Array<String>) {
    println(shortestSubarray(intArrayOf(3,-2, 5), 4))   //1
//    println(shortestSubarray(intArrayOf(17,85,93,-45,-21), 150))
}


//this can have negative values!!!
// the first element in the deque is smaler than the others (queue is increasing),
//So because the Deque is increasing (B[d[0]] <= B[d[1]]), we have B[i] - B[d[0]] >= B[i] - B[d[1]],
fun shortestSubarray(A: IntArray, K: Int): Int {
    val n: Int = A.size
    val B = IntArray(n + 1)
    for (i in 0 until n) {
        B[i + 1] = B[i] + A[i]      //0,3,1,6
    }
    var res = n + 1

    val dq: Deque<Int> = LinkedList()   //montonic increasing queue

    for (i in 0 until n + 1) {
        while (!dq.isEmpty() && B[i] - B[dq.peekFirst()] >= K) {
            res = Math.min(res, i - dq.pollFirst())
        }
        while (!dq.isEmpty() && B[i] <= B[dq.peekLast()]) {
            dq.pollLast()
        }
        dq.add(i)
    }
    return if (res <= n) res else -1
}