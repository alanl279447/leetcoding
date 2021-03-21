package com.example.ArrayStrings

import java.util.*

//Input: citations = [3,0,6,1,5]
//Output: 3
//Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
//received 3, 0, 6, 1, 5 citations respectively.
//Since the researcher has 3 papers with at least 3 citations each and the remaining
//two with no more than 3 citations each, her h-index is 3.
//https://leetcode.com/problems/h-index/

fun main (args: Array<String>) {
    println(hIndexSort(intArrayOf(3,0,6,1,5)))
}

//0,1,3,5,6
fun hIndexSort(citations: IntArray): Int {
    Arrays.sort(citations)
    // finding h-index by linear search
    // finding h-index by linear search
    var i = 0
    while (i < citations.size && citations[citations.size - 1 - i] > i) {
        i++
    }
    return i // after the while loop, i = i' + 1
}

//nums [0,2,0,0,0,3]
//sums  [0,5,3,3,3,3]
//inidex 0,1,2,3,4,5
fun hIndex(citations: IntArray): Int {
    val n: Int = citations.size
    val papers = IntArray(n + 1)
    // counting papers for each citation number
    for (c in citations) papers[Math.min(n, c)]++
    // finding the h-index
    var sum = 0
    for (i in papers.size-1 downTo 0) {
        sum += papers[i]
        if (sum >=i) return i
    }
    return 0
}