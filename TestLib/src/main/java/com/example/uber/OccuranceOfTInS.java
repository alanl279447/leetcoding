package com.example.uber;


//Q1. Given two strings s and t. Count the number of occurence of t in s as follows. Length of t is 3, increment count when t == s[i]s[i+2]s[i+4]
//        e.g s = aabbcc , t = abc . output = 2.
//        https://leetcode.com/discuss/interview-question/1066383/Uber-OA

public class OccuranceOfTInS {
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