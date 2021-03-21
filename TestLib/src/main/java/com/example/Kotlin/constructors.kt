package com.example.Kotlin

import java.util.*


fun main (args: Array<String>) {
    //val person1 = PersonTest("joe", 25)
    var head = ListNode(1)
    head.nextNode = ListNode(2)
    head.nextNode?.nextNode = ListNode(3)
    head.nextNode?.nextNode?.nextNode = ListNode(4)
}

class solution(var head: ListNode) {

    var node:ListNode?
    var random: Random
    init {
        node = head
        random = Random()
    }

    fun getRandom(): Int? {
         var c = node
        val c1 = c
        var r = c1?.value

        var i = 0
        while(c?.nextNode != null) {
            c = c.nextNode
            if (random.nextInt(i+1) == i) {
              r = c?.value
          }
        }
        return r
    }
}

class ListNode (var value: Int) {
    var nextNode: ListNode? = null
}


//class PersonTest(fName: String, personAge: Int) {
//    val firstName: String
//    var age: Int
//
//    // initializer block
//    init {
//        firstName = fName.capitalize()
//        age = personAge
//
//        println("First Name = $firstName")
//        println("Age = $age")
//    }
//}