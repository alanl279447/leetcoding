package com.example.TreesAndGraph

import java.util.*

//Input: mat = [[1,10,10],[1,4,5],[2,3,6]], k = 7
//Output: 9
//Explanation: Choosing one element from each row, the first k smallest sum are:
//[1,1,2], [1,1,3], [1,4,2], [1,4,3], [1,1,6], [1,5,2], [1,5,3]. Where the 7th sum is 9.
//https://leetcode.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/
//O(m * n * k * logk)
fun main(args: Array<String>) {
    var sum = kthSmallest(arrayOf(intArrayOf(1,3,11), intArrayOf(2,4,6)), 5)
//    var sum = kthSmallest(arrayOf(intArrayOf(1,10,10), intArrayOf(1,4,5), intArrayOf(2,3,6)), 2)
    println(sum)
}

//will need two PQ to get the result
//outer pq will be set to 0, then will add K elements from each row 0, 0+1 0+10 0+10, 0+1+1, 0+1+4, 0+1+5
//inner pq will add next row elements to items in the pq
// get item from PQ and

   // 1 3 11
   // 2 4 6

fun kthSmallest(mat: Array<IntArray>, k:Int): Int{
    val col = Math.min(mat[0].size, k)
    var pq: PriorityQueue<Int> = PriorityQueue(Collections.reverseOrder())  //descending order
    pq.add(0)
    for (row:IntArray in mat) {
        // max priority queue for the i-th row
        val nextPq: PriorityQueue<Int> = PriorityQueue(Collections.reverseOrder())
        for (i in pq) {
            for (c in 0 until col) {
                nextPq.add(i + row[c])  //1,3,11
                // keep pq size <= k
                if (nextPq.size > k) {
                    nextPq.poll()
                }
            }
        }
        pq = nextPq
    }
    return pq.poll()
}