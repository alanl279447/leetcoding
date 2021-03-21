package com.example.ArrayStrings;

//Input: s = "abab"
//Output: "bab"
//Explanation: The substrings are ["a", "ab", "aba", "abab", "b", "ba", "bab"]. The lexicographically maximum substring is "bab".
//https://leetcode.com/problems/last-substring-in-lexicographical-order/

//class LastSubstringLexicographicalOrder_1163 {
    fun main(args: Array<String>) {
        System.out.println(lastSubstring("abab"))
    }

    fun lastSubstring(s: String): String {
        val n: Int = s.length
        var i = 0
        var j = 1
        var k = 0
        while (j + k < n) {
            if (s[i + k] === s[j + k]) {
                k++
            }
            // substring indexed at i is smaller than substring at j ,
            // hence all substrings between i and j are smaller  we jump i to j and increment j by 1
            else if (s[j + k] > s[i + k]) {
                i=Math.max(i+k+1,j)
                j = i+1
                k = 0
            }
            // substring indexed at i is greater than substring at j ,
            // we jump j to j+k+1 to check if any further substring is greater than substring at i
            else {
                j += k + 1
                k = 0
            }
        }
        // finally we return the substring from index i which points to largest character in the string S
        return s.substring(i)
    }
//}