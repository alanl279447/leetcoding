package com.example.HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
//            ["ValidWordAbbr", "isUnique", "isUnique", "isUnique", "isUnique"]
//            [[["deer", "door", "cake", "card"]], ["dear"], ["cart"], ["cane"], ["make"]]
//            Output
//            [null, false, true, false, true]
//
//            ValidWordAbbr validWordAbbr = new ValidWordAbbr(["deer", "door", "cake", "card"]);
//            validWordAbbr.isUnique("dear"); // return false, dictionary word "deer" and word "dear" have the same abbreviation
//            // "d2r" but are not the same.
//            validWordAbbr.isUnique("cart"); // return true, no words in the dictionary have the abbreviation "c2t".
//            validWordAbbr.isUnique("cane"); // return false, dictionary word "cake" and word "cane" have the same abbreviation
//            // "c2e" but are not the same.
//            validWordAbbr.isUnique("make"); // return true, no words in the dictionary have the abbreviation "m2e".
//            validWordAbbr.isUnique("cake"); // return true, because "cake" is already in the dictionary and no other word in the dictionary has "c2e" abbreviation.
//            https://leetcode.com/problems/unique-word-abbreviation/
public class UniqueWordAbbreviation_288 {
    public static void main(String[] args) {
        String[] dictionary = {"deer", "door", "er","ett", "rftt"};
        ValidWordAbbr obj = new ValidWordAbbr(dictionary);
        boolean param_1 = obj.isUnique("dear");
        System.out.println(param_1);
    }

    static class ValidWordAbbr {

        HashMap<String, String> map = new HashMap<>();
        public ValidWordAbbr(String[] dictionary) {
            map = new HashMap<String, String>();
            for(String str:dictionary){
                String key = getKey(str);
                // If there is more than one string belong to the same key
                // then the key will be invalid, we set the value to ""
                if(map.containsKey(key)){
                    if(!map.get(key).equals(str)){
                        map.put(key, "");
                    }
                }
                else{
                    map.put(key, str);
                }
            }
        }

        public String getKey(String word) {
            if (word.length() < 2) {
                return word;
            }
            return word.charAt(0)+Integer.toString(word.length()-2)+word.charAt(word.length()-1);
        }

        public boolean isUnique(String word) {
            return !map.containsKey(getKey(word))||map.get(getKey(word)).equals(word);
        }
    }
}
