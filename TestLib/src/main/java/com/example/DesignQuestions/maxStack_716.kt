package com.example.DesignQuestions

import java.util.*
import kotlin.collections.ArrayList

//Explanation
//MaxStack stk = new MaxStack();
//stk.push(5);   // [5] the top of the stack and the maximum number is 5.
//stk.push(1);   // [5, 1] the top of the stack is 1, but the maximum is 5.
//stk.push(5);   // [5, 1, 5] the top of the stack is 5, which is also the maximum, because it is the top most one.
//stk.top();     // return 5, [5, 1, 5] the stack did not change.
//stk.popMax();  // return 5, [5, 1] the stack is changed now, and the top is different from the max.
//stk.top();     // return 1, [5, 1] the stack did not change.
//stk.peekMax(); // return 5, [5, 1] the stack did not change.
//stk.pop();     // return 1, [5] the top of the stack and the max element is now 5.
//stk.top();     // return 5, [5] the stack did not change.
//https://leetcode.com/problems/max-stack/

fun main(args: Array<String>) {
    var obj = MaxStack()
    obj.push(5)
    obj.push(1)
    obj.push(5)
    var top = obj.pop()
    var popMax1 = obj.popMax()
    var top2 = obj.pop()
    var peekMax1 = obj.peekMax()

     var param_2 = obj.pop()
     var param_3 = obj.top()
     var param_4 = obj.peekMax()
     var param_5 = obj.popMax()
}



class MaxStack {
    class Node {
        var prev: Node? = null
        var next: Node?=null
        var value = 0
        constructor(`val`:Int) {
            value = `val`
        }
    }
    class DoubleLinkedList {
        var head: Node?=null
        var tail: Node?=null

        init {
            head = Node(0)
            tail = Node(0)
            head?.next = tail
            tail?.prev = head
        }

        fun addNode(value: Int):Node {
            var node = Node(value)
            node.next = tail
            node.prev = tail?.prev
            tail?.prev?.next = node
            tail?.prev = node
            return node
        }

        fun pop():Int {
            return deleteNode(tail?.prev!!)!!.value
        }

        fun peek(): Int {
           return tail?.prev!!.value
        }

        fun deleteNode(node: Node?) :Node? {
            if (node == null) return null
            node.prev?.next = node.next
            node.next?.prev = node.prev
            return node
        }
    }

    var ddl: DoubleLinkedList
    var treeMap:TreeMap<Int, ArrayList<Node>>
    init {
        ddl = DoubleLinkedList()
        treeMap = TreeMap<Int, ArrayList<Node>>()
    }

    fun push(x: Int) {
        var node = ddl.addNode(x)
        if (!treeMap.containsKey(x)) {
            treeMap.put(x, ArrayList())
        }
        treeMap.get(x)?.add(node)
    }

    fun pop(): Int {
       var node = ddl.pop()
       if (treeMap.containsKey(node)) {
           var list = treeMap.get(node)
           list?.removeAt(list.size-1)
           if (list.isNullOrEmpty()) {
               treeMap.remove(node)
           }
       }
       return node
    }

    fun top(): Int {
        return ddl.peek()
    }

    fun peekMax(): Int {
        return treeMap.lastKey()
    }

    fun popMax(): Int {
        var key = peekMax()
        var list = treeMap.get(key)
        var node: Node ?= list?.removeAt(list.size-1)
        ddl.deleteNode(node)
        if (list?.isEmpty()!!)  {
            treeMap.remove(node?.value)
        }
        return key
    }

}