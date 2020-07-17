package com.example.ArrayStrings;

//       Input:
//        board = [
//        ['o','a','a','n'],
//        ['e','t','a','e'],
//        ['i','h','k','r'],
//        ['i','f','l','v']
//        ]
//        words = ["oath","pea","eat","rain"]
//
//        Output: ["eat","oath"]
//
//        https://leetcode.com/problems/word-search-ii/
//        time complexity O(M(4⋅3L−1))


import java.util.ArrayList;
import java.util.List;

public class WordSearchII_212 {
    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};

//        char[][] board = {{'a', 'a'}};
//        String[] words = {"aa"};
        List<String> results = findWords(board, words);
        for (String res: results) {
            System.out.println(res);
        }
    }

    public static List<String> findWords(char[][] board, String[] words) {
        //setup Trie structure
        int row = board.length;
        int col = board[0].length;
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);


        for (int i=0; i<row; i++) {
         for (int j=0; j < col; j++) {
            bfs(board, i, j, result, root);
         }
        }
        return result;
    }

    private static void bfs(char[][] board, int row, int col, List<String> result, TrieNode root) {
        char c = board[row][col];
        if (c=='#' || root.nodes[c-'a'] == null) return;
        TrieNode p = root.nodes[c-'a'];
        if (p.word != null) {
            result.add(p.word);
            p.word = null;
        }
        board[row][col] = '#';

        if (row > 0)  bfs(board, row-1, col, result, p);
        if (row < board.length-1)  bfs(board, row+1, col, result, p);

        if (col > 0)  bfs(board, row, col-1, result, p);
        if (col < board[0].length-1)  bfs(board, row, col+1, result, p);
        board[row][col] = c;
    }

    private static TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word: words) {
            TrieNode p = root;
            for (char c: word.toCharArray()) {
                 if (p.nodes[c-'a'] == null) {
                     p.nodes[c-'a'] = new TrieNode();
                }
                 p = p.nodes[c-'a'];
            }
            p.word = word;
        }
        return root;
    }

    public static class TrieNode {
        private TrieNode[] nodes;
        private String word;
        int R = 26;

        public TrieNode() {
            nodes = new TrieNode[26];
        }

        public boolean containsNode(char value) {
            return nodes[value - 'a'] != null;
        }

        public void putValue(char value) {
            nodes[value-'a'] = new TrieNode();
        }
    }



}
