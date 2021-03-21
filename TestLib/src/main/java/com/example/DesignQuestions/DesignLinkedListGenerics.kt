package com.example.DesignQuestions;

/**
 Create a Linked List (not double linked list)
 methods add(item), remove(index), get(index), size()
 **/

class DesignLinkedListGenerics {
    fun main(args: Array<String>) {

    }

    class LinkedList<E>() {
        var headPtr:Node<E>?
        var size:Int

        init {
            headPtr = null
            size = 0
        }

        fun add(item: E) {
            if (headPtr==null) {
                headPtr = Node(item)
            } else {
               var temp = headPtr
                while (temp?.nextPtr != null) {
                    temp = temp.nextPtr
                }
                var node = Node(item)
                temp?.nextPtr = node
            }
            size++
        }

        fun remove(index: Int): Boolean {
           if (index < 0 || index > size)  return false
           var temp = headPtr
           var i = 0
           while (i < index-1 && temp != null) {
               temp = temp.nextPtr
           }
           if (temp != null && temp.nextPtr!= null)
              temp.nextPtr = temp?.nextPtr?.nextPtr
            return true
        }

        class Node<E>(value: E) {
            var nextPtr: Node<E>?=null
        }
    }

}