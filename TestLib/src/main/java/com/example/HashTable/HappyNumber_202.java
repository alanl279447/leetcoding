package com.example.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HappyNumber_202 {

    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {

        int number = 19;
//        int number = 116;
        System.out.print(isHappy(number));
    }

    public static boolean isHappy(int n) {
       Set<Integer> set = new HashSet<>();
       while(n != 1) {
         n = returnNumber(n);
         if (set.contains(n)) {
             return false;
         } else {
             set.add(n);
         }
       }

       return true;
    }

    public static int returnNumber(int number) {
        int newNumber = 0;
        while(number >0) {
            int remainder = number%10;
            number = number/10;
            newNumber +=remainder*remainder;
        }
        return newNumber;
    }
}
