package com.example.ArrayStrings;

//        Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
//        Input: word1 = “coding”, word2 = “practice”
//        Output: 3
//        https://leetcode.com/problems/shortest-word-distance/

public class ShortestWordDistance_243 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(shortestDistance(words, "makes", "coding"));
    }

    public static int shortestDistance(String[] words, String word1, String word2) {
        int i1 = -1, i2 = -1;
        int minDistance = words.length;
        int currentDistance;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                i1 = i;
            } else if (words[i].equals(word2)) {
                i2 = i;
            }

            if (i1 != -1 && i2 != -1) {
                minDistance = Math.min(minDistance, Math.abs(i1 - i2));
            }
        }
        return minDistance;
    }
}