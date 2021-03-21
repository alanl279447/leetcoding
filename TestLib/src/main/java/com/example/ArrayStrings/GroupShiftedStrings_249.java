package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
//        Output:
//        [
//        ["abc","bcd","xyz"],
//        ["az","ba"],
//        ["acef"],
//        ["a","z"]
//        ]
//        https://leetcode.com/problems/group-shifted-strings/
// O(NK), while N is the numbers of string and K is the average length of a single string.
//Space O(M) if the result doesn't count, M stands for maximum length in strings.

public class GroupShiftedStrings_249 {

    public static void main(String[] args) {
        String[] input = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        List<List<String>> groupAnagrams = groupStrings(input);

        for (List<String> item: groupAnagrams)
            System.out.println(item.toString());
    }


//    public static List<List<String>> groupStringsTest(String[] inputs) {
//        HashMap<String, List<String>> map = new HashMap<>();
//
//        for (String input: inputs) {
//
//
//
//        }
//    }
//
//    public String getKey(String input) {
//        int len = input.length();
//
//
//    }
//



    public static List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strings) {
            String key = getKey(s);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

//    abx -> 122, amo -> 122. Ut didnt cover this. Need splitter to differentiate between them.
    private static String getKey(String s) {
        char[] chars = s.toCharArray();
        StringBuilder key = new StringBuilder();
        for(int i = 1; i < chars.length; i++) {
            int diff = chars[i] - chars[i-1];
            key.append(diff < 0 ? diff + 26 : diff);
            key.append(',');
        }
        return key.toString();
    }
}
