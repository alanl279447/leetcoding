package com.example.ArrayStrings

import java.util.*

//Input: A = [2,-1,2], K = 3
//Output: 3
//https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/

fun main (args: Array<String>) {
    println(shortestSubarray(intArrayOf(3,-2, 5), 4))   //1
//    println(shortestSubarray(intArrayOf(17,85,93,-45,-21), 150))
}

fun shortestSubarray(A: IntArray, K: Int): Int {
    val N: Int = A.size
    val P = LongArray(N + 1)
    for (i in 0 until N) {
        P[i + 1] = P[i] + A[i].toLong()
    }

    // Want smallest y-x with P[y] - P[x] >= K
    var ans = N + 1 // N+1 is impossible

    val monoq: Deque<Int> = LinkedList() //opt(y) candidates, as indices of P
    for (y in P.indices) {
        // Want opt(y) = largest x with P[x] <= P[y] - K;
        while (!monoq.isEmpty() && P[y] <= P[monoq.getLast()])  {
            monoq.removeLast()
        }
        while (!monoq.isEmpty() && P[y] >= P[monoq.getFirst()] + K) {
            ans = Math.min(ans, y - monoq.removeFirst())
        }
        monoq.addLast(y)
    }
    return if (ans < N + 1) ans else -1
}