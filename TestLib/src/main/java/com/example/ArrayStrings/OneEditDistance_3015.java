package com.example.ArrayStrings;

//Input: s = "ab", t = "acb"
//        Output: true
//        Explanation: We can insert 'c' into s to get t.
//        https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/3015/

public class OneEditDistance_3015 {

    //submitted to leetcode
    public static void main(String[] args) {
        String s = "azb";
        String t = "acb";
        System.out.println("Palindrome result:  " + isOneEditDistance(s, t));
    }

    public static boolean isOneEditDistance(String s, String t) {

        int sLength = s.length();
        int tLength = t.length();

        if (sLength > tLength) {
            return isOneEditDistance(t,s);
        }

        if (sLength-tLength>1) {
            return false;
        }

        for (int i=0; i<sLength; i++) {
            if(s.charAt(i) != t.charAt(i)) {
                if(sLength == tLength) {
                    return s.substring(i+1).equals(t.substring(i+1));
                } else {
                    return s.substring(i).equals(t.substring(i+1));
                }
            }
        }
        return sLength == tLength+1;
    }
}