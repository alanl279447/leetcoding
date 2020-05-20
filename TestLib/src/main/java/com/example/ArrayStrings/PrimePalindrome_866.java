package com.example.ArrayStrings;

public class PrimePalindrome_866 {

//    Input: 6
//    Output: 7
//    https://leetcode.com/problems/prime-palindrome/

    public static void main(String[] args) {

        int count = 13;
        System.out.println(primePalindrome(count));
    }

    public static int primePalindrome(int N) {
        while (true) {
            if (N == reverse(N) && isPrime(N))
                return N;
            N++;
            if (10000000 < N && N < 100000000)
                N = 100000000;
        }
    }

    public static boolean isPrime(int N) {
        if (N < 2) return false;
        int R = (int) Math.sqrt(N);
        for (int d = 2; d <= R; ++d)
            if (N % d == 0) return false;
        return true;
    }

    public static int reverse(int N) {
        int ans = 0;
        while (N > 0) {
            ans = 10 * ans + (N % 10);
            N /= 10;
        }
        return ans;
    }

}
