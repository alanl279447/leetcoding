package com.example.ArrayStrings


//Input: arr = [15,88], pieces = [[88],[15]]
//Output: true
//Explanation: Concatenate [15] then [88]
//
//Input: arr = [49,18,16], pieces = [[16,18,49]]
//Output: false
//Explanation: Even though the numbers match, we cannot reorder pieces[0].
//https://leetcode.com/problems/check-array-formation-through-concatenation/

fun main (args: Array<String>) {
    println(canFormArray(intArrayOf(15,88), arrayOf(intArrayOf(88), intArrayOf(15))))
}

// hashMap with key as first piece and value as the list
// check is all the pieces are in place
// check if we can traverse the entire arr
// 88, 88   15,15
fun canFormArray(arr: IntArray, pieces: Array<IntArray>): Boolean {
    val n = arr.size
    // initialize hashmap
    val mapping: MutableMap<Int, IntArray> = HashMap()
    for (p in pieces) {
        mapping[p[0]] = p
    }

    var i = 0
    while (i < n) {
        // find target piece
        if (!mapping.containsKey(arr[i])) {
            return false
        }
        // check target piece
        val targetPiece = mapping[arr[i]]
        for (x in targetPiece!!) {
            if (x != arr[i]) {
                return false
            }
            i++
        }
    }
    return true
}