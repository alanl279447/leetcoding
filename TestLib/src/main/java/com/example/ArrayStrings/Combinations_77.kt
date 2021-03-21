package com.example.ArrayStrings;


//public class Combinations_77 {

//    Input: n = 4, k = 2
//    Output:[
//    [2,4],
//    [3,4],
//    [2,3],
//    [1,2],
//    [1,3],
//    [1,4],]
//    https://leetcode.com/problems/combinations/

//Time complexity is n!/(n-k)!
// For example, if n = 4, k = 4, then there's 24 combinations.
// But if n = 4, k = 0, there's 0 combinations. If n = 4, k = 1, there's 4 combinations.

fun main(args: Array<String>) {

}

//backtracking from 1 to n in k steps
fun combine(n:Int, k:Int):MutableList<MutableList<Int>> {
    val combs: MutableList<MutableList<Int>> = ArrayList()
    helper(combs, mutableListOf<Int>(), 1, n, k)
    return combs
}

fun helper(combs: MutableList<MutableList<Int>>, comb: MutableList<Int>, start:Int, n:Int, k:Int) {
     if (k == 0) {
         combs.add(ArrayList(comb))
         return
     }
     for (i in start..n) {
         comb.add(i)
         helper(combs, comb, i+1, n, k-1)
         comb.removeAt(comb.size-1)
     }


}

