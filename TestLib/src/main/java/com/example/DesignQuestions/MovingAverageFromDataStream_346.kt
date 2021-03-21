package com.example.DesignQuestions

import java.util.*

//MovingAverage m = new MovingAverage(3);
//m.next(1) = 1
//m.next(10) = (1 + 10) / 2
//m.next(3) = (1 + 10 + 3) / 3
//m.next(5) = (10 + 3 + 5) / 3
//https://leetcode.com/problems/moving-average-from-data-stream/
fun main(args: Array<String>) {
   var movingObj = MovingAverageTest(3)
   movingObj.next(1)
   movingObj.next(10)
   movingObj.next(3)
   movingObj.next(5)
}

class MovingAverageTest {
    var queue: Queue<Int>
    var sum:Int
    var capacity = 0

    constructor(size: Int){
       queue = LinkedList()
       sum = 0
       capacity = size
    }

    fun next(num: Int):Int {
        if(queue.size == capacity) {
            sum -=queue.poll()
        }
        sum += num
        queue.offer(num)
        return sum/queue.size
    }
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