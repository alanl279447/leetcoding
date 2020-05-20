package com.example.ArrayStrings;

//       [
//        "((()))",
//        "(()())",
//        "(())()",
//        "()(())",
//        "()()()"
//        ]
// time complexity  O(2^(2n))

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {

    public static void main(String[] args) {

        List<String> result = generateParenthesis(3);
        for (String res: result) {
            System.out.println(res);
        }
    }

    public static List<String> generateParenthesisPrac(int n) {

        List<String> result = new ArrayList<>();
        helper(result, n, new StringBuilder(), 0, 0);
        return result;
    }

    public static void helper(List<String> result, int n, StringBuilder sb, int openParam, int closeParam) {
        if (sb.length()==2*n) {
            result.add(sb.toString());
        } else {
            if (openParam < n) {
                helper(result, n, sb.append('('), openParam+1, closeParam);
            }
            if (closeParam<openParam) {
                helper(result, n, sb.append(')'), openParam, closeParam+1);
            }
        }
    }


    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public static void backtrack(List<String> ans, String cur, int open, int close, int max){
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
