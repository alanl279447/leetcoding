package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class EditDistance_72 {
//    Input: word1 = "intention", word2 = "execution"
//    Output: 5
//    Explanation:
//    intention -> inention (remove 't')
//    inention -> enention (replace 'i' with 'e')
//    enention -> exention (replace 'n' with 'x')
//    exention -> exection (replace 'n' with 'c')
//    exection -> execution (insert 'u')
//    https://leetcode.com/problems/edit-distance/
//   time complexity 0(mn)
//    f(i, j - 1) represents insert operation
//    f(i - 1, j) represents delete operation
//    f(i - 1, j - 1) represents replace operation

    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        System.out.print(minDistance("intention", "execution")); //abac, abca
    }

    public static int minDistance(String word1, String word2) {
        char[] str1 = word1.toCharArray(), str2 = word2.toCharArray();
        int temp[][] = new int[str1.length+1][str2.length+1];

        for(int i=0; i < temp[0].length; i++){
            temp[0][i] = i;
        }

        for(int i=0; i < temp.length; i++){
            temp[i][0] = i;
        }

        for(int i=1;i <=str1.length; i++){
            for(int j=1; j <= str2.length; j++){
                if(str1[i-1] == str2[j-1]){
                    temp[i][j] = temp[i-1][j-1];
                }else{
                    temp[i][j] = 1 + min(temp[i-1][j-1], temp[i-1][j], temp[i][j-1]);
                }
            }
        }
        return temp[str1.length][str2.length];
    }

    private static int min(int a,int b, int c){
        int l = Math.min(a, b);
        return Math.min(l, c);
    }
}
