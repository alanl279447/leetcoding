package com.example.ArrayStrings;
//Symbol       Value
//        I             1
//        V             5
//        X             10
//        L             50
//        C             100
//        D             500
//        M             1000
//
//        Input: 1994
//        Output: "MCMXCIV"
//        Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
//        https://leetcode.com/problems/integer-to-roman/

public class IntegertoRoman_12 {
    public static void main(String[] args) {
        System.out.println("Start main " +intToRoman(1994));
    }

    public static String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();
        int i = 0;
        //iterate until the number becomes zero, NO NEED to go until the last element in roman array
        while (num >0) {
            while(num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
            i++;
        }
        return sb.toString();
    }

}
