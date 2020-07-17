package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Input: ["flower","flow","flight"]
//        Output: "fl"
//        https://leetcode.com/problems/longest-common-prefix/

public class LongestCommonPrefix14 {

    public static void main(String[] args) {
        String[] inputs = {"flower","flow","flight", "write"};
        System.out.println(longestCommonPrefix(inputs));
    }

    public static String longestCommonPrefixPrac(String[] strs) {
        if (strs==null || strs.length == 0) {
            return null;
        }
        String pre = strs[0];
        int i=1;
        while (i < strs.length) {
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length()-1);
            }
            i++;
        }
        return pre;
    }







    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)    return "";
        String pre = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
            i++;
        }
        return pre;
    }
}
