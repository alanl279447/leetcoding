package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Input: s = "aab"
//Output: [["a","a","b"],["aa","b"]]
//https://leetcode.com/problems/palindrome-partitioning/
//time complexity 0(n.2^n)
public class PalindromePartitioning_131 {
    public static void main(String args[]) {
        String input = "aab";
        List<List<String>> res = partition(input);
        for(List<String> re: res) {
            System.out.println(re);
        }
    }

    //backTracking problem
    //pos = 0 to len
    //check if string between pos, i is pal
    //increment position when position = len-1, add to result

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> list = new ArrayList<String>();
        dfs(s,0,list,res);
        return res;
    }

    public static void dfs(String s, int pos, List<String> list, List<List<String>> res){
        if(pos==s.length()) res.add(new ArrayList<String>(list));
        else{
            for(int i=pos;i<s.length();i++){
                if(isPal(s,pos,i)){
                    list.add(s.substring(pos,i+1));
                    dfs(s,i+1,list,res);
                    list.remove(list.size()-1);
                }
            }
        }
    }

    public static boolean isPal(String s, int low, int high){
        while(low<high) if(s.charAt(low++)!=s.charAt(high--)) return false;
        return true;
    }
}