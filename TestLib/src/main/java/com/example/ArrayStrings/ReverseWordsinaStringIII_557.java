package com.example.ArrayStrings;

//        Input: "Let's take LeetCode contest"
//        Output: "s'teL ekat edoCteeL tsetnoc"
//        https://leetcode.com/problems/reverse-words-in-a-string-iii/

public class ReverseWordsinaStringIII_557 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    public static String reverseWords(String input) {
        final StringBuilder result = new StringBuilder();
        final StringBuilder word = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
                word.append(input.charAt(i));
            } else {
                result.append(word.reverse());
                result.append(" ");
                word.setLength(0);
            }
        }
        result.append(word.reverse());
        return result.toString();
    }
}