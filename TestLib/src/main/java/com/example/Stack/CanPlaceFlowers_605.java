package com.example.Stack;

//Input: flowerbed = [1,0,0,0,1], n = 1
//Output: true
//https://leetcode.com/problems/can-place-flowers/

public class CanPlaceFlowers_605 {
    public static void main(String[] args) {
        int[] T = {1,0,0,0,1};
        boolean result = canPlaceFlowers(T, 1);
        System.out.print(result);
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
       int len = flowerbed.length, i = 0, count =0;
       while (i < len && count < n) {
           if (flowerbed[i]==0 && (i ==0 || flowerbed[i-1] ==0) && (i==len-1 || flowerbed[i+1] ==0)) {
               flowerbed[i]=1;
               count++;
           }
           i++;
       }
      return count >= n;
    }
}