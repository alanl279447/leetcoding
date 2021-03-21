package com.example.Kotlin

fun main (args: Array<String>) {
    val input = arrayOf("\"345366 89921 45\", \"029323 38239 23\", \"38239 345366 15\", \"029323 38239 77\",\n" +
            "\t\t\t\t\"345366 38239 23\", \"029323 345366 13\", \"38239 38239 23\"")

}

fun transactionLogs(inputs: Array<String>, threshold:Int): MutableList<String> {
     var map:MutableMap<String, Int> = mutableMapOf<String, Int>()
     var result: MutableList<String> = mutableListOf<String>()

    for (input in inputs) {
         var splitArray = input.split("\\s+".toRegex())
         var user1 = splitArray[0]
         var user2 = splitArray[1]
         if (user2!= user1) {
             map.put(user2, map.getOrDefault(user2, 0)+1)
         }
        map.put(user1, map.getOrDefault(user1, 0)+1)
     }
    for (input in map.keys) {
        if (map.getOrDefault(input,0) > threshold) {
            result.add(input)
        }
    }
    return result
}

