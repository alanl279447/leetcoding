package com.example.HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AlienDictionary_269 {
//    Input:
//            [
//            "wrt",
//            "wrf",
//            "er",
//            "ett",
//            "rftt"
//            ]
//
//    Output: "wertf"
//    https://leetcode.com/problems/alien-dictionary/

//    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();

    //map character, Set<chracter>
    //int[] degree = new int[26];
    //build a graph and adjacency list
    //BFS starting with characters having inDegree==0

    public static void main(String[] args) {
        String[] words = {"wrt", "wrf", "er","ett", "rftt"};
        String res = alienOrder(words);
        System.out.println(res);
    }

    //map char and adj chars, out and in chars, inDegree[in] = 0
    //BFS for all the node with inDegree==0
//    public static String alienOrderTest(String[] words) {
//        HashMap<Character, Set<Character>> map = new HashMap();
//        int[] inDegree = new int[26];
//        buildGraphTest(map, inDegree, words);
//        bfsTest(map, inDegree, words);
//    }
//
//    public static void buildGraphTest(HashMap<Character, Set<Character>>  map, int[] inDegree, String[] words) {
//
//    }
//
//    public static String bfsTest(HashMap<Character, Set<Character>>  map, int[] inDegree, String[] words) {
//
//    }

    public static String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        int[] inDegree = new int[26];
        buildGraph(graph, inDegree, words);
        return bfs(graph, inDegree);
    }

    private static String bfs(Map<Character, Set<Character>> map, int[] inDegree) {
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (char c: map.keySet()) {
           if (inDegree[c -'a'] == 0)   {
               queue.offer(c);
           }
        }

        while(!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            Set<Character> chars = map.get(c);
            for (char out: chars) {
                inDegree[out-'a']--;
               if (inDegree[out-'a'] == 0) {
                   queue.offer(out);
               }
            }
        }
        return (sb.length() == map.size() ? sb.toString(): "");
    }

    private static void buildGraph(Map<Character, Set<Character>> graph, int[] inDegree, String[] words) {
        for (String word: words) {
            for (char c: word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());   //creating a graph for all the charaters.
            }
        }

        for (int i=1; i < words.length; i++) {
            String first = words[i-1];
            String second = words[i];

            int len = Math.min(first.length(), second.length());
            for (int j = 0; j < len; j ++) {
               char out = first.charAt(j);
               char in = second.charAt(j);
               if (out != in) {
                 if (!graph.get(out).contains(in)) {
                      graph.get(out).add(in);
                      inDegree[in - 'a']++;
                 }
                 break;
               }
            }
        }
    }

//    private static void buildGraph(Map<Character, Set<Character>> graph, int[] inDegree, String[] words) {
//        for (String s : words) {
//            for (char c : s.toCharArray()) {
//                graph.putIfAbsent(c, new HashSet<>());
//            }
//        }
//
//        for (int i = 1; i < words.length; i++) {
//            String first = words[i - 1];
//            String second = words[i];
//            int len = Math.min(first.length(), second.length());
//            for (int j = 0; j < len; j++) {
//                char out = first.charAt(j);
//                char in = second.charAt(j);
//                if (out != in) {
//                    if (!graph.get(out).contains(in)) {
//                        graph.get(out).add(in);
//                        inDegree[in - 'a']++;
//                    }
//                    break;
//                }
//            }
//        }
//    }
//
//    private static String bfs(Map<Character, Set<Character>> graph, int[] inDegree) {
//        StringBuilder sb = new StringBuilder();
//        Queue<Character> q = new LinkedList<>();
//        for (char c : graph.keySet()) {
//            if (inDegree[c - 'a'] == 0) {
//                q.offer(c);
//            }
//        }
//
//        while (!q.isEmpty()) {
//            char out = q.poll();
//            sb.append(out);
//            for (char in : graph.get(out)) {
//                inDegree[in - 'a']--;
//                if (inDegree[in - 'a'] == 0) {
//                    q.offer(in);
//                }
//            }
//        }
//        return sb.length() == graph.size() ? sb.toString() : "";
//    }
}
