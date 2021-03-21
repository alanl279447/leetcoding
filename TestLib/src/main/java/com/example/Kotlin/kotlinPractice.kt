package com.example.Kotlin

import javafx.util.Pair
import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

var stack1: MutableList<Char> = mutableListOf()

fun main (args: Array<String>) {
//    enqueue('a')
//    enqueue('b')
//    enqueue('c')
//    System.out.println(dequeue())
//    enqueue('d')
//    System.out.println(dequeue())
//
//    val list = mutableListOf(0,1,2,3)
//    list.swap(0,2)
//
//    var item: Array<String> = arrayOf("green", "red", "blue")
//    for (i in item) {
//    }
//    System.out.println(slowestKeyPress(intArrayOf(1,2,3,4,5,6), intArrayOf(1, 3, 5, 8, 19, 65)))
//    System.out.println(minimumDivisor(intArrayOf(1,5,7), 8))

    val al: ArrayList<Int> = arrayListOf(1,2,4,3)
    al.swap(2,3)
}


fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
//        System.arraycopy(nums2,0,nums1,m,n);
//        Arrays.sort(nums1);
    var p1 = m - 1
    var p2 = n - 1
    var p = m + n - 1
    while (p1 >= 0 && p2 >= 0) {
        nums1[p--] = if (nums1[p1] > nums2[p2]) nums1[p1--] else nums2[p2--]
    }
    System.arraycopy(nums2, 0, nums1, 0, p2 + 1)
}

fun permuteTest(nums: IntArray): List<List<Int>> {
    var result = ArrayList<List<Int>>()
    backTracking(result, ArrayList<Int>(), nums, 0);
    return result
}

fun backTracking(result: ArrayList<List<Int>>, temp: ArrayList<Int>, nums: IntArray, start:Int) {
    if (temp.size == nums.size) {
        result.add(ArrayList<Int>(temp))
    } else {
        for (i in start until nums.size) {
            temp.add(nums[start])
            backTracking(result, temp, nums, start+1)
            temp.remove(temp.size-1)
        }


    }


}


fun sumNumbers(root: TreeNode): Int {
    if (root == null) return 0
    var rootToLeafSum = 0
    val stack: Deque<Pair<TreeNode?, Int>> = ArrayDeque()
    stack.offer(Pair(root, 0))
    while (!stack.isEmpty()) {
        val p = stack.poll()
        var value = p.value
        val curr = p.key
        value += value * 10 + curr!!.`val`
        if (curr.left == null && curr.right == null) {
            rootToLeafSum += value
        }
        if (curr.left != null) {
            stack.offer(Pair(curr.left, value))
        }
        if (curr.right != null) {
            stack.offer(Pair(curr.right, value))
        }
    }
    return rootToLeafSum
}

fun slowestKeyPress(keys: IntArray, timeStamp: IntArray): Int {
    var len = keys.size
    var maxDiff = Integer.MIN_VALUE
    var prev = 0; var id = -1
    for (i in 0 until keys.size) {
        if (maxDiff < timeStamp[i]-prev) {
            maxDiff = timeStamp[i]-prev
            id = keys[i]
        }
        prev = timeStamp[i]
    }
    return id
}

fun enqueue(input: Char) {
    stack1.add(input)
}

fun dequeue(): Char? {
    if (stack1 != null && stack1.size > 0) {
        return stack1.removeAt(0)
    }
    return null
}

fun MutableList<Int>.swap(index1: Int, index2:Int) {
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}


fun ArrayList<Int>.swap(index1:Int, index2:Int) {
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}


fun topKFrequentWords(prices:Array<String>, target: Int): MutableList<String?> {
    val map: MutableMap<String, Int> = HashMap()

    for (word in prices) {
        map[word] = map.getOrDefault(word, 0) + 1
    }
    val pq = PriorityQueue(Comparator
    { a: String, b: String -> if (map[a] === map[b]) a.compareTo(b) else map[a]!! - map[b]!! })


    val pq1 = PriorityQueue(Comparator {
        a:String, b:String -> if (map[a]==map[b]) a.compareTo(b) else map[a]!!-map[b]!!
    })


    for (word in prices) {
        pq.offer(word)
        if (pq.size > target) {
            pq.poll()
        }
    }

    val result: MutableList<String?> = ArrayList()
    for (item in pq) {
        result.add(item)
    }
    Collections.reverse(result)
    return result
}

fun coinChangeBottomUp(prices: Array<Int>, target: Int) : Int {
    var dp = IntArray(target+1) { i -> target +1}
    dp[0]=0
    for (i in 0..target) {
       for (j in 0..prices.size) {
           if (i > prices[j]) {
               dp[i]=Math.min(dp[i], dp[i-prices[j]]+1)
           }
       }
    }
     return dp[target+1]
}


fun longestPalindromSubString(input: String) : String? {
    if (input == null || input.length==0) {
        return null
    }

    var start = 0; var end = 0
    for (i in 0..input.length-1) {
      val len1 = expandAroundCenter(input, i, i)
      val len2 = expandAroundCenter(input, i, i + 1)
      val len = Math.max(len1, len2)
      if (len > end - start) {
          start = i - (len-1)/2
          end = i + len/2
      }
    }
    return input.substring(start, end+1)
}

fun expandAroundCenter(input: String, start: Int, end: Int): Int {
    var L = start; var R = end;
    while (L>=0 && R < input.length && input[L]==input[R]) {
        L--
        R++
    }
    return R-L-1
}