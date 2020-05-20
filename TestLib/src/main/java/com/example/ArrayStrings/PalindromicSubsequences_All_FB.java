package com.example.ArrayStrings;

//Input : str = "abcd"
//        Output : 4
//        Explanation :- palindromic  subsequence are : "a" ,"b", "c" ,"d"
//
//        Input : str = "aab"
//        Output : 4
//        Explanation :- palindromic subsequence are :"a", "a", "b", "aa"
//
//        Input : str = "aaaa"
//        Output : 15
//        https://www.geeksforgeeks.org/count-palindromic-subsequence-given-string/

import java.util.HashSet;
import java.util.Set;

public class PalindromicSubsequences_All_FB {

    // Driver program
//    public static void main(String args[]) {
//        Set<String> result = LongestPalindromeSubseq("abaaa");
//        for (String res : result) {
//            System.out.println(res);
//        }
//    }

    // Driver program
    public static void main(String args[])
    {
        String str = "abcb";
        System.out.println("Total palindromic "+ "subsequence are : " + countPS(str));
    }


    static int countPS(String str) {
        int N = str.length();

        // create a 2D array to store the count
        // of palindromic subsequence
        int[][] cps = new int[N + 1][N + 1];

        // palindromic subsequence of length 1
        for (int i = 0; i < N; i++) {
            cps[i][i] = 1;
            System.out.println(str.charAt(i));
        }

        // check subsequence of length L is
        // palindrome or not
        for (int L = 2; L <= N; L++) {
            for (int i = 0; i < N; i++) {
                int k = L + i - 1;
                if (k < N) {
                    if (str.charAt(i) == str.charAt(k)) {
                        cps[i][k] = cps[i][k - 1] + cps[i + 1][k] + 1;
                    }
                    else {
                        cps[i][k] = cps[i][k - 1] + cps[i + 1][k] - cps[i + 1][k - 1];
                    }
                }
            }
        }

        // return total palindromic subsequence
        return cps[0][N - 1];
    }

}
