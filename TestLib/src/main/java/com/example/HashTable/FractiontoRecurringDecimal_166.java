package com.example.HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FractiontoRecurringDecimal_166 {
//    Input: numerator = 1, denominator = 2
//    Output: "0.5"
//    https://leetcode.com/problems/fraction-to-recurring-decimal/

//    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
//        String res = fractionToDecimal(2,3);
        String res = fractionToDecimal(2,3);
        System.out.println(res);
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder fraction = new StringBuilder();
        // If either one is negative (not both)
        if (numerator < 0 ^ denominator < 0) {
            fraction.append("-");
        }
        // Convert to Long or else abs(-2147483648) overflows
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        fraction.append(String.valueOf(dividend / divisor));
        long remainder = dividend % divisor;
        if (remainder == 0) {
            return fraction.toString();
        }
        fraction.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while(remainder != 0) {
            if (map.containsKey(remainder)) {
                fraction.insert(map.get(remainder), "(");
                fraction.append(')');
                break;
            }
            map.put(remainder, fraction.length());
            remainder = remainder*10;
            fraction.append(String.valueOf(remainder/divisor));
            remainder = remainder%divisor;
        }
        return fraction.toString();
    }
}