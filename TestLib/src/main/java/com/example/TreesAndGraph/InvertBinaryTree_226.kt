package com.example.TreesAndGraph

import java.util.*

//Input:
//
//      4
//    /   \
//   2     7
//  / \   / \
// 1   3 6   9
//Output:
//
//      4
//    /   \
//   7     2
//  / \   / \
// 9   6 3   1
//https://leetcode.com/problems/invert-binary-tree/
// time complexity 0(n)

var root: TreeNode? = null
fun main (args: Array<String>) {
    addNode(4)
    invertTree(root)
    println(root?.input)
}

fun invertTree(root: TreeNode?): TreeNode? {
   var queue:Queue<TreeNode> = ArrayDeque<TreeNode>()
    queue.offer(root)

    while(!queue.isEmpty()) {
        var currNode: TreeNode = queue.poll()

        var tempLeft = currNode.left
        currNode.left = currNode.right
        currNode.right = tempLeft

        if (currNode?.right != null) {
            queue.offer(currNode.right)
        }

        if (currNode?.left != null) {
            queue.offer(currNode.left)
        }
    }
    return root;
}

fun addNode(value: Int) {
    root = TreeNode(value)
    root?.left = TreeNode(2)
    root?.right = TreeNode(7)

    root?.left?.left = TreeNode(1)
    root?.left?.right = TreeNode(3)

    root?.right?.left = TreeNode(6)
    root?.right?.right = TreeNode(9)
}

class TreeNode internal constructor(var input: Int) {
    var left: TreeNode?=null
    var right: TreeNode?=null
}