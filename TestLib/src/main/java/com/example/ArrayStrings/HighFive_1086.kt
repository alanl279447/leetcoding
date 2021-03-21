package com.example.ArrayStrings;

import java.util.*

class HighFive_1086 {
//    Input: items = [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
//    Output: [[1,87],[2,88]]
//    Explanation:
//    The student with ID = 1 got scores 91, 92, 60, 65, 87, and 100. Their top five average is (100 + 92 + 91 + 87 + 65) / 5 = 87.
//    The student with ID = 2 got scores 93, 97, 77, 100, and 76. Their top five average is (100 + 97 + 93 + 77 + 76) / 5 = 88.6, but with integer division their average converts to 88
//    https://leetcode.com/problems/high-five/
    fun main(args: Array<String>) {
        //System.out.println(highFive();
    }

    fun highFive(items: Array<IntArray>): Array<IntArray> {
        val allScores: TreeMap<Int, Queue<Int>> = TreeMap()
        for (item in items) {
            val id = item[0]
            val score = item[1]
            if (!allScores.containsKey(id)) // max heap
                allScores[id] = PriorityQueue { a, b -> b - a }
            // Add score to the max heap
            allScores[id]!!.add(score)
        }
        var k  = 5
        val solution: ArrayList<IntArray> = ArrayList()
        for (id in allScores.keys) {
            var sum = 0
            // obtain the top k scores (k = 5)
            for (i in 0 until k) sum += allScores[id]!!.poll()
            solution.add(intArrayOf(id, sum/k))
        }
        return solution.toTypedArray()
    }
}