package com.example.ArrayStrings;

public class CountandSay_38 {
//            1.     1
//            2.     11
//            3.     21
//            4.     1211
//            5.     111221
//    Input: 4
//    Output: "1211"
    //https://leetcode.com/problems/count-and-say/

    public static void main(String[] args) {
       System.out.println(countAndSay(4));
    }

    public static String countAndSay(int n) {
        StringBuilder s = new StringBuilder("1");
        for(int i = 1; i < n; i++){
            s = countIdx(s);
        }
        return s.toString();
    }

    public static StringBuilder countIdx(StringBuilder s){
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(0);
        int count = 1;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == c){
                count++;
            } else {
                sb.append(count);
                sb.append(c);
                c = s.charAt(i);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(c);
        return sb;
    }
}