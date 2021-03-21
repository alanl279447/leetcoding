package com.example.uber;


//https://leetcode.com/discuss/interview-question/894762/Uber-OA-Oct-2020
//Q1: Given an int, find alternate digit sum, reversing signs. For example input 52413, output {5 + (-2) + 4+ (-1) + 3}

public class AlternateDigitSum {
    // Driver code
    public static void main(String[] args) {
//        Integer arr[] = { 1,2,3,3,3,2,4 };
//        Integer n = arr.length;
        System.out.println(alternateSum(52413));
    }

    public static int alternateSum(int num) {
        String s = Integer.toString(num);
        int len = s.length();
        int sum = 0;
        boolean toggle = true;
        for (int i =0; i < len; i++) {
            sum = toggle ?  sum + (s.charAt(i)-'0') : sum - (s.charAt(i)-'0');
            toggle = !toggle;
        }
        return sum;
    }
}