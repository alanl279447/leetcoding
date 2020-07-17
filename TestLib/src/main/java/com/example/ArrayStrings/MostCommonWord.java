package com.example.ArrayStrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

    public static void main(String[] args) {
        String[] banned = {"hit"};
        System.out.println("Start main " +mostCommonWord2("Bob hit a ball, the hit BALL flew far after it was hit.",
                banned));
    }

    public static String mostCommonWord2(String paragraph, String[] banned) {
        // split paragraph
        String[] words = paragraph.toLowerCase().split("\\W+");

        // add banned words to set
        Set<String> set = new HashSet<>();
        for(String word : banned){
            set.add(word);
        }

        // add paragraph words to hash map
        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            if(!set.contains(word)){
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        // get the most frequent word
        int max = 0; // max frequency
        String res = "";
        for(String str : map.keySet()){
            if(map.get(str) > max){
                max = map.get(str);
                res = str;
            }
        }

        return res;
    }

//    public static String mostCommonWord(String paragraph, String[] bannedWords) {
//        paragraph += ".";
//        Set<String> bannedSet = new HashSet<>();
//       Map<String, Integer> map = new HashMap<>();
//       int ans = 0;
//       String ansWord = null;
//
//       for (String word: bannedWords) {
//           bannedSet.add(word);
//       }
//
//       StringBuilder wordBuilder = new StringBuilder();
//       for(Character c: paragraph.toCharArray()) {
//        if (Character.isLetter(c)) {
//            wordBuilder.append(Character.toLowerCase(c));
//        } else if (wordBuilder.length() > 0) {
//            if (!bannedSet.contains(wordBuilder.toString())) {
//              map.put(wordBuilder.toString(), map.getOrDefault(wordBuilder.toString(), 0) + 1);
//              int currentMax = map.get(wordBuilder.toString());
//              if (currentMax > ans) {
//                  ans = currentMax;
//                  ansWord = wordBuilder.toString();
//              }
//            }
//            wordBuilder = new StringBuilder();
//        }
//       }
//       return ansWord;
//    }
}
