package com.example.Kotlin

import java.util.*

// 3
/// \
//9  20
//  /  \
// 15   7
//
//There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
//https://leetcode.com/problems/sum-of-left-leaves/

lateinit var root: TreeNode
fun main (args: Array<String>) {
    addNode()
    println(sumOfLeftLeaves(root))
}

fun sumOfLeftLeaves(root: TreeNode?): Int {
    if (root == null) return 0
    var queue = ArrayDeque<TreeNode>()
    queue.offer(root)
    var sum = 0

    while(!queue.isEmpty()) {
      var curr = queue.pollLast()
      if (curr.left != null) {
          if (curr.left?.left == null && curr.left?.right == null) {
               sum += curr.left?.`val`!!
          } else {
              queue.offer(curr.left)
          }
      }
      if (curr.right != null) {
          if (curr.right?.left != null || curr.right?.right != null) {
              queue.offer(curr.right)
          }
      }
    }
      return sum
}


fun addNode() {
    root = TreeNode(3)
    root.left = TreeNode(9)

    root.right = TreeNode(20)
    root.right?.left = TreeNode(15)
    root.right?.right = TreeNode(7)
}

class TreeNode (var `val`:Int) {
    var left:TreeNode? = null
    var right: TreeNode? = null
}