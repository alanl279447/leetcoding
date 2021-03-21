package com.example.HashTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
//        Output: true
//        Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
//        https://leetcode.com/problems/verifying-an-alien-dictionary/

public class VerifyinganAlienDictionary_953 {

    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        String[] words = {"hello", "leetcode"};
        System.out.print(isAlienSorted(words, "hlabcdefgijkmnopqrstuvwxyz"));
    }

    public static boolean isAlienSorted(String[] words, String order) {
        int[] char_map  = new int[26];
        for (int i =0; i < order.length(); i++) {
            char_map[order.charAt(i)-'a'] =  i;
        }
        for (int i=1; i < words.length;i++) {
            if (compare(words[i-1], words[i], char_map) > 0) {
              return false;
            }
        }
        return true;
    }

    public static int compare(String word1, String word2, int[] char_map) {
        int char_result =0;
        int i =0, j = 0;
        while(i < word1.length() && j < word2.length() && char_result == 0) {
            char_result = char_map[word1.charAt(i) - 'a'] - char_map[word2.charAt(j) - 'a'];
            i++;
            j++;
        }

        if (char_result == 0) {
            return word1.length()-word2.length();
        } else {
            return char_result;
        }
    }
}
