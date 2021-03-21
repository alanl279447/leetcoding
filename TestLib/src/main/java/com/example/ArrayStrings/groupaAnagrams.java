package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/group-anagrams/solution/
// time complexity 0(nk)
public class groupaAnagrams {

    public static void main(String[] args) {
        String[] input = {"eeat", "teea", "tan", "ate", "nat", "bat"};
        List<List<String>> groupAnagrams = groupAnagramsTest(input);

        for (List<String> item: groupAnagrams)
            System.out.println(item.toString());
    }

    // time complexity 0(nk)
    public static List<List<String>> groupAnagramsTest(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) ca[c - 'a']++;
            String keyStr = String.valueOf(ca);   //to get the unique key
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }

    // time complexity 0(nklogK)
    private static List<List<String>>  groupAnagrams(String[] strs) {
        List<List<String>> output = new ArrayList<>();
        Map<String, List<String>> mapping = new HashMap<String, List<String>>();

        for (String item: strs) {
            char[] chars = item.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);

            if (!mapping.containsKey(key)) {
                mapping.put(key, new ArrayList<String>());
            }
            mapping.get(key).add(item);
        }
        return new ArrayList(mapping.values());
    }

}
