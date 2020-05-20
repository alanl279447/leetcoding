package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class getTotalTime_FB {

//    For example, given the list [1, 2, 3, 4, 5], we could choose 4 and 5 for the first operation,
//    which would transform the list into [1, 2, 3, 9] and incur a cost of 9.
//    Signature:
//    int getTotalTime(int[] arr)
//    Input:
//    An array arr containing N integers, denoting the numbers in the list.
//     https://leetcode.com/discuss/interview-question/590101/Facebook-Interview-Question-or-Slow-Sum

    public static void main(String[] args) {
        //int[] nums = {2,3,1,1,4};
        int[] nums = {2,3,9,8,4};
        System.out.println(getTotalTime(nums));
    }

    static int getTotalTime(int[] arr) {
        // Write your code here
        List<Integer> list = new ArrayList();
        for (int num: arr) {
            list.add(num);
        }
        int count = 0;
        int max = 0;
        int maxI = -1;
        while (list.size() > 1) {
            int sum = 0;
            max = 0;
            for (int i = 1; i < list.size(); i++) {
                sum = list.get(i - 1) + list.get(i);
                if (sum > max) {
                    max = sum;
                    maxI = i;
                }
            }
            list.remove(maxI);
            list.set(maxI - 1, max);
            count += max;
        }
        return count;
    }

}
