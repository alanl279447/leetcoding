package com.example.ArrayStrings;

import java.util.Arrays;

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
        if(ratings == null || ratings.length == 0) return 0;

        int[] output = new int[ratings.length];
        Arrays.fill(output,1);

        for(int i =1 ; i < ratings.length ; i ++)
        {
            if(ratings[i] > ratings[i - 1])
            {
                output[i] = output[i-1] + 1;
            }
        }

        for(int i = ratings.length - 2 ; i >= 0 ; i --)
        {
            if(ratings[i] > ratings[i + 1])
            {
                output[i] = Math.max(output[i],output[i+1] + 1);
            }
        }

        int count = 0;
        for(int i = 0 ; i < output.length ; i ++)
        {
            count += output[i];
        }

        return count;
    }
}