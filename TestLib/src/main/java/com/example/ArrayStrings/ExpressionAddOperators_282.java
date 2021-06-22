package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExpressionAddOperators_282 {
//    Input: num = "123", target = 6
//    Output: ["1+2+3", "1*2*3"]
//    https://leetcode.com/problems/expression-add-operators/
//   Time complexity 0(4^N).
//    https://leetcode.com/problems/expression-add-operators/discuss/71895/Java-Standard-Backtrace-AC-Solutoin-short-and-clear

    public static void main(String args[]) {
//        List<String> res = addOperators("123", 6);
        List<String> res = addOperators("105", 5);
        for(String re: res) {
            System.out.println(re);
        }
    }

    public static List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<String>();
        if(num == null || num.length() == 0) return rst;
        helper(rst, "", num, target, 0, 0, 0);
        return rst;
    }

    public static void helperTest(List<String> rst, String path, String num, int target, int pos, long eval, long multed){
        if (pos == num.length()) {
            if (target == eval) {
                rst.add(path);
            }
            return;
        } else {
         for (int i = pos; i < num.length(); i++) {
             if (i != pos && num.charAt(pos)== '0') continue;
             long temp = Long.parseLong(num.substring(pos, i+1));

             if (pos ==0) {
                 helperTest(rst, path+temp, num, target, i+1, eval+temp, temp);
             } else {

             }
         }
        }
    }


//    Input: num = "105", target = 5
//    Output: ["1*0+5","10-5"]

//    overflow: we use a long type once it is larger than Integer.MAX_VALUE or minimum, we get over it.
//    0 sequence: because we can't have numbers with multiple digits started with zero, we have to deal with it too.
//    a little trick is that we should save the value that is to be multiplied in the next recursion.
//    (1 + 2 + 3) - 3 + (3 * 4).
    public static void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed){
        if(pos == num.length()) {
            if(target == eval)
                rst.add(path);
            return;
        }
        for(int i = pos; i < num.length(); i++){
            if(i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
//            System.out.println("path is: +"+path);
            if(pos == 0){
                helper(rst, path + cur, num, target, i + 1, cur, cur);
            }
            else{
                helper(rst, path + "+" + cur, num, target, i + 1, eval + cur , cur);
                helper(rst, path + "-" + cur, num, target, i + 1, eval -cur, -cur);
                helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur );
            }
        }
    }
}