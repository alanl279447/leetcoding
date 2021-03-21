package com.example.TreesAndGraph

import java.util.*

//Input: grid = [[1,1,1,1],[2,2,2,2],[1,1,1,1],[2,2,2,2]]
//Output: 3
//Explanation: You will start at point (0, 0).
//The path to (3, 3) is as follows. (0, 0) --> (0, 1) --> (0, 2) --> (0, 3) change the arrow to down with cost = 1 --> (1, 3) --> (1, 2) --> (1, 1) --> (1, 0) change the arrow to down with cost = 1 --> (2, 0) --> (2, 1) --> (2, 2) --> (2, 3) change the arrow to down with cost = 1 --> (3, 3)
//The total cost = 3.
//https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/

fun main (args: Array<String>) {
//    println(minCost())
}

var dirs: Array<IntArray> = arrayOf(intArrayOf(1,0), intArrayOf(-1,0), intArrayOf(0,-1), intArrayOf(0,1))
fun minCost(grid: Array<IntArray>): Int {
    if (grid == null || grid.size == 0) return 0
    var seen: Array<BooleanArray> = Array(grid.size){ BooleanArray(grid[0].size) }
    var queue: Deque<IntArray> = ArrayDeque()
    dfs(grid, queue, seen, 0,0)

    var steps = 0
    while (!queue.isEmpty()) {
       var size  = queue.size
       for (i in 0..size) {
           val currPos = queue.removeFirst()
           if (currPos[0] == grid.size - 1 && currPos[1] == grid[0].size - 1) {
               return steps
           }
           // Make a step into unseen neighbouring positions.
           // Make a step into unseen neighbouring positions.
           for (currDir in dirs) {
               val newRow = currPos[0] + currDir[0]
               val newCol = currPos[1] + currDir[1]
               if (0 <= newRow && newRow < grid.size && 0 <= newCol && newCol < grid[0].size && !seen[newRow][newCol]) {
                   dfs(grid, queue, seen, newRow, newCol)
               }
           }
       }
       steps++
    }
    return steps
}

fun dfs(grid: Array<IntArray>, queue: Deque<IntArray>, seen: Array<BooleanArray>, row:Int, col:Int) {
    if (row < 0 || row >= grid.size || col < 0 || col >= grid[0].size || seen[row][col]) return
    queue.addLast(intArrayOf(row,col))
    seen[row][col]=true
    var nextIndex = grid[row][col]-1
    var newRow = dirs[nextIndex][0]; var newCol = dirs[nextIndex][1]
    dfs(grid, queue, seen, newRow, newCol)
}
