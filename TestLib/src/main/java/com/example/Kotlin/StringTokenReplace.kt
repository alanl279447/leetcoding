package com.example.Kotlin

import java.lang.StringBuilder


fun main(args: Array<String>) {
    var input: String = "Hello, I am [name]. I live in [address]"
    println(StringTokenReplace(input))
}

fun StringTokenReplace(input: String): String? {
    val map = hashMapOf<String, String>("name" to "John", "address" to "SunnySlope road")
    var sbResult = StringBuilder()
    var sbToken = StringBuilder()
    var i = 0
    while (i < input.length) {
        if (input[i]=='[') {
            i++
            while (i < input.length && input[i] != ']') {
                sbToken.append(input[i++])
            }
            i++
            sbResult.append(map[sbToken.toString()])
            sbToken.clear()
        } else {
            sbResult.append(input[i++])
        }
    }
    return sbResult.toString()
}