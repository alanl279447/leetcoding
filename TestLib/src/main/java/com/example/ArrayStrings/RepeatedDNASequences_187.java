package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatedDNASequences_187 {

//    Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//    Output: ["AAAAACCCCC", "CCCCCAAAAA"]
//    https://leetcode.com/problems/repeated-dna-sequences/

    public static void main(String[] args) {

        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(findRepeatedDnaSequences(s));
    }

    public static List<String> findRepeatedDnaSequences(String s) {
         Set<String> seen = new HashSet<>();
         Set<String> repeated = new HashSet<>();

         for (int i=0; i+9<s.length();i++) {
             String temp = s.substring(i, i+10);
             if (!seen.add(temp)) {
                 repeated.add(temp);
             }
         }
         return new ArrayList<>(repeated);
    }

    private static int hash(String s, int idx){
        char ch = s.charAt(idx);
        switch(ch) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
            default: return 0;
        }
    }
}
