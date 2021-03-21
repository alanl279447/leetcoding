package com.example.DesignQuestions;

public class AddSearchWordDatastructuredesign_211 {
    //    addWord("bad")
//    addWord("dad")
//    addWord("mad")
//    search("pad") -> false
//    search("bad") -> true
//    search(".ad") -> true
//    search("b..") -> true
//    https://leetcode.com/problems/add-and-search-word-data-structure-design/
    public static TreeNode root = null;
    public static void main(String[] args) {
        addNode(7);
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        System.out.println("Next :" +obj.search("pad"));
        System.out.println("Next :" +obj.search("bad"));
        System.out.println("Next :" +obj.search(".ad"));
        System.out.println("Next :" +obj.search("b.."));
    }

    public static class WordDictionary {

        public class TrieNode{
            private TrieNode[] children;
            private boolean isWord;
            public TrieNode() {
                this.children = new TrieNode[26];
                this.isWord = false;
            }
        }

        private TrieNode root;
        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new TrieNode();
        }

        private void buildTrie(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
            }
            cur.isWord = true;
        }
        /** Adds a word into the data structure. */
        public void addWord(String word) {
            buildTrie(word);
        }

        /** Returns if the word is in the data structure. A word could
         contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return find(word, 0, root);
        }

        private boolean find(String word, int index, TrieNode cur) {
            if (index == word.length()) {
                return cur.isWord;
            }

            char c = word.charAt(index);
            if (c == '.') {
                for (int i = 0; i < 26; i++) {
                    if (cur.children[i] != null) {
                        if (find(word, index + 1, cur.children[i])) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                return cur.children[c - 'a'] != null &&
                        find(word, index + 1, cur.children[c - 'a']);
            }
        }
    }

    public static void addNode(int value) {
        root = new TreeNode(value);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}