package com.example

import java.util.*

fun main (args: Array<String>) {
    
    var name:String?="Alan"
    var myName = name?.let{
        "test"
    }

    var nameTest:String?="Gregory"
    val myNameTest = name?.let {
        if (it.equals("Alan"))
            it
        else
            "Not Alan"
    }

    System.out.println(myNameTest)
}

fun String.println() = println(this)

data class Person(var name: String,
                  var age: Int,
                  var designation: String) {
    fun printPerson(): String {
        print(this)
      return this.toString()
    }
}

var lamba = { println("Higher order function")}

fun higherOrder(lam:() -> Unit) {
    lam
}

fun printSum(num1: Int, num2: Int, action:(Int)->Unit) {
    val sum = num1+num2
    action(sum)
}

fun printSum(num1: Int, num2: Int, funPrintResult: printResult) {
        val sum = num1+num2
         funPrintResult.printSum(sum)
}



interface printResult {
    fun printSum(sum: Int)
}


