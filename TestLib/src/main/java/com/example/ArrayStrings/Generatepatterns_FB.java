package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
//        Given a string as input, return the list of all the patterns possible:
//        '1' : ['A', 'B', 'C'],
//        '2' : ['D', 'E'],
//        '12' : ['X']
//        '3' : ['P', 'Q']
//        Example if input is '123', then output should be
//        [ADP, ADQ, AEP, AEQ, BDP, BDQ, BEP, BEQ, CDP, CDQ, CEP, CEQ, XP, XQ]
//        https://leetcode.com/discuss/interview-question/133408/Facebook-or-Onsite-or-Generate-patterns

public class Generatepatterns_FB {

    public static void main(String[] args) {
        Map<String, List<Character>> map = new HashMap<>();
        map.put("1", Arrays.asList('A','B','C'));
        map.put("2", Arrays.asList('D','E'));
        map.put("12", Arrays.asList('X'));
        map.put("3", Arrays.asList('P','Q'));
        System.out.println(getAllPatterns(map, "12"));
    }

    public static List<String> getAllPatterns(Map<String, List<Character>> map, String str){
        List<String> res = new ArrayList<>();
        dfs(map, res, str, "");
        return res;
    }

    public static void dfs(Map<String, List<Character>> map, List<String> res, String str,  String temp){
        if(str.equals("")){
            res.add(temp);
        }
        for(int i = 0; i < str.length(); i++){
            // this line is to get a cumulative key ex: 1, 12, 123
            String key = str.substring(0,i+1);

            // Proceed dfs if the key exists in map
            if(map.containsKey(key)){

                List<Character> charList = map.get(key);
                for(char c: charList){
                    dfs(map, res, str.substring(i+1), temp+c);
                }
            }
        }
    }
}