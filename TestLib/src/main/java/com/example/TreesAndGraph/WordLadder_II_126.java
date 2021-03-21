package com.example.TreesAndGraph;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder_II_126 {
//    Input:
//    beginWord = "hit",
//    endWord = "cog",
//    wordList = ["hot","dot","dog","lot","log","cog"]
//
//    Output: 5
//
//    Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//            return its length 5.
    //    https://leetcode.com/problems/word-ladder-ii/submissions/
    //O(26 * WordLen * NumberOfWord * 2 * ( V + E))
//    Graph: { hit=[hot],  hot=[dot, lot], dot=[dog], lot=[log], dog=[cog], log=[cog], cog=[]}
//    Distance or Depth: {hit=0, hot=1, dot=2 lot=2, , dog=3 log=3, cog=4}

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        String[] dict = {"hot","dot","dog","lot","log","cog"};
//        String[] dict = {"hot","dog","lot","log","cog"};
        System.out.print(findLadders("hit", "cog", Arrays.asList(dict)));
    }

//    public static List<List<String>> findLaddersTest(String beginWord, String endWord, List<String> wordList) {
//       Set<String> wordDict = new HashSet<>(wordList);
//       HashMap<String, List<String>> map = new HashMap<>();
//    }

    //bfs for all the next combinations
    //dfs to find all until the end
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList();
        Set<String> dict = new HashSet<>(wordList);

        if (!dict.contains(endWord)) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        Set<String> startSet = new HashSet<>();
        startSet.add(beginWord);
        bfs(startSet, beginWord, endWord, map, dict);

        List<String> list = new ArrayList<>();
        list.add(beginWord);
        dfs(res, list, beginWord, endWord, map);
        return res;
    }

    private static void dfs(List<List<String>> res, List<String> list, String beginWord, String endWord, Map<String, List<String>> map) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList(list));
            return;
        }
        if (map.get(beginWord)== null) return;
        List<String> nextValues = map.get(beginWord);
        for (String next: nextValues) {
            list.add(next);
            dfs(res, list, next, endWord, map);
            list.remove(list.size() -1);
        }
    }

    private static void bfs(Set<String> startSet, String beginWord, String endWord, Map<String, List<String>> map, Set<String> dict) {
        if(startSet.size() == 0) return;

        Set<String> tmp = new HashSet<>();
        dict.removeAll(startSet);
        boolean finish = false;

        for (String s: startSet) {
            char[] chs = s.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                char old = chs[i];

                for (char c = 'a'; c <= 'z'; c++) {
//                  if (c == old)
                    chs[i] = c;
                    String newWord = new String(chs);
                    if (dict.contains(newWord)) {
                        if (newWord.equalsIgnoreCase(endWord)) {
                            finish = true;
                        } else {
                            tmp.add(newWord);
                        }

                        if (map.get(s) == null) {
                            map.put(s, new ArrayList<>());
                        }
                        map.get(s).add(newWord);
                    }
                }
                chs[i] = old;
            }
        }
        if (!finish) {
            bfs(tmp, beginWord, endWord, map, dict);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void addNode(int value) {
        root = addNodeRecursive(root, value);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
    }

    public static TreeNode addNodeRecursive(TreeNode node, int value) {
//        TreeNode newNode = null;
        if (node == null) {
            node = new TreeNode(value);
            return node;
        }

        if (value < node.val) {
            node.left = addNodeRecursive(node.left, value);
        } else if (value > node.val){
            node.right = addNodeRecursive(node.right, value);
        } else {
            return node;
        }
        return node;
    }
}
