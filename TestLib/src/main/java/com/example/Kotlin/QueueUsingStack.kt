package com.example.Kotlin

import java.util.*

//MyQueue queue = new MyQueue();
//queue.push(1);
//queue.push(2);
//queue.peek();  // returns 1
//queue.pop();   // returns 1
//queue.empty(); // returns false

fun main (args: Array<String>) {
    var queue = MyQueue()
    queue.push(1)
    queue.push(2)

    println(queue.peek())     //1
    println(queue.pop())      //1
    println(queue.isEmpty())
}

class MyQueue() {
    var inputStack: Deque<Int>
    var outputStack: Deque<Int>

    init {
       inputStack = ArrayDeque()
       outputStack = ArrayDeque()
    }

    fun push(input: Int) {
        inputStack?.offerLast(input)  //1,2
    }

    fun pop(): Int? {
        peek();
        return outputStack?.pollLast() //1
    }

    fun peek():Int{
        while (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.offerLast(inputStack.pollLast())
            }
        }
        return outputStack.peekLast()
    }

    fun isEmpty():Boolean {
        return inputStack?.isEmpty() && outputStack?.isEmpty()
    }
}
