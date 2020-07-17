package com.example.ArrayStrings;

public class Candy_135 {
//    Input: [1,2,2]
//    Output: 4
//    Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
//    The third child gets 1 candy because it satisfies the above two conditions.
//    https://leetcode.com/problems/candy/

    public static void main(String[] args) {
        int[] ratings = {1,2,2};
        System.out.println(candy(ratings));
    }

    public static int candy(int[] ratings) {
        if (ratings==null || ratings.length==0) return 0;
        int result = 0;
        return result;
    }
}