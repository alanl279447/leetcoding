package com.example.TreesAndGraph

import java.util.*
import kotlin.collections.HashMap

//Input:
//
//      5
//    /   \
//   4     5
//  / \   / \
// 1   1 6   5
//Input: root = [5,4,5,1,1,5]
//Output: 2
//https://leetcode.com/problems/longest-univalue-path/
//The length of the path between two nodes is represented by the number of edges between them.

class LongestUnivaluePath_687 {
    var root: TreeNode? = null

    fun main(args: Array<String>) {
        addNode(5)
        var length = longestUnivaluePath(root)
        println(root?.input)
    }

    var maxPath = 0
    fun longestUnivaluePath(root: TreeNode?): Int {
       findLongestPath(root, -1)
       return maxPath
    }

    fun findLongestPath(node: TreeNode?, prevVal: Int):Int {
        var count = 0
        if (node == null) return count
        var leftMax = findLongestPath(node.left, node.value)
        var rightMax = findLongestPath(node.right, node.value)
        maxPath = Math.max(maxPath, leftMax+rightMax)

        if (node.value == prevVal) {
            count = 1 + Math.max(leftMax, rightMax)
        }
        return count
    }

    fun addNode(value: Int) {
        root = TreeNode(value)
        root?.left = TreeNode(4)
        root?.right = TreeNode(5)
        root?.left?.left = TreeNode(1)
        root?.left?.right = TreeNode(1)
//        root?.right?.left = TreeNode(6)
        root?.right?.right = TreeNode(5)
    }

    class TreeNode internal constructor(var input: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
        var value = input
    }
}