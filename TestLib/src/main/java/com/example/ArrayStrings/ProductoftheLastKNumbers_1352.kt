package com.example.ArrayStrings

import java.util.*
import kotlin.collections.ArrayList

//Input ["ProductOfNumbers","add","add","add","add","add","getProduct","getProduct","getProduct","add","getProduct"]
//[[],[3],[0],[2],[5],[4],[2],[3],[4],[8],[2]]
//Output  [null,null,null,null,null,null,20,40,0,null,32]
//Explanation
//ProductOfNumbers productOfNumbers = new ProductOfNumbers();
//productOfNumbers.add(3);        // [3]
//productOfNumbers.add(0);        // [3,0]
//productOfNumbers.add(2);        // [3,0,2]
//productOfNumbers.add(5);        // [3,0,2,5]
//productOfNumbers.add(4);        // [3,0,2,5,4]
//productOfNumbers.getProduct(2); // return 20. The product of the last 2 numbers is 5 * 4 = 20
//productOfNumbers.getProduct(3); // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
//productOfNumbers.getProduct(4); // return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
//productOfNumbers.add(8);        // [3,0,2,5,4,8]
//productOfNumbers.getProduct(2); // return 32. The product of the last 2 numbers is 4 * 8 = 32
//https://leetcode.com/problems/product-of-the-last-k-numbers/

fun main (args: Array<String>) {
     var productOfNumbers:ProductOfNumbers = ProductOfNumbers();
    productOfNumbers.add(3);
    productOfNumbers.add(0);
    productOfNumbers.add(2);
    productOfNumbers.add(5);
    productOfNumbers.add(4);
    println(productOfNumbers.getProduct(2));
    println(productOfNumbers.getProduct(3));
    println(productOfNumbers.getProduct(4));
    productOfNumbers.add(8);
    println(productOfNumbers.getProduct(2));
}

class ProductOfNumbers() {

    var list:ArrayList<Int> = arrayListOf(1)
    fun add(num: Int) {
        if (num >0) {
            list.add(list.get(list.size-1)*num)
        } else {
            list = arrayListOf(1)
        }
    }

    fun getProduct(k: Int): Int {
        if (list.size <= k) return 0
        var ans = list.get(list.size-1)
        //if (list.size == k) return ans
        return ans/list.get(list.size-1-k)
    }
}