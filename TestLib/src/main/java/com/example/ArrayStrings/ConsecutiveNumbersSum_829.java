package com.example.ArrayStrings;

public class ConsecutiveNumbersSum_829 {

//    Input: 9
//    Output: 3
//    Explanation: 9 = 9 = 4 + 5 = 2 + 3 + 4
//    https://leetcode.com/problems/consecutive-numbers-sum/

//    let N = k + (k+1) + (k+2) + (k+3) + ... + (k+i-1) = i*k + (1+2+3+... + i-1)
//    let sum(i) = (1+2+3+...+i-1), then we have
//            N = sum(i) + i*k ==>i*k = N - sum(i)
//    Which means: for each i, we can calculate N-sum(i).
//    If N-sum(i) can be divided by i, there is an answer with length i.
//    Because, let k = (N - sum(i)) / i,
//    we can add an integer k to each of (0,1, 2, 3, 4, ...., i-1) to become (k, k+1, k+2, k+3,.... k + i-1)
//    that is: sum(i) + i * k = N
    public static void main(String[] args) {
        System.out.println(consecutiveNumbersSum(9));
    }

    public static int consecutiveNumbersSum(int N) {
        int sum = 0, ans = 0;
        for(int i = 1; sum < N; i++) {
            sum += i;
            if (((N-sum) % i) == 0)
                ans++;
        }
        return ans;
    }
}