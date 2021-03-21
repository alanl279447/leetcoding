package com.example.DesignQuestions;

class AddSearchWordDatastructuredesign_kt_211 {
    //    addWord("bad")
//    addWord("dad")
//    addWord("mad")
//    search("pad") -> false
//    search("bad") -> true
//    search(".ad") -> true
//    search("b..") -> true
//    https://leetcode.com/problems/add-and-search-word-data-structure-design/


    class WordDictionary() {
        /** Initialize your data structure here. */
        class TrieNode {
            var children: MutableList<TrieNode?>
            var isWord: Boolean

            init {
                children = MutableList(20) { null }
                isWord = false
            }
        }

        var root: TrieNode

        init {
            root = TrieNode()
        }

        fun addWord(word: String) {
            buildTrie(word)
        }

        fun buildTrie(word: String) {
            var curr = root
            for (c in word.toCharArray()) {
                val index = c - 'a'
                if (curr.children[index] == null) {
                    curr.children[index] = TrieNode()
                }
                curr = curr.children[index]!!
            }
            curr.isWord = true
        }

        fun search(word: String): Boolean {
            return findword(word, 0, root)
        }

        fun findword(word: String, index: Int, curr: TrieNode): Boolean {
            if (index == word.length) return curr.isWord
            val c = word[index]
            if (c == '.') {
                for (trie in curr.children) {
                    if (trie != null) {
                        if (findword(word, index+1, trie)) return true
                    }
                }
                return false
            } else {
                return curr.children[index] != null &&
                        findword(word, index+1, curr.children[index]!!)
            }
        }
    }
}