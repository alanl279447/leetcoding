package com.example.ArrayStrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

    public static void main(String[] args) {
        String[] banned = {};

        System.out.println("Start main " +mostCommonWord1("Bob", banned));
    }


    public static String mostCommonWord1(String paragraph, String[] banned) {
        paragraph += ".";

        Set<String> banset = new HashSet();
        for (String word: banned) banset.add(word);
        Map<String, Integer> count = new HashMap();

        String ans = "";
        int ansfreq = 0;

        StringBuilder word = new StringBuilder();
        for (char c: paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String finalword = word.toString();
                if (!banset.contains(finalword)) {
                    count.put(finalword, count.getOrDefault(finalword, 0) + 1);
                    if (count.get(finalword) > ansfreq) {
                        ans = finalword;
                        ansfreq = count.get(finalword);
                    }
                }
                word = new StringBuilder();
            }
        }

        return ans;
    }

    public static String mostCommonWord(String paragraph, String[] bannedWords) {
        paragraph += ".";
        Set<String> bannedSet = new HashSet<>();
       Map<String, Integer> map = new HashMap<>();
       int ans = 0;
       String ansWord = null;

       for (String word: bannedWords) {
           bannedSet.add(word);
       }

       StringBuilder wordBuilder = new StringBuilder();
       for(Character c: paragraph.toCharArray()) {
        if (Character.isLetter(c)) {
            wordBuilder.append(Character.toLowerCase(c));
        } else if (wordBuilder.length() > 0) {
            if (!bannedSet.contains(wordBuilder.toString())) {
              map.put(wordBuilder.toString(), map.getOrDefault(wordBuilder.toString(), 0) + 1);
              int currentMax = map.get(wordBuilder.toString());
              if (currentMax > ans) {
                  ans = currentMax;
                  ansWord = wordBuilder.toString();
              }
            }
            wordBuilder = new StringBuilder();
        }
       }
       return ansWord;
    }
}
