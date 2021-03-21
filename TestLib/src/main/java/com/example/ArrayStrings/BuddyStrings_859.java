package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BuddyStrings_859 {

//    Input: A = "aaaaaaabc", B = "aaaaaaacb"
//    Output: true
//    Explanation: You can swap A[0] = 'a' and A[1] = 'b' to get "ba", which is equal to B.
//    https://leetcode.com/problems/buddy-strings/
    public static void main(String[] args) {
        System.out.println(buddyStrings("aaaaaaabc", "aaaaaaacb"));
    }

    public static boolean buddyStrings(String A, String B) {
       if (A.length() != B.length()) return false;
       if (A.equals(B)) {
           Set<Character> set = new HashSet();
           for (int i =0; i < A.length(); i++) {
               set.add(A.charAt(i));
           }
           return set.size() < A.length();
       } else {
           List<Integer> diff = new ArrayList<>();
           for (int i =0; i < A.length(); i++) {
               if (A.charAt(i) != B.charAt(i)) {
                   diff.add(i);
               }
           }
           return diff.size()==2 && A.charAt(diff.get(0)) == B.charAt(diff.get(1))
                    && A.charAt(diff.get(1)) == B.charAt(diff.get(0));
       }
    }
}