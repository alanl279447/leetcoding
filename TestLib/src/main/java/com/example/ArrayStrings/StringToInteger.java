package com.example.ArrayStrings;

public class StringToInteger {
//    Only the space character ' ' is considered as whitespace character.
//    Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
//    If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
//    https://leetcode.com/problems/string-to-integer-atoi/

    public static void main(String[] args) {
        System.out.println("Start main " +myAtoi3("-42"));
        System.out.println("Start main " +myAtoi3("2147483646"));
        System.out.println("Start main " +myAtoi3("2147483646"));
    }

    private static int myAtoi3Practice(String str) {
       int resultInt = 0, i =0, length = str.length(), signFlag = 0;

       while (i < length) {
           if (str.charAt(i) == ' ') i++;
       }
       if (i < length && str.charAt(i) == '-') {
           signFlag = -1;
           i++;
       } else if (i < length && str.charAt(i) == '+') {
           signFlag = +1;
           i++;
       }

       while (i < length && str.charAt(i)>='0' && str.charAt(i)<='9') {
         if (resultInt>Integer.MAX_VALUE/10 || resultInt==Integer.MAX_VALUE/10 && str.charAt(i)-'0'>Integer.MAX_VALUE%10) {
             return (signFlag>0)? Integer.MAX_VALUE : Integer.MIN_VALUE;
         }
         resultInt=resultInt*10+ str.charAt(i)-'0';
       }



       while (i < length && str.charAt(i) >='0' && str.charAt(i) <='9') {
           if (resultInt > Integer.MAX_VALUE/10 || resultInt==Integer.MAX_VALUE/10
                   && str.charAt(i)-'0' > Integer.MAX_VALUE%10) {
               return (signFlag>0)?Integer.MAX_VALUE:Integer.MIN_VALUE;
           }
           resultInt = resultInt*10+str.charAt(i)-'0';
           i++;
       }
       return resultInt;
    }



    //zneed to improve of time complexity
    private static int myAtoi3(String str) {
        int returnInt = 0, i =0;
        int signFlag = 1;
        if (str == null || str.length() == 0) return returnInt;

        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        if (i < str.length() && str.charAt(i) == '-') {
            signFlag = -1;
            i++;
        } else if (i < str.length() && str.charAt(i) == '+') {
            signFlag = +1;
            i++;
        }

        while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (returnInt > Integer.MAX_VALUE/10 ||
                    (returnInt == Integer.MAX_VALUE/10 && str.charAt(i) - '0'> Integer.MAX_VALUE%10)) {
                return signFlag == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            returnInt = returnInt * 10 + str.charAt(i) - '0';
            i++;
        }
        return returnInt*signFlag;
    }

}
