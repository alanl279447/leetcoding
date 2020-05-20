package com.example.ArrayStrings;

public class IntegerReversal {
    public static void main(String[] args) {
        System.out.println("Testing main");

        //char[] input = "Testing".toCharArray();
        printReverse(12345);
    }

    public static int printReverse(int x) {
        int rev = 0;
        while(x > 0) {
            int temp = x % 10;
            if (rev == Integer.MAX_VALUE || rev >= Integer.MAX_VALUE/10 + temp)

            rev = rev * 10 + temp;
            x = x/10;
        }
        return rev;
    }
}
