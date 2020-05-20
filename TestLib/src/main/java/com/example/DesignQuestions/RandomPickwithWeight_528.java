package com.example.DesignQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPickwithWeight_528 {

//    Given an array w of positive integers, where w[i] describes the weight of index i,
//    write a function pickIndex which randomly picks an index in proportion to its weight.
//   https://leetcode.com/problems/random-pick-with-weight/

    public static void main(String[] args) {

        int[] nums = new int[] {1,3,1,5};
        SolutionPrac minStack = new SolutionPrac(nums);
        System.out.println(minStack.pickIndex());
    }

    public static class SolutionPrac {

        List<Integer> weightedSum = null;
        int total = 0;
        Random random = null;
        public SolutionPrac(int[] ws) {
            weightedSum = new ArrayList<>();
            random = new Random();
           for (int w: ws) {
               total +=w;
               weightedSum.add(total);   //1,4,5,10
           }
        }

        public int pickIndex() {
            int index = 7;//andom.nextInt(total);
            int lo = 0;
            int high = weightedSum.size() - 1;

            while (lo <= high) {
                int mid = lo + (high - lo) / 2;
                if (lo==high) break;
                if (index > weightedSum.get(mid)) {
                    lo = mid + 1;
                } else {
                    high = mid;
                }
            }
            return lo;
        }
    }

    public static class Solution {

        List<Integer> psum = new ArrayList<>();
        int tot = 0;
        Random rand = new Random();

        public Solution(int[] w) {
            for (int x : w) {
                tot += x;
                psum.add(tot);
            }
        }
        // psum 1,4,5,10
        public int pickIndex() {
            int targ = 7;//rand.nextInt(tot);
            int lo = 0;
            int hi = psum.size() - 1;
            while (lo != hi) {
                int mid = (lo + hi) / 2;
                if (targ >= psum.get(mid)) {
                    lo = mid + 1;
                }
                else {
                    hi = mid;
                }
            }
            return lo;
        }
    }
}
