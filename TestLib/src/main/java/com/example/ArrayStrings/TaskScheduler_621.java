package com.example.ArrayStrings;

import java.util.Arrays;

public class TaskScheduler_621 {
//    Input: tasks = ["A","A","A","B","B","B"], n = 2
//    Output: 8
//    Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
//      https://leetcode.com/problems/task-scheduler/

    public static void main(String args[]) {
        char[] input = {'A','A','A','B','B','B'};
        int result = leastInterval(input, 2);
        System.out.println(result);
    }

    public static int leastInterval(char[] tasks, int n) {
        int[] char_count = new int[26];
        for (char c: tasks) {
            char_count[c - 'A']++;
        }
        Arrays.sort(char_count);
        int maxValue = char_count[25] - 1;
        int idleSlots = maxValue * n;
        for (int i = 24; i >0; i--) {
            if (idleSlots > 0)
                idleSlots -= Math.min(char_count[i], maxValue);
        }
        return idleSlots >0 ? tasks.length+idleSlots: tasks.length;
    }
}