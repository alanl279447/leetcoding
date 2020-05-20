package com.example.ArrayStrings;

import java.util.HashSet;
import java.util.Set;

public class longestSubStringLength {

    public static void main(String[] args) {
//        System.out.println("Longest subString is: "+lengthOfLongestSubstringMap1("abccabcde"));
        System.out.println("Longest subString is: "+bruteForceTechnic("abccabcde"));
    }

    private static String bruteForceTechnic(String input) {
        int length = input.length();
        int maxLengthSubString =0;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length -1; j++) {
                if (checkForUnique(input, i, j)) {
                    maxLengthSubString = Math.max(j-i, maxLengthSubString);
                }
            }
        }
        return String.valueOf(maxLengthSubString);
    }

    private static boolean checkForUnique(String input, int start, int end) {
        Set entries = new HashSet();
        for (int i = start; i<end; i++) {
            if (entries.contains(input.charAt(i)))
                return false;
            entries.add(input.charAt(i));
        }
        return true;
    }

//    private static String lengthOfLongestSubstringMap1(String input) {
//        int lengthSubString = 0, longestSubString = 0;
//        char[] chars = input.toCharArray();
//        char previousChar = chars[0];
//        int i = 0;
//        while(i < chars.length) {
//            char current = chars[i];
//            if(current == previousChar) {
//                lengthSubString = 0;
//            } else {
//                lengthSubString++;
//                longestSubString++;
//            }
//            i++;
//        }
//        return String.valueOf(lengthSubString);
//    }
}
