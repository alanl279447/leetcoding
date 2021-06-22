package com.example.ArrayStrings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
//Input: "23"
//        Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
//        https://leetcode.com/problems/letter-combinations-of-a-phone-number/
//time complexity = 3 ^N * 4^M

public class LetterCombinationsPhoneNumber_17 {

    public static void main(String[] args) {
        List<String> result = letterCombinations("23");

        for (String item: result)
            System.out.println(item);
    }


    public static List<String> letterCombinationsTest(String digits) {
        LinkedList<String> result = new LinkedList<>();
        result.add("");
        String[] charMap = {"0", "1", "abc", "def", "","", "", "", "", "wxyz"};

        for (int i=0;i<digits.length();i++) {
            int index = digits.charAt(i)-'0';
            while (result.peek().length() == i) {
                char[] items = charMap[index].toCharArray();
                String prev = result.poll();
                for (char item: items) {
                    String newItem = prev+item;
                    result.add(newItem);
                }
            }
        }
        return result;
    }



    public static List<String> letterCombinations(String digits) {
        LinkedList<String> output_arr = new LinkedList<>();
        if (digits.length() < 1) {
            return output_arr;
        }
        String[] char_map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        output_arr.add("");

        //digit - 23
        for (int i=0; i<digits.length();i++) {
            int index = Character.getNumericValue(digits.charAt(i)); //2, 3
            while(output_arr.peek().length() == i) {
                char[] charIndex = char_map[index].toCharArray();
                String value = output_arr.poll();
                for (int j=0; j<charIndex.length;j++) {
                    String newValue = value + charIndex[j];
                    output_arr.add(newValue);
                }
            }
        }
        return output_arr;
    }
}