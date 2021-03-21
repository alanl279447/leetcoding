package com.example.ArrayStrings;

public class ValidWordAbbreviation_408 {

//    Given s = "internationalization", abbr = "i12iz4n":
//    Return true.
//    https://leetcode.com/problems/valid-word-abbreviation/
    public static void main(String[] args) {
        System.out.println(validWordAbbreviation("internationalization", "i12iz4n"));
    }

    public static boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j=0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
                continue;
            } else if (abbr.charAt(i) < '0' || abbr.charAt(i)>'9') {
                return false;
            }
            int start = j;
            while (j < abbr.length() && abbr.charAt(j) >='0' || abbr.charAt(j) <'9') {
                j++;
            }
            int number = Integer.parseInt(abbr.substring(start, j));
            i = i + number;
        }
        return i==word.length() && j == abbr.length();
    }
}