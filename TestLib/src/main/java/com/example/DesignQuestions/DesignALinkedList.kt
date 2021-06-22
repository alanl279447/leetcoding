package com.example.DesignQuestions

import java.util.*

//    MyHashMap hashMap = new MyHashMap();
//hashMap.put(1, 1);
//hashMap.put(2, 2);
//hashMap.get(1);            // returns 1
//hashMap.get(3);            // returns -1 (not found)
//hashMap.put(2, 1);          // update the existing value
//hashMap.get(2);            // returns 1
//hashMap.remove(2);          // remove the mapping for 2
//hashMap.get(2);            // returns -1 (not found)
//    https://leetcode.com/problems/design-hashmap/
//Time complexity: O(1) average and O(n) worst case - for all get(),put() and remove() methods.
//    Space complexity: O(n) - where n is the number of entries in HashMap

fun main(args: Array<String>) {
    val list: LinkedList<String> = LinkedList()
    list.add("1")
    list.add("2")
    list.add("3")
    list.add("4")
//    System.out.println("size: " + list.size())
//    System.out.println("got 2: " + list.get(2))
//    System.out.println("removed 3: " + list.remove(3))
//    System.out.println("size: " + list.size())

}

/**
Create a Linked List (not double linked list)
methods add(item), remove(index), get(index), size()
 **/

class LinkedListTest<E> {

    var headPtr: Node<E>?
    var currPtr: Node<E>?
    var size: Int

    init {
        headPtr = null
        currPtr = null
        size = 0
    }

    fun add(item: E) {
        if (currPtr == null) {
            currPtr = Node(item)
        }
        if (headPtr == null) headPtr = currPtr
        currPtr = currPtr?.nextPtr
        size++
    }

    fun remove(index: Int):Node<E>? {
        var temp = headPtr
        if (index < 0 || index > size) return null
        var i = index

        while (temp != null && i-->1) {
            temp = temp.nextPtr
        }

        var res = temp?.nextPtr
        if (temp?.nextPtr != null) {
            temp.nextPtr = temp.nextPtr?.nextPtr;
            size--
        }
        return res
    }

//    fun get(index: Int): Node<E>? {
//       if (index < 0 || index > size)
//
//    }




    class Node<E>(value: E) {
        var `val`: E
        var nextPtr: Node<E>?

        init {
            `val` = value
            nextPtr = null
        }
    }
}