package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//    https://leetcode.com/discuss/interview-question/877624/
public class SubStringDistinctCharacter_Amazon {
    public static void main(String[] args) {
        System.out.println(findSubstrings("wawaglknagagwunagkwkwagl", 4));
    }

    public static List<String> findSubstringsTest(String str, int k) {
        List<String> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        for (int end=0; end<str.length(); end++) {
            char c = str.charAt(end);
            map.put(c, map.getOrDefault(c, 0)+1);
            if(end-start==k-1) {
                if (map.size()==k-1) {
                    result.add(str.substring(start, end+1));
                }
                char remove = str.charAt(start++);
                map.put(remove, map.getOrDefault(remove, 0)-1);
                if(map.get(remove) <=0) {
                    map.remove(remove);
                }
            }
        }
        return result;
    }

    public static List<String> findSubstrings(String str, int k) {
        List<String> res = new ArrayList<>();
        HashMap<Character, Integer> hm = new HashMap<>();
        int start = 0;

        for(int end = 0; end < str.length(); end++) {
            char c = str.charAt(end);
            hm.put(c, hm.getOrDefault(c, 0) + 1);
            if(end - start == k - 1) {
                if(hm.size() == k-1) {
                    res.add(str.substring(start, end + 1));
                }
                char remove = str.charAt(start++);
                hm.put(remove, hm.get(remove)-1);
                if(hm.get(remove) == 0) {
                    hm.remove(remove);
                }
            }
        }
        return res;
    }
}