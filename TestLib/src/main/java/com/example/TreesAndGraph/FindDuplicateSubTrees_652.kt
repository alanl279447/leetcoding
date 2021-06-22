package com.example.TreesAndGraph

import java.util.*
import kotlin.collections.HashMap

//Input: root = [1,2,3,4,null,2,4,null,null,4]
//Output: [[2,4],[4]]
//https://leetcode.com/problems/find-duplicate-subtrees/

class FindDuplicateSubTrees_652 {
    lateinit var root:TreeNode
    lateinit var map:HashMap<String, Int>
    lateinit var countMap:HashMap<Int, Int>
    lateinit var result:ArrayList<TreeNode>
    var t = 0

    fun main(args: Array<String>) {
        addNode(1)
        var result = findDuplicateSubtrees(root)
        for (res in result) {
            System.out.println(res)
        }
    }
    companion object {
        var curId = 1
    }

    //map(String, Int)
    //map(Int, Int)

    fun findDuplicateSubtrees(root: TreeNode): List<TreeNode> {
        val serialToId: MutableMap<String, Int> = HashMap()
        val idToCount: MutableMap<Int, Int> = HashMap()
        val res: MutableList<TreeNode> = LinkedList()
        postorder(root, serialToId, idToCount, res)
        return res
    }

    private fun postorder(root: TreeNode, serialToId: MutableMap<String, Int>, idToCount: MutableMap<Int, Int>, res: MutableList<TreeNode>): Int {
        if (root == null) return 0
        val leftId = postorder(root.leftNode!!, serialToId, idToCount, res)
        val rightId = postorder(root.rightNode!!, serialToId, idToCount, res)
        val curSerial = leftId.toString() + "," + root.`val` + "," + rightId
        val serialId = serialToId.getOrDefault(curSerial, curId)
        if (serialId == curId) curId++
        serialToId[curSerial] = serialId
        idToCount[serialId] = idToCount.getOrDefault(serialId, 0) + 1
        if (idToCount[serialId] == 2) res.add(root)
        return serialId
    }

    fun addNode(value: Int) {
        root = TreeNode(value)
        root.leftNode = TreeNode(2)
        root.leftNode?.leftNode = TreeNode(4)

        root.rightNode = TreeNode(3)
        root.rightNode?.rightNode = TreeNode(4)
        root.rightNode?.leftNode = TreeNode(2)
        root.rightNode?.leftNode?.leftNode = TreeNode(4)
    }


    class TreeNode {
       var `val`:Int
       var leftNode: TreeNode? = null
       var rightNode: TreeNode? = null

        constructor(`val`:Int) {
            this.`val` = `val`
        }
    }
}