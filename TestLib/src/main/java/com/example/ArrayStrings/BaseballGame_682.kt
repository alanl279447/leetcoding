package com.example.ArrayStrings

import java.util.*

//Input: ops = ["5","2","C","D","+"]
//Output: 30
//Explanation:
//"5" - Add 5 to the record, record is now [5].
//"2" - Add 2 to the record, record is now [5, 2].
//"C" - Invalidate and remove the previous score, record is now [5].
//"D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
//"+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
//The total sum is 5 + 10 + 15 = 30.
//https://leetcode.com/problems/baseball-game/

fun main (args: Array<String>) {
    println(calPoints(arrayOf("5", "2", "C", "D", "+")))
}

fun  calPoints(ops: Array<String>):Int {
    if(ops.isNullOrEmpty()) return 0
    var stack:Deque<Int> = ArrayDeque()
    for (op:String in ops) {
        when(op) {
            "+"-> {
                var top = stack.pop()
                var newTop = top + stack.peek()
                stack.push(top)
                stack.push(newTop)
            }
            "C"-> {
                stack.pop()
            }
            "D"-> {
                stack.push((2 * stack.peek()))
            }
            else -> {
               stack.push(Integer.parseInt(op))
            }
        }
    }
    var result = 0
    while(!stack.isEmpty()) {
        result += stack.pop()
    }
    return result
}