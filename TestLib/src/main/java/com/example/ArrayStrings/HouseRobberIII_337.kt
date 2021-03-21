package com.example.ArrayStrings

//Input: [3,2,3,null,3,null,1]
//3
/// \
//2   3
//\   \
//3   1
//Output: 7
//Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
//https://leetcode.com/problems/house-robber-iii/

class HouseRobberIII_337 {
    var root = TreeNode(3)
    fun main(args: Array<String>) {
        contructTree(root)
        println(robExtraSpace(root))
    }


    fun rob(root: TreeNode) :Int {
        var result = robHelper(root)
        return Math.max(result[0], result[1])
    }

   fun robHelper(node: TreeNode?):IntArray {
       if (node == null) {
           return intArrayOf(0,0)
       }
       var left = robHelper(node.left)
       var right = robHelper(node.right)

       var result = IntArray(2)
       result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1])  // not considering the current node
       result[1] = node.`val` + left[0] + right[0]   //current node + zero of left & right
       return result
   }

    //rob recursive with memoization
    //bottom up find the maximum
    fun robExtraSpace(root: TreeNode?): Int {
       return robSub(root, HashMap())
    }

    fun robSub(node: TreeNode?, map: HashMap<TreeNode, Int>): Int {
       if (node == null) return 0
       if (map.get(node) != null) {
           return map.getOrDefault(node, 0)
       }
       var value = 0
        value  += robSub(node?.left?.left, map)
        value  += robSub(node?.left?.right, map)
        value  += robSub(node?.right?.right, map)
        value  += robSub(node?.right?.left, map)

        value = Math.max(value+node.`val`, robSub(node.left, map)+robSub(node.right, map))
        map.put(node, value)
        return value
    }

    fun contructTree(node: TreeNode) {
        root?.left= TreeNode(4)
        root?.left?.right=TreeNode(3)
        root?.left?.left=TreeNode(1)

        root?.right=TreeNode(5)
        root?.right?.right=TreeNode(1)
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}