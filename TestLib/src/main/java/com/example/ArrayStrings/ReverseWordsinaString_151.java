package com.example.ArrayStrings;

public class ReverseWordsinaString_151 {
//    Input: "  hello world!  "
//    Output: "world! hello"
//    Explanation: Your reversed string should not contain leading or trailing spaces.
//    https://leetcode.com/problems/reverse-words-in-a-string/
    public static void main(String args[]) {
        //String input = "hello world!";
        String input = " the sky is blue";
        String res = reverseWords(input);
        System.out.println(res);
    }

    public static String reverseWords(String s) {
        int len = s.length();
        int i = len-1, j =0;
        StringBuilder sb = new StringBuilder();
        while(i >=0) {
            if (s.charAt(i) == ' ') {
                i--;
                continue;
            };
            j = i;
            while(j>=0 && s.charAt(j) !=' ') j--;
            sb.append(" ");
            sb.append(s.substring(j+1, i+1));
            i = j-1;
        }
        if (sb.length() > 0) sb.deleteCharAt(0);
        return sb.toString();
    }
}
