package com.example.TreesAndGraph;

public class Powxn_50 {
//    Implement pow(x, n), which calculates x raised to the power n (x^n).
//    Input: 2.00000, 10
//    Output: 1024.00000
//    https://leetcode.com/problems/powx-n/

    public static void main(String[] args) {
        int x = 9;
        System.out.print(myPow(2.0, 3));
    }

    //absN = abs(3); //0011
    //absN&1==1 ans *=num;
    //x *=x;
    //absN>>1;
    public static double myPow(double x, int n) {
        double ans = 1;
        long absN = Math.abs((long)n);
        while(absN > 0) {
            if((absN&1)==1) {
                ans *= x;
            }
            absN >>= 1;
            x *= x;
        }
        return n < 0 ?  1/ans : ans;
    }
}