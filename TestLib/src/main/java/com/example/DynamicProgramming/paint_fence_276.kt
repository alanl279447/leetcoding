package com.example.DynamicProgramming

//Input: n = 3, k = 2
//Output: 6
//Explanation: Take c1 as color 1, c2 as color 2. All possible ways are:
//post1  post2  post3
//-----      -----  -----  -----
//1         c1     c1     c2
//2         c1     c2     c1
//3         c1     c2     c2
//4         c2     c1     c1
//5         c2     c1     c2
//6         c2     c2     c1
//https://leetcode.com/problems/paint-fence/
//https://leetcode.com/problems/paint-fence/discuss/178010/The-only-solution-you-need-to-read
//paint all the posts such that no more than two adjacent fence posts have the same color.

fun main (args: Array<String>) {
    println(minCost(arrayOf(intArrayOf(17,2,17), intArrayOf(16,16,5), intArrayOf(14,3,19))))
}

fun numWays(n: Int, k: Int): Int {
    // if there are no posts, there are no ways to paint them
    // if there are no posts, there are no ways to paint them
    if (n === 0) return 0

    // if there is only one post, there are k ways to paint it

    // if there is only one post, there are k ways to paint it
    if (n === 1) return k

    // if there are only two posts, you can't make a triplet, so you
    // are free to paint however you want.
    // first post, k options. second post, k options

    // if there are only two posts, you can't make a triplet, so you
    // are free to paint however you want.
    // first post, k options. second post, k options
    if (n === 2) return k * k

    val table = IntArray(n + 1)
    table[0] = 0
    table[1] = k
    table[2] = k * k
    for (i in 3..n) {
        // the recursive formula that we derived
        table[i] = (table[i - 1] + table[i - 2]) * (k - 1)
    }
    return table[n]
}