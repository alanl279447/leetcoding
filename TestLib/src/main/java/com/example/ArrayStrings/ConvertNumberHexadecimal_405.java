package com.example.ArrayStrings;

public class ConvertNumberHexadecimal_405 {

//    Input: 26
//    Output:"1a"
//    https://leetcode.com/problems/convert-a-number-to-hexadecimal/
    public static void main(String[] args) {
        System.out.println(toHex(26));
    }

    static char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    public static String toHex(int num) {
        if(num == 0) return "0";
        String result = "";
        while(num != 0) {
            int temp = num & 15;
            result = map[(num & 15)] + result;
            num = (num >>> 4);
        }
        return result;
    }

//
//    public static String toHexSB(int num) {
//        StringBuilder sb = new StringBuilder();
//        do {
//            int n = num & 0xf;      //0xf == 15 (1111)
//            int temp = n < 0xa ? '0' : 'a' - 10;   //convert to ascii
//            n += temp;
//
//            sb.append((char)n);
//        } while ((num >>>= 4) != 0);   //shift 4 bits to the right
//        return sb.reverse().toString();
//    }
}