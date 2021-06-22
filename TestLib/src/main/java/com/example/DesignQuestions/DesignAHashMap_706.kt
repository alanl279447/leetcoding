package com.example.DesignQuestions

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

    var myHashMap = MyHashMap()
    myHashMap.put(1, 1)
    myHashMap.put(2, 2)
    myHashMap.get(1) // returns 1
    myHashMap.get(3) // returns -1 (not found)
    myHashMap.put(2, 1) // update the existing value
    myHashMap.get(2) // returns 1
    myHashMap.remove(2) // remove the mapping for
    myHashMap.get(2)
}

class MyHashMap() {
    var ListNodes = arrayOfNulls<LinkedList<Int, Int>>(10001)
    /** Initialize your data structure here. */
    class LinkedList<E, V>(key: E, value: V) {
         var nextPtr:LinkedList<E, V>? = null
         var key = key
         var value = value
    }

    /** value will always be non-negative. */
    fun put(key: Int, value: Int) {
          var idx = getId(key)
          if (ListNodes[idx] == null) {
            ListNodes[idx] = LinkedList(-1, -1)
          }
          var prev = find(ListNodes[idx]!!, key)
          if (prev.nextPtr == null) {
              prev.nextPtr = LinkedList(key, value)
          } else {
              prev.nextPtr!!.value = value
          }
    }

    fun find(bucket:LinkedList<Int,Int>, key: Int): LinkedList<Int,Int> {
          var node = bucket; var prev:LinkedList<Int, Int>? = null
          while (node != null && node.key != key) {
              prev = node
              node = node.nextPtr!!
          }
         return prev!!
    }


    fun getId(key: Int) : Int {
      return Integer.hashCode(key)%ListNodes.size
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    fun get(key: Int): Int {
        var idx = getId(key)
        if (ListNodes[idx] != null) {
            var prev = find(ListNodes[idx]!!, key)
            if (prev.nextPtr!= null) {
                return prev.nextPtr!!.value;
            }
        }
        return -1
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    fun remove(key: Int) {

    }
}