package com.example.DynamicProgramming;

public class CanIWin_464 {
//
//    https://leetcode.com/problems/can-i-win/
//    Input: maxChoosableInteger = 10, desiredTotal = 11
//    Output: false
//    Explanation:
//    No matter which integer the first player choose, the first player will lose.
//    The first player can choose an integer from 1 up to 10.
//    If the first player choose 1, the second player can only choose integers from 2 up to 10.
//    The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
//    Same with other integers chosen by the first player, the second player will always win.

//    https://leetcode.com/problems/can-i-win/discuss/95277/Java-solution-using-HashMap-with-detailed-explanation : nice explanation of choosing state and it’s representation.
//    https://leetcode.com/problems/can-i-win/discuss/155321/DFS-with-Memorization-Java-with-Explanations : same ^.

    public static void main(String[] args) {
        boolean res = canIWin(10, 11);
        System.out.println(res);
    }

    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
         return false;
    }

}
