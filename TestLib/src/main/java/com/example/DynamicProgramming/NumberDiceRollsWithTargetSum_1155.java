package com.example.DynamicProgramming;

import java.util.HashMap;

public class NumberDiceRollsWithTargetSum_1155 {

//    Input: d = 2, f = 6, target = 7
//    Output: 6
//    Explanation:
//    You throw two dice, each with 6 faces.  There are 6 ways to get a sum of 7:
//            1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
//    https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/

    public static void main(String[] args) {
        System.out.print(numRollsToTarget(2,6,7));
    }

    static int MOD = 1000000000+7;
    static HashMap<String, Integer> map = new HashMap<>();
    public static int numRollsToTarget(int d, int f, int target) {
         if (d==0 && target ==0) {
             return 1;
         }
         if (d==0 || target ==0) {
             return 0;
         }
         String key = d+""+target;
         if (map.containsKey(key)) {
             return map.get(key);
         }
         int res = 0;
         for (int i=1; i<=f; i++) {
             if (target>i) {
                 res = res+numRollsToTarget(d-1, f, target-i) %MOD;
             } else {
                 break;
             }
         }
         map.put(key, res);
         return res;
    }

}
