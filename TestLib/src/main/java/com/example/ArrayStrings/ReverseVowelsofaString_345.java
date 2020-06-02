package com.example.ArrayStrings;

//        Input: ["h","e","l","l","o"]
//        Output: ["o","l","l","e","h"]
//        https://leetcode.com/problems/reverse-string/

public class ReverseVowelsofaString_345 {

    public static void main(String[] args) {
        char[] input = {'h','e','l','l','o'};
        reverseString(input);
        for (char c: input)
          System.out.println(c);
    }

    public static void reverseString(char[] s) {
        int n = s.length-1;
        int i=0;
        while (i < n) {
            char temp = s[i];
            s[i++]=s[n];
            s[n--]=temp;
        }
    }
}