package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.List;

public class CSVParser_amazon {

//    Input = ' "a","b","c" '
//    Output = [a, b, c]
//
//    Input = ' a,"b,",c '
//    Output = [a,"b,",c]
////   We are not adding the double quotes in the strings
//    https://leetcode.com/discuss/interview-question/631933/Amazon-or-Phone-or-CSV-Parser

    public static void main(String args[]) {

        String input = "\'\"a\",\"b,\",\"c\"'";
//        String input = "\'a,\"b,\",c\'";
        List<String> result  = csvParser(input);
        for (String res:result)
         System.out.println(res);
    }

   public static List<String> csvParser(String input) {
       List<String> result = new ArrayList<>();
       int x=0;
       for (int i=0;i<input.length();i++) {
           StringBuilder sb = new StringBuilder();
           while(i < input.length() && input.charAt(i) != ',' || x==1) {
             if (input.charAt(i)=='\'') {
                 i++;
                 continue;
             }
             if (input.charAt(i)=='\"') {
                 x++;
             }
             sb.append(input.charAt(i));
             i++;
         }
           String str = sb.toString();
           x=0;
           result.add(str);
       }
       System.out.println(input);
       return result;
   }

}
