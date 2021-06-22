package com.example.DesignQuestions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class StreamofCharacters_1032 {
//    https://leetcode.com/problems/stream-of-characters/
//    StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // init the dictionary.
//streamChecker.query('a');          // return false
//streamChecker.query('b');          // return false
//streamChecker.query('c');          // return false
//streamChecker.query('d');          // return true, because 'cd' is in the wordlist
//streamChecker.query('e');          // return false
//streamChecker.query('f');          // return true, because 'f' is in the wordlist
//streamChecker.query('g');          // return false
//streamChecker.query('h');          // return false
//streamChecker.query('i');          // return false
//streamChecker.query('j');          // return false
//streamChecker.query('k');          // return false
//streamChecker.query('l');          // return true, because 'kl' is in the wordlist

    public static void main(String[] args) {

        String[] words = {"cd","f","kl"};
        StreamChecker obj = new StreamChecker(words);
//        obj.query('a');
//        obj.query('b');
//        obj.query('c');
//        obj.query('d');
//        obj.query('e');
//        obj.query('f');
//        obj.query('g');
//        obj.query('h');
//        obj.query('i');
//        obj.query('j');
        System.out.println(obj.query('k'));
        System.out.println(obj.query('l'));
        System.out.println(obj.query('k'));
        System.out.println(obj.query('l'));
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap();
        boolean word = false;
    }

    static class StreamChecker {
        TrieNode trie = new TrieNode();
        Deque<Character> stream = new ArrayDeque();

        public StreamChecker(String[] words) {
            for (String word : words) {
                TrieNode node = trie;
                String reversedWord = new StringBuilder(word).reverse().toString();
                for (char ch : reversedWord.toCharArray()) {
                    if (!node.children.containsKey(ch)) {
                        node.children.put(ch, new TrieNode());
                    }
                    node = node.children.get(ch);
                }
                node.word = true;
            }
        }

        public boolean query(char letter) {
            stream.addFirst(letter);

            TrieNode node = trie;
            for (char ch : stream) {
                if (node.word) {
                    return true;
                }
                if (!node.children.containsKey(ch)) {
                    return false;
                }
                node = node.children.get(ch);
            }
            return node.word;
        }
    }
}