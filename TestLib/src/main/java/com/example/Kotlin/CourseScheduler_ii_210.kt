package com.example.Kotlin

import java.util.*

//    Input: 2, [[1,0]]
//    Output: true
//    Explanation: There are a total of 2 courses to take.
//    To take course 1 you should have finished course 0. So it is possible.

//Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//Output: [0,2,1,3]
//Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
//So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
//    https://leetcode.com/problems/course-schedule-ii/solution/
//  https://leetcode.com/discuss/interview-question/841430/Amazon-interview%3A-Dependency

fun main (args: Array<String>) {
    val items = arrayOf(intArrayOf(1,0), intArrayOf(2,0), intArrayOf(3,1), intArrayOf(3,2));
    val result = findOrder(4, items)
    for (res in result)
       println(res)
}

fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
    var inDegree = IntArray(numCourses) {0}
    for (i in 0 until prerequisites.size) {
        inDegree[prerequisites[i][0]]++;
    }

    var queue:Queue<Int> = LinkedList()
    for (i in 0 until numCourses) {
        if (inDegree[i] == 0) {
            queue.offer(i)
        }
    }

    var result =  IntArray(numCourses){-1}
    var count = 0
    while (!queue.isEmpty()) {
        var index = queue.poll()
        result[count] = index
        for (i in 0 until prerequisites.size) {
            if (prerequisites[i][1] == index) {
                inDegree[prerequisites[i][0]]--

                if (inDegree[prerequisites[i][0]] == 0) {
                    queue.offer(prerequisites[i][0])
                }
            }
        }
        count++
    }
    return result
}