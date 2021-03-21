package com.example.DesignQuestions

import java.util.*
import kotlin.collections.HashMap

//Input:
//["Leaderboard","addScore","addScore","addScore","addScore","addScore","top","reset","reset","addScore","top"]
//[[],[1,73],[2,56],[3,39],[4,51],[5,4],[1],[1],[2],[2,51],[3]]
//Output:
//[null,null,null,null,null,null,73,null,null,null,141]
//
//Explanation:
//Leaderboard leaderboard = new Leaderboard ();
//leaderboard.addScore(1,73);   // leaderboard = [[1,73]];
//leaderboard.addScore(2,56);   // leaderboard = [[1,73],[2,56]];
//leaderboard.addScore(3,39);   // leaderboard = [[1,73],[2,56],[3,39]];
//leaderboard.addScore(4,51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
//leaderboard.addScore(5,4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
//leaderboard.top(1);           // returns 73;
//leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
//leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
//leaderboard.addScore(2,51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
//leaderboard.top(3);           // returns 141 = 51 + 51 + 39;
//https://leetcode.com/problems/design-a-leaderboard/

fun main(args: Array<String>) {

    var obj = Leaderboard()
    obj.addScore(1,73)
    obj.addScore(2,56)
    obj.addScore(3,39)
    obj.addScore(4,51)
    obj.addScore(5,91)
    var param_2 = obj.top(1)   //91
    System.out.println(param_2)
    obj.reset(5)   //remove 5
    var param_3 = obj.top(1)
    System.out.println(param_3)
}

internal class Leaderboard {
    var map: MutableMap<Int, Int>
    var sorted: TreeMap<Int, Int>
    fun addScore(playerId: Int, score: Int) {
        if (!map.containsKey(playerId)) {
            map[playerId] = score
            sorted.put(score, sorted.getOrDefault(score, 0) + 1)
        } else {
            val preScore = map[playerId]!!
            sorted.put(preScore, sorted.getOrDefault(preScore, 0) - 1)
            if (sorted.get(preScore) === 0) {
                sorted.remove(preScore)
            }
            val newScore = preScore + score
            map[playerId] = newScore
            sorted.put(newScore, sorted.getOrDefault(newScore, 0) + 1)
        }
    }

    //O(klogn)
    fun top(K: Int): Int {
        var count = 0
        var sum = 0
        for (key in sorted.keys) {
            val times: Int = sorted.get(key)!!
            for (i in 0 until times) {
                sum = sum + key
                count++
                if (count == K) {
                    break
                }
            }
            if (count == K) {
                break
            }
        }
        return sum
    }

    // O(log n),
    fun reset(playerId: Int) {
        val preScore = map[playerId]!!
        sorted.put(preScore, sorted.get(preScore - 1)!!)
        if (sorted.get(preScore) === 0) {
            sorted.remove(preScore)
        }
        map.remove(playerId)
    }

    init {
        map = HashMap()
        sorted = TreeMap(Collections.reverseOrder())
    }
}