package com.example.Kotlin.Learning

var stack1: MutableList<Char> = mutableListOf()

fun main (args: Array<String>) {
  val item = Person()
  item.name = "Alan"
  println("Name is ${item.name}")

    //pass function as a parameter
    item.dispayWithLambda (::displayName)

}

fun displayName(s: String) {
    println(s)
}

class Person {
    var name: String = ""

   //higher order function
   fun dispayWithLambda(func: (s:String)->Unit) {
       func(name)
    }
}