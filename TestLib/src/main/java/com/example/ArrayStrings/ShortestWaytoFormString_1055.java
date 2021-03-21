package com.example.ArrayStrings;

import java.util.Arrays;

public class ShortestWaytoFormString_1055 {

//    Input: source = "xyz", target = "xzyxz"
//    Output: 3
//    Explanation: The target string can be constructed as follows "xz" + "y" + "xz".
//    https://leetcode.com/problems/shortest-way-to-form-string/
    public static void main(String[] args) {
        System.out.println(shortestWay("xyz", "xzyxz"));
//        System.out.println(shortestWayFast("xyz", "xzyxz"));
    }

    //0(m+n)
    //For example, if source = "xyzy", then dict[0]['y' - 'a'] = 1 but dict[2]['y'-'a'] = 3.
    public static int shortestWayFast(String source, String target) {
        char[] s = source.toCharArray();
        char[] t = target.toCharArray();

        int M = s.length;
        int N = t.length;

        // Build inverted index for source
        int[][] dict = new int[M][26];

        Arrays.fill(dict[M-1], -1); // -1 represents no occurrence of the character

        dict[M-1][s[M-1] - 'a'] = M-1;
        for(int x = M - 2; x >= 0; --x) {
            dict[x] = Arrays.copyOf(dict[x+1], 26);
            dict[x][s[x] - 'a'] = x;
        }

        int ans = 0;
        int idx = 0;
        // Go through target and account for each character
        for(char c: t) {
            // If there are no occurrences of c with index greater than 0
            // then it doesn't occur at all. Hence, we cannot get that letter from
            // a subsequence of source.
            if(dict[0][c - 'a'] == -1) return -1;

            // If there are no c's left in source that occur >= idx
            // but there are c's from earlier in the subsequence
            // add 1 to subsequence count and reset idx of source to 0.
            if(dict[idx][c - 'a'] == -1) {
                ++ans;
                idx = 0;
            }

            // Then continue taking letters from the subsequence
            idx = dict[idx][c-'a'] + 1;

            if(idx == M) {
                ++ans;
                idx = 0;
            }
        }

        return ans + (idx == 0? 0: 1);
    }


    //0(mn)
    public static int shortestWay(String source, String target) {
        int t = 0;
        int ans = 0;
        while (t < target.length()) {
            int pt = t;
            for (int s = 0; s < source.length(); s++) {
                if (t < target.length() && source.charAt(s) == target.charAt(t)) {
                    t++;
                }
            }
            if (t == pt) {
                return -1;
            }
            ans++;
        }
        return ans;
    }
}