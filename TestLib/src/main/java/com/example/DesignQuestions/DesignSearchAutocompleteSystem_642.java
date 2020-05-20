package com.example.DesignQuestions;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class DesignSearchAutocompleteSystem_642 {

//    Operation: AutocompleteSystem(["i love you", "island","ironman", "i love leetcode"], [5,3,2,2])
//    The system have already tracked down the following sentences and their corresponding times:
//            "i love you" : 5 times
//"island" : 3 times
//"ironman" : 2 times
//"i love leetcode" : 2 times
//    Now, the user begins another search:

//    Operation: input('i')
//    Output: ["i love you", "island","i love leetcode"]
//    Explanation:
//    There are four sentences that have prefix "i". Among them, "ironman"
//    and "i love leetcode" have same hot degree.
//    Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman".
//    Also we only need to output top 3 hot sentences, so "ironman" will be ignored.
//    https://leetcode.com/problems/design-search-autocomplete-system/

    public static void main(String[] args) {
//        addNode(1);
        String[] sentences = {"i love you", "island","ironman", "i love leetcode", "cat"};
        int[] times = {5,3,2,2,1};
        AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
        List<String> result = obj.input('i');

        for (String res: result) {
            System.out.println(res);
        }
    }

    public static class AutocompleteSystem {
        class TrieNode {
            Map<Character, TrieNode> children;
            Map<String, Integer> counts;
            boolean isWord;
            public TrieNode() {
                children = new HashMap<Character, TrieNode>();
                counts = new HashMap<String, Integer>();
                isWord = false;
            }
        }

        class Pair {
            String s;
            int c;
            public Pair(String s, int c) {
                this.s = s; this.c = c;
            }
        }

        TrieNode root;
        String prefix;


        public AutocompleteSystem(String[] sentences, int[] times) {
            root = new TrieNode();
            prefix = "";

            for (int i = 0; i < sentences.length; i++) {
                add(sentences[i], times[i]);
            }
        }

        private void add(String s, int count) {
            TrieNode curr = root;
            for (char c : s.toCharArray()) {
                TrieNode next = curr.children.get(c);
                if (next == null) {
                    next = new TrieNode();
                    curr.children.put(c, next);
                }
                curr = next;
                curr.counts.put(s, curr.counts.getOrDefault(s, 0) + count);
            }
            curr.isWord = true;
        }

        public List<String> input(char c) {
            if (c == '#') {
                add(prefix, 1);
                prefix = "";
                return new ArrayList<String>();
            }

            prefix = prefix + c;
            TrieNode curr = root;
            for (char cc : prefix.toCharArray()) {
                TrieNode next = curr.children.get(cc);
                if (next == null) {
                    return new ArrayList<String>();
                }
                curr = next;
            }

            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.c == b.c ? a.s.compareTo(b.s) : b.c - a.c));
            for (String s : curr.counts.keySet()) {
                pq.add(new Pair(s, curr.counts.get(s)));
            }

            List<String> res = new ArrayList<String>();
            for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
                res.add(pq.poll().s);
            }
            return res;
        }
    }

}