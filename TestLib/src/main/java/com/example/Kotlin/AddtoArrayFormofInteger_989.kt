package com.example.Kotlin

import kotlinx.coroutines.runBlocking
import java.util.*
import javax.xml.bind.JAXBElement
import kotlin.coroutines.suspendCoroutine

//Input: A = [2,7,4], K = 181
//Output: [4,5,5]
//Explanation: 274 + 181 = 455
//https://leetcode.com/problems/add-to-array-form-of-integer/

fun main (args: Array<String>) {
//    var result = addToArrayForm(intArrayOf(2,7,4), 181)
//    for (temp in result) {
//        System.out.println(temp)
//    }

    runBlocking {
        System.out.println(suspendFunctionWithDelay(5,4))
    }
}


suspend fun suspendFunctionWithDelay(a: Int, b: Int): Int {
    System.out.print("step 1")
    suspendCoroutine<Unit> { cont ->
        System.out.print("step 3")
    }
    System.out.print("step 2")
    return a + b
}

fun addToArrayForm(A: IntArray, K: Int): List<Int> {
    var result = LinkedList<Int>()
    var length = A.size
    var K = K
    for (i in length-1 downTo 0) {
        var temp = (A[i]+K)%10
        K = (A[i]+K)/10
        result.add(0, temp)
    }

    while(K>0) {
        result.add(0, K%10)
        K=K/10
    }
    return result
}
