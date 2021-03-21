package com.example.Kotlin

import java.util.*
import kotlin.properties.Delegates


var stack: MutableList<Char> = mutableListOf()

fun main (args: Array<String>) {
//    storeId= "123445"
//    val list = mutableListOf(7,4,19,6,5,20  )
//    System.out.println(buyAnsSellStocks(list))
//
//    var testData: String = "1234"
//    testData?.apply {
//        testData = "Alan Lobo"
//        System.out.println(testData)
//    }
//    System.out.println(testData)
//    numberRegex()
    trappingRainWater(mutableListOf(1, 2, 3))
}

fun numberRegex() {
    val list: MutableList<String> = mutableListOf("7","4", "5.45", "5,34","Alan")
    val list2 = listOf<Int>(7,4,19,6,5,20 )
    val fractionRegex = "^\\d+(\\.\\d+)?".toRegex()

    list.forEach {
        if (fractionRegex.matches(it))
            println(it)
    }
}



fun luhnAlgorithm(input:String):Boolean {
    var sum = 0
    var isSecond= false

    var card = input.replace("[^0-9]", " ")
    var length = card.length
    if (length < 13 && length > 16) return false

    for (i in length-1 downTo 0) {
        var item = input[i]-'0'
        if(isSecond) {
            item = item*2
        }
        isSecond = !isSecond
        sum += item%10
        sum += item/10
    }
    return sum%10==0
}

fun trappingRainWater(input: MutableList<Int>) {
    var stack:Deque<Int> = LinkedList()
    var current = 0
    var answer = 0
   while(current < input.size) {
       while (!stack.isEmpty() && input[current] > input[stack.peek()]) {
           
       }
       stack.push(current++);
   }
}

 var storeId by Delegates.observable("Test") {
     p, old, new ->
     println("${p.name} goes $old -> $new")
 }

 fun buyAnsSellStocks(inputArr: MutableList<Int>) : Int {
     if (inputArr==null || inputArr.size==1) return 0
     var minValue: Int = Int.MAX_VALUE
     var profit: Int = Int.MIN_VALUE

     for (i in 0 ..inputArr.size-1) {
         minValue = Math.min(minValue, inputArr.get(i))
         profit = Math.max(profit, inputArr.get(i)-minValue)
     }
     return profit
 }

