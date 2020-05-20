package com.example.ArrayStrings;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisiblebyK_974 {

//    Input: A = [4,5,0,-2,-3,1], K = 5
//    Output: 7
//    Explanation: There are 7 subarrays with a sum divisible by K = 5:
//            [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
//    https://leetcode.com/problems/subarray-sums-divisible-by-k/

//    x=-13 & k=5 ... then the (-13) % 5 =-3 ( which is not an valid array index)
//    Now, to eliminate this...
//    we do... ( ( (-13) % 5) + 5) % 5 -> which will add -3+5 and result=2(valid index)

    public static void main(String args[]) {
        int[] input = {4, 5,0,-2,-3,1};
        int res = subarraysDivByK(input, 5);
        System.out.println(res);
    }

    public static int subarraysDivByK(int[] A, int K) {
        int ans = 0, sum = 0;
        // map from cumulative sum's modulo to its appear times
        int[] map = new int[K];
        // empty array's modulo is 0
        map[0] = 1;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            int index = (sum % K + K) % K;
            ans += map[index];
            map[index]++;
        }
        return ans;
    }

    public static int subarraysDivByKPractice(int[] A, int K) {
        int[] map = new int[K];
        int answer = 0, sum = 0;
        map[0] = 1;

        for (int i=0;i<A.length;i++) {
            sum +=A[i];
            int index = (sum%K+K)%K;
            answer += map[index];
            map[index]++;
        }
        return answer;
    }
}
