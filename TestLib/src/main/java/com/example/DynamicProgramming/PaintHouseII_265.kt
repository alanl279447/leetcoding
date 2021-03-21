package com.example.DynamicProgramming

//Input: [[1,5,3],[2,9,4]]
//Output: 5
//Explanation: Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5;
//Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5.

fun main (args: Array<String>) {
    println(minCostII(arrayOf(intArrayOf(1,5,3), intArrayOf(2,9,4))))
}

//To avoid modifying the given parameter, we can apply greedy algorithm.
//That is, instead of recording min cost for painting each house on the given matrix,
//we can use two variables to record so far the total minimal cost min1, and the second total minimal cost min2.
//For each house, we get the total cost and then immediately compare it with curMin1 and curMin2,
//which are the variables representing temporary minimal cost in painting current house.
//Then after trying all possible colors for the current house, we update our min1 and min2.
fun minCostII(costs: Array<IntArray>): Int {
    var min1 = -1; var min2 = -1; var minIndex = -1
    var row = costs.size; var col = costs[0].size
    for (i in 0 until row) {
       var currMin1 = Integer.MAX_VALUE; var currMin2 = Integer.MAX_VALUE; var currIndex = -1
       for (j in 0 until col) {
         var cost = costs[i][j] + if(j ==  minIndex) min2 else min1
         if (cost < currMin1) {
             currMin1 = cost
             currMin2 = currMin1
             currIndex = j
         } else if (cost < currMin2) {
             currMin2 = cost
         }
       }
       min1 = currMin1
       min2 = currMin2
       minIndex = currIndex
    }
    return min1
}