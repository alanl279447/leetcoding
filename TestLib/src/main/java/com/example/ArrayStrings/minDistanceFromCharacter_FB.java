package com.example.ArrayStrings;

//        Given "instagram" and "a" , output: [4,3,2,1,0,1,1,0,1]
//        https://leetcode.com/discuss/interview-question/600130/Facebook-or-phone-interview

import java.util.Arrays;

public class minDistanceFromCharacter_FB {


    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] result = minDistanceFromChar("instagram",  'a');
        for (int res: result)
         System.out.println(res);
    }

    public static int[] minDistanceFromChar(String input, char c) {
        int cur_val = Integer.MAX_VALUE;
        int[] arr = new int[input.length()];
        Arrays.fill(arr, Integer.MAX_VALUE);
        //iterate from left to right
        for(int i=0;i<input.length();i++)
        {
            if(input.charAt(i)=='a')
            {
                cur_val = 0;
            }
            arr[i]= Math.min(arr[i],cur_val) ;
            if(cur_val != Integer.MAX_VALUE)
                cur_val++;
        }
        //iterate from right to left
        for(int i=input.length()-1;i>=0;i--)
        {
            if(input.charAt(i)=='a')
            {
                cur_val = 0;
            }
            arr[i]= Math.min(arr[i],cur_val) ;
            if(cur_val != Integer.MAX_VALUE)
                cur_val++;
        }
        return arr;
    }
}