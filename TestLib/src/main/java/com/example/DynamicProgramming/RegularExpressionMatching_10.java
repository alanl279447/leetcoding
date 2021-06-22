package com.example.DynamicProgramming;

public class RegularExpressionMatching_10 {
//    Input:
//    s = "aa"
//    p = "a"
//    Output: false
//    Explanation: "a" does not match the entire string "aa".
//
//    Input:
//    s = "aab"
//    p = "c*a*b"
//    Output: true
//    Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
//    https://leetcode.com/problems/regular-expression-matching/
//    https://leetcode.com/problems/regular-expression-matching/discuss/191830/Java-DP-solution-beats-100-with-explanation
//    Time complexity o(TP)


    public static void main(String[] args) {
        //int[][] nums1 = {{1,3}, {-2,2}};
        System.out.print(isMatch("caab", "c*a*b"));
    }
    //3 cases
    //T[i][j]   = T[i-1][j-1]    s.char[i] == p.charAt[j] OR p.char[j]=='.'
    //T[i][j]   = T[i][j-2]      p.charAt(j)=='*' &  0 occurance
               // T[i-1][j]      s.charAt(i-1) == p.charAt[j-1] || p.charAt[j-1] == .


    //T[i][j]   1.  s.charAt(i)==p.charAt(j)  OR p.charAt[i]=='.' t[i-1][j-1]
//              2.  p.charAt(i)=='*'
//                      T[i][j-2]   0 occurance
//                      T[i-1][j]   p[j-2]==s.charAt[i-1] || p[j-2]=='.'
//              3. s.charAt(i) != p.charAt[j]  false
//    https://leetcode.com/problems/regular-expression-matching/discuss/5651/Easy-DP-Java-Solution-with-detailed-Explanation


    public static boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() ==0) {
            return true;
        }
        char[] text = s.toCharArray();
        char[] pattern = p.toCharArray();
        boolean[][] T = new boolean[s.length()+1][p.length()+1];
        T[0][0] = true;
        for (int i=2; i < T[0].length; i++) {  //first row, pattern=='*'
            if (pattern[i-1] == '*') {
                T[0][i] = T[0][i-2];
            }
        }
        for (int i = 1; i < T.length; i ++) {
            for (int j=1; j < T[0].length; j++) {
                if(pattern[j-1] == '.' || pattern[j-1]==text[i-1]) {   //condition 1 to check
                    T[i][j] = T[i-1][j-1];
                } else if (pattern[j-1] == '*') {
                    T[i][j] = T[i][j-2];     //0 occurance
                    if (pattern[j-2] == '.' || text[i-1] == pattern[j-2]) {
                        T[i][j] = T[i][j] | T[i-1][j];           // pattern:  x a *       String:    x
                    }
                } else {
                    T[i][j] = false;
                }
            }
        }
        return T[s.length()][p.length()];
    }
}