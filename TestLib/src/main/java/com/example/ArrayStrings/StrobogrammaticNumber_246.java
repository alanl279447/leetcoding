package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class StrobogrammaticNumber_246 {

//    Input:  "69"
//    Output: true
//    https://leetcode.com/problems/strobogrammatic-number/

    public static void main(String[] args) {
        System.out.println(isStrobogrammatic("9696"));
    }


    //0,1,8,00,11,88,69,96
    public static boolean isStrobogrammatic(String num) {
        HashSet<String> set = new HashSet<>();
        set.add("0");
        set.add("1");
        set.add("8");
        set.add("00");
        set.add("11");
        set.add("88");
        set.add("69");
        set.add("96");

        for(int left = 0, right = num.length() - 1; left <= right; left++, right--) {
            String result = num.charAt(left) + "" + num.charAt(right);
            if(!set.contains(result))
                return false;
        }
        return true;
    }
}
