package com.example.TreesAndGraph

import java.util.*

//    You may serialize the following tree:
//
//              1
//             / \
//            2   3
//               / \
//              4   5
//
//    as "[1,2,3,null,null,4,5]"
//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
//class serializeDeserializeBinaryTree_297 {
fun main(args: Array<String>) {
//    var root = TreeNode(1)
    addNode(4)
//        var ser = Codec()
//        var data = ser.serialize(root)
//        var ans = ser.deserialize(data)
    var ser = Codec()
    var data = ser.serialize(root)
    var ans = ser.deserialize(data)
    System.out.println(data)
}

class Codec() {
    // Encodes a URL to a shortened URL.
    var splitter = ","
    var NN = "X"
    fun serialize(root: TreeNode?): String {
        var sb = StringBuilder()
        serializeInner(root, sb)
        return sb.toString()
    }

    fun serializeInner(node: TreeNode?, sb:StringBuilder) {
        if (node == null) {
            sb.append(NN)
        } else {
            sb.append(node.input).append(splitter)
            serializeInner(node.left, sb)
            serializeInner(node.right, sb)
        }
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        var values = data.split(splitter.toRegex())
        var linkedList = LinkedList(values)
        var root =  deserializeInner(linkedList)
        return root
    }

    fun deserializeInner(values: LinkedList<String>):TreeNode? {
        var value = values.removeAt(0)
        if(value == NN) {
            return null
        } else {
            var node = TreeNode(Integer.valueOf(value))
            node.left = deserializeInner(values)
            node.right = deserializeInner(values)
            return node
        }
    }

}
//    class TreeNode {
//        var value: Int
//        var left: TreeNode? = null
//        var right: TreeNode? = null
//
//        constructor(va: Int) {
//            value = va
//        }
//    }
//}