package com.example

import kotlin.properties.Delegates


var stack: MutableList<Char> = mutableListOf()

fun main (args: Array<String>) {
//    enqueue('a')
//    enqueue('b')
//    enqueue('c')
//    System.out.println(dequeue())
//    enqueue('d')
//    System.out.println(dequeue())
    storeId= "123445"

    val list = mutableListOf(7,4,19,6,5,20  )
    System.out.println(buyAnsSellStocks(list))


    var testData: String = "1234"
    testData?.apply {
        testData = "Alan Lobo"
        System.out.println(testData)
    }
    System.out.println(testData)
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

