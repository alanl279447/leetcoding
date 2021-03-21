package com.example.ArrayStrings;


//Input: heights = [1,1,4,2,1,3]
//Explanation:
//Current array : [1,1,4,2,1,3]
//Target array  : [1,1,1,2,3,4]
//On index 2 (0-based) we have 4 vs 1 so we have to move this student.
//On index 4 (0-based) we have 1 vs 3 so we have to move this student.
//On index 5 (0-based) we have 3 vs 4 so we have to move this student.
//https://leetcode.com/problems/height-checker/

//class LastSubstringLexicographicalOrder_1163 {
fun main(args: Array<String>) {
    System.out.println(heightChecker(intArrayOf(1,1,4,2,1,3)))
}

//hashMap of index and count
//loop through all heights, and check is currentHt != heights[currentHt]
//fun heightCheckerTest(heights: IntArray): Int {
////
////}


//0,3,1,1,1
fun heightChecker(heights: IntArray): Int {
    val heightToFreq = IntArray(101)
    for (height in heights) {
        heightToFreq[height]++
    }
    var result = 0
    var curHeight = 0
    for (i in 0 until heights.size) {
        while (heightToFreq[curHeight] == 0) {
            curHeight++
        }
        if (curHeight != heights[i]) {
            result++
        }
        heightToFreq[curHeight]--
    }
    return result
}
//}