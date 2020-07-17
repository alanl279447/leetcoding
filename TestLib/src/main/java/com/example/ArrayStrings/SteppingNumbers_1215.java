package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SteppingNumbers_1215 {
//    Input: low = 0, high = 21
//    Output: [0,1,2,3,4,5,6,7,8,9,10,12,21]
//    https://leetcode.com/problems/stepping-numbers/

    public static void main(String args[]) {
        int[] input = {0,1,2,3,4,5,6,7,8,9,10,12,21};
        List<Integer> res = countSteppingNumbers(0,21);
        for(Integer re: res) {
            System.out.println(re);
        }
    }

    public static ArrayList<Integer> countSteppingNumbers(int low, int high) {
        ArrayList<Integer> res = new ArrayList<>();
        if (low > high) return res;

        Queue<Long> queue = new LinkedList<>();
        for (long i = 1; i <= 9; i++) queue.add(i);

        if (low == 0) res.add(0);
        while (!queue.isEmpty()) {
            long p = queue.poll();
            if (p < high) {
                long last = p % 10;
                if (last > 0) queue.add(p * 10 + last - 1);
                if (last < 9) queue.add(p * 10 + last + 1);
            }
            if (p >= low && p <= high) {
                res.add((int) p);
            }
        }
        return res;
    }
}
