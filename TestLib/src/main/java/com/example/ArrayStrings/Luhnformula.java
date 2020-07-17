package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Luhnformula {
    //https://www.geeksforgeeks.org/luhn-algorithm/

    public static void main(String[] args) {
        String cardNo = "79927398713";
        System.out.println(checkLuhn(cardNo));
    }

    static boolean checkLuhn(String cardNo) {
     int length = cardNo.length();
     int sum = 0;
     boolean isSecond = false;
     for (int i=length-1; i >0; i--) {
         int d = cardNo.charAt(i)-'0';
         if (isSecond) {
            d=d*2;
         }
         sum +=d/10;
         sum +=d%10;
     }
     return sum%10==0;
    }
}
