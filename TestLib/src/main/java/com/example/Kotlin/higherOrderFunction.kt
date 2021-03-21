package com.example.Kotlin

import com.example.TreesAndGraph.n

fun main (args: Array<String>) {
    
//    var name:String?="Alan"
//    var myName = name?.let{
//        "test"
//    }
//
//    var nameTest:String?="Gregory"
//    val myNameTest = name?.let {
//        if (it.equals("Alan"))
//            it
//        else
//            "Not Alan"
//    }
//
//    System.out.println(myNameTest)
//    testAPI()
}

//fun PowerN(x: Int, n:Int):Double {
//    var x = x
//    var ans = 1.0
//    var absN = Math.abs(n as Long)
//    while (absN > 0) {
//        if (absN and 1 == 1L) {
//            ans *= x
//        }
//        absN = absN shr 1
//        x *= x
//    }
//    return if (n < 0) 1 / ans else ans
//}

fun String.println() = println(this)

data class Person(var name: String,
                  var age: Int,
                  var designation: String) {
    fun printPerson(): String {
        print(this)
      return this.toString()
    }
}

var myLamba: (Int, Int)->Int = { a,b-> a+b}

fun addNumbers(lambda:(Int, Int)->Int) {
    println(lambda(2,5))
}

fun hasPassed(marks: Int): Boolean {
    return marks > 40
}

var lamba = { println("Higher order function")}

fun higherOrder(lam:() -> Unit) {
    lam
}

fun printSum(num1: Int, num2: Int, action:(Int)->Unit) {
    val sum = num1+num2
    action(sum)
}


interface printResult {
    fun printSum(sum: Int)
}


