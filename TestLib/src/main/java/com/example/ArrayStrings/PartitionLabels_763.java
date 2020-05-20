package com.example.ArrayStrings;

//Input: S = "ababcbacadefegdehijhklij"
//        Output: [9,7,8]
//        Explanation:
//        The partition is "ababcbaca", "defegde", "hijhklij".
//        This is a partition so that each letter appears in at most one part.
//        A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
//        https://leetcode.com/problems/partition-labels/

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels_763 {

    public static void main(String[] args) {
        String a = "ababcbacadefegdehijhklij";
        List<Integer> result = partitionLabels(a);
        System.out.println(result);
    }

    public static List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;

        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }
}
