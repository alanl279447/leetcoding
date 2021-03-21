package com.example.Kotlin

//    Input:
//    routes = [[1, 2, 7], [3, 6, 7]]
//    S = 1
//    T = 6
//    Output: 2
//    Explanation:
//    The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
//    https://leetcode.com/problems/bus-routes/
class BinaryTreeCameras_968 {



    fun main(args: Array<String>) {
        println(numBusesToDestination(arrayOf(intArrayOf(1, 2, 7), intArrayOf(3, 6, 7)), 1, 6))
    }

    //    Input:
//
//              1
//            /   \
//           2     3
//            \
//            5
//    Output: ["1->2->5", "1->3"]
//
//    Explanation: All root-to-leaf paths are: 1->2->5, 1->3
//    https://leetcode.com/problems/binary-tree-paths/

    var ans = 0
    var covered: HashSet<TreeNode?>  = HashSet()
    fun minCameraCover(root: TreeNode?): Int {
        ans = 0
        covered.add(null)
        dfs(root, null)
        return ans
    }

    fun dfs(node: TreeNode?, par: TreeNode?) {
        if (node != null) {
            dfs(node.left, node)
            dfs(node.right, node)
            if (par == null && !covered!!.contains(node) ||
                    !covered!!.contains(node.left) ||
                    !covered!!.contains(node.right)) {
                ans++
                covered!!.add(node)
                covered!!.add(par)
                covered!!.add(node.left)
                covered!!.add(node.right)
            }
        }
    }

    fun addNode(value: Int) {
//        root = TreeNode(value)
//        root?.left = TreeNode(2)
//        root?.left?.right =  TreeNode(5)
//        root?.left?.right?.left =TreeNode(4)
//        root?.left?.right?.right = TreeNode(6)
//        root?.right = TreeNode(3)
    }

    class TreeNode internal constructor(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null

    }
}