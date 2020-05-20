package com.example.ArrayStrings;

public class CountPrimes_204 {
//    Input: 10
//    Output: 4
//    Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
//    https://leetcode.com/problems/count-primes/
//    Time complexity 0(n*loglogn)
//     Sieve of Eratosthenes

    public static void main(String args[]) {
        int result = countPrimes( 10);
        System.out.println(result);
    }

    public static int countPrimes(int n) {
        if (n <=1) return 0;
        int[] primes = new int[n+1];
        for (int i=2;i<n;i++) {
           primes[i]=1;
        }
        for (int i=2; i<Math.sqrt(n);i++) {
            if (primes[i]==1) {
                for (int j=2; i*j<n;j++) {
                    primes[i*j]=0;
                }
            }
        }
        int count=0;
        for (int i=2;i<n;i++) {
            if (primes[i]==1) {
                count++;
            }
        }
      return count;
    }
}
