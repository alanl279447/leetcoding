package com.example.Kotlin

fun main (args: Array<String>) {
    val nums1 = intArrayOf(37, 23, 60)
    val nums2 = intArrayOf(10, 50, 90, 30)
    val nums3 = intArrayOf(30, 20, 150, 100, 40)
    val nums4 = intArrayOf(60, 60, 60)
    println(getSongPairCount(nums1))
    println(getSongPairCount(nums2))
    println(getSongPairCount(nums3))
    println(getSongPairCount(nums4))

}

fun getSongPairCount(songs: IntArray): Int {
    var map : HashMap<Int, Int> = HashMap<Int, Int>()
    var result = 0
    for (n in songs) {
        var temp = n % 60
        var entry = if (60-temp==60) 0 else 60-temp
        if (map.containsKey(entry)) {
            result += map.getOrDefault(entry, 0)
        }
        map.put(temp, map.getOrDefault(temp, 0)+1)
    }
    return result
}