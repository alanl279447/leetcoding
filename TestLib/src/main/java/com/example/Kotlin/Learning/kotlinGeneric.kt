package com.example.Kotlin.Learning

class kotlinGeneric<M: Set<Any>, T: String> {
    fun main(args: Array<String>) {
        var item = ArrayUtil(arrayOf(1,2,3,4,5))
        item.findElement(3) {
            index, element->
        }
    }

    class Event<T,V> (value: T?=null, data:V) {
        init {
            if (value != null) {
                println(value.toString().length)
            } else {
                println("Empty parameter")
            }
        }
    }

    class ArrayUtil(private val value: Array<Int>) {
        fun findElement(element: Int, foundElement: (item:Int, element: Int?)->Unit) {
            for (i in value.indices) {
                if (value[i] == element) {
                    foundElement(i, value[i])
                    return
                }
            }
            foundElement(-1, null)
        }
    }
}