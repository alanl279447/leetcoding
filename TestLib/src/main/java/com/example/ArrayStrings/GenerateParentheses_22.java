package com.example.ArrayStrings;

//       [
//        "((()))",
//        "(()())",
//        "(())()",
//        "()(())",
//        "()()()"
//        ]
// time complexity  O(2^(2n))

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {

    public static void main(String[] args) {

        List<String> result = generateParenthesis(3);
        for (String res: result) {
            System.out.println(res);
        }
    }

    //max - 2n  (n = 3, 2n = 6)
    //open <= n, closing <= open
    //((()))
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    static int count = 0;
    public static void backtrack(List<String> ans, String cur, int open, int close, int max){
        System.out.println(count++);
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }
        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }
}