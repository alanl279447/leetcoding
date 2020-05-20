package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.List;

public class AddStrings_415 {

//    Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
//    https://leetcode.com/problems/add-strings/

    public static void main(String args[]) {

        String result  = addStrings("123", "345");
        System.out.println(result);

    }

    public static String addStrings(String num1, String num2) {

        int length1 = num1.length();
        int length2 = num2.length();
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = length1-1, j = length2-1; i >=0 || j>=0 || carry>0; i--, j--) {
            int x = i < 0 ? 0 :num1.charAt(i) - '0';
            int y = j < 0 ? 0 :num2.charAt(j) - '0';
            carry = (x+y+carry)/10;
            sb.append((x+y+carry)%10);
        }
        return sb.reverse().toString();
    }

}
