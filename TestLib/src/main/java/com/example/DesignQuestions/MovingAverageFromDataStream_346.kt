    package com.example.DesignQuestions

import java.util.*

//MovingAverage m = new MovingAverage(3);
//m.next(1) = 1
//m.next(10) = (1 + 10) / 2
//m.next(3) = (1 + 10 + 3) / 3
//m.next(5) = (10 + 3 + 5) / 3
//https://leetcode.com/problems/moving-average-from-data-stream/
fun main(args: Array<String>) {
   var movingObj = MovingAverage(3)
   movingObj.next(1)
   movingObj.next(10)
   movingObj.next(3)
   movingObj.next(5)
}

class MovingAverage(size: Int) {
    var queue: Queue<Int>
    var capacity = 0
    var sum:Double = 0.0

    init {
        queue = LinkedList()
        capacity = size
        sum = 0.0
    }

    fun next(`val`: Int): Double {
        if(queue.size == capacity) {
            sum -= queue.poll()
        }
        queue.offer(`val`)
        sum += `val`
        return sum/queue.size
    }
}