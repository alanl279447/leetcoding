package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PalindromePermutation_266 {

//    Input: "carerac"
//    Output: true
//    https://leetcode.com/problems/palindrome-permutation/

    public static void main(String[] args) {
        boolean result = canPermutePalindrome("carerac");
        System.out.println(result);
    }

    public static boolean canPermutePalindrome(String s) {
       Set<Character> set= new HashSet<>();
       for (char c: s.toCharArray()) {
           if (set.contains(c)) {
               set.remove(c);
           } else {
               set.add(c);
           }
       }
       return set.size()<=1;
    }
}
