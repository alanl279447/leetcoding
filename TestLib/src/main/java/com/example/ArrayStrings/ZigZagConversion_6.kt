package com.example.ArrayStrings;

import java.lang.StringBuilder

//Input: s = "PAYPALISHIRING", numRows = 4
//        Output: "PINALSIGYAHRPI"
//        Explanation:
//
//        P     I    N
//        A   L S  I G
//        Y A   H R
//        P     I
//        https://leetcode.com/problems/zigzag-conversion/

//http://www.goodtecher.com/leetcode-6-zigzag-conversion/

public class ZigZagConversion_6 {

//    public static void main(String[] args) {
//        System.out.println(reverseVowels("leetcode"));
//    }

    fun main(args: Array<String>) {
        System.out.println(convert("PAYPALISHIRING", 4))
    }

    fun convert(s: String, rows: Int) : String {
       if(rows == 1) return s
       var items = ArrayList<StringBuilder>()   //set an array of stringBuilder
       for (i in 0 until rows) items.add(StringBuilder())
       var count = 0
       var toggle = false
       for (c in s.toCharArray()) {
           items[count].append(c)
           if (count ==0 || count == rows-1) {   //change the direction if count = 0 | row-1
               toggle = !toggle
           }
          count += if(toggle) 1 else -1
       }

       var result = StringBuilder()
       for (item in items) {
           result.append(item)
       }
        return result.toString()
    }
}