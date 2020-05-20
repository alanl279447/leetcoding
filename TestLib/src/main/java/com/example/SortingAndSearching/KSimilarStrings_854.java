package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class KSimilarStrings_854 {
//    Input: A = "aabc", B = "abca"
//    Output: 2
//    https://leetcode.com/problems/k-similar-strings/

    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        System.out.print(kSimilarity("aabc", "abca")); //abac, abca
    }

    public static int kSimilarity(String A, String B) {
        if (A.equals(B)) return 0;
        Set<String> vis= new HashSet<>();
        Queue<String> q= new LinkedList<>();
        q.add(A);
        vis.add(A);
        int res=0;
        while(!q.isEmpty()){
            res++;
            for (int sz=q.size(); sz>0; sz--){
                String s= q.poll();
                int i=0;
                while (s.charAt(i)==B.charAt(i)) i++;
                for (int j=i+1; j<s.length(); j++){
                    if (s.charAt(j)==B.charAt(j) || s.charAt(j)!=B.charAt(i) ) continue;
                    String temp= swap(s, i, j);
                    if (temp.equals(B)) {
                        return res;
                    }
                    if (vis.add(temp)) {
                        q.add(temp);
                    }
                }
            }
        }
        return res;
    }

    public static String swap(String s, int i, int j){
        char[] ca=s.toCharArray();
        char temp=ca[i];
        ca[i]=ca[j];
        ca[j]=temp;
        return new String(ca);
    }
}
