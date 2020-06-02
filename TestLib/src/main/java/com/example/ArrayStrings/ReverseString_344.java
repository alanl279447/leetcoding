package com.example.ArrayStrings;

//        Input: s = "abcdefg", k = 2
//        Output: "bacdfeg"
//        https://leetcode.com/problems/reverse-string-ii/

public class ReverseString_344 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(reverseStrPrac("abcdefg", 2));
    }

    public static String reverseStrPrac(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int i=0;
        while (i < n) {
          int j = Math.min(i+k-1, n-1);
          swap(arr, i, j);
          i = i + 2*k;
        }
        return arr.toString();
    }

    private static void swap(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }

}