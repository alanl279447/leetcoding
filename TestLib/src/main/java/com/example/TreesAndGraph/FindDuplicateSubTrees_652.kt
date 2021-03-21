package com.example.TreesAndGraph

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

    fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode?> {
       map = HashMap()
       countMap = HashMap()
       result = ArrayList()
       countInner(root)
       return result
    }

    fun countInner(node: TreeNode?):Int {
      if (node == null) return 0
      var value:String = node.`val`.toString() +"," +countInner(node.leftNode) + ","+countInner(node.rightNode)
      var uid = map.computeIfAbsent(value, {value->t++})
      countMap.put(uid, countMap.getOrDefault(uid, 0)+1)
      if (countMap.get(uid)==2) {
          result.add(node)
      }
      return uid
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