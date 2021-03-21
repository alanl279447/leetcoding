package com.example.ArrayStrings

import javafx.scene.layout.Priority
import java.util.*
import kotlin.Comparator
import kotlin.math.max

//Input: clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
//Output: 3
//Explanation:
//We take the clips [0,2], [8,10], [1,9]; a total of 3 clips.
//Then, we can reconstruct the sporting event as follows:
//We cut [1,9] into segments [1,2] + [2,8] + [8,9].
//Now we have segments [0,2] + [2,8] + [8,10] which cover the sporting event [0, 10].
//https://leetcode.com/problems/video-stitching/

fun main (args: Array<String>) {
    println(videoStitching(arrayOf(intArrayOf(0,2),intArrayOf(4,6),intArrayOf(8,10),
            intArrayOf(1,9), intArrayOf(1,5),intArrayOf(5,9)), 10))
}
fun videoStitching(clips: Array<IntArray>, T: Int): Int {
    clips.sortWith(Comparator<IntArray?>{a,b->a?.get(0)!! - b?.get(0)!! })
    var i = 0 // clips index
    var maxReach = 0 // max time reachable by clips
    var cnt = 0 // number of clips needed
    while (maxReach < T) {
        var currentMaxReach = 0
        while (i < clips.size && clips[i][0] <= maxReach){
            currentMaxReach = Math.max(currentMaxReach, clips[i++][1])
        }
        if (currentMaxReach <= maxReach) return -1 // can't reach further
        maxReach = currentMaxReach
        cnt++ // need an additional clip to reach new maxReach
    }
    return cnt
}