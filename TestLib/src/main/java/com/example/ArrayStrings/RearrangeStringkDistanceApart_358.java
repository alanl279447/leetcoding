package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class RearrangeStringkDistanceApart_358 {
//    Input: s = "aaadbbcc", k = 2
//    Output: "abacabcd"
//    Explanation: The same letters are at least distance 2 from each other.
//    https://leetcode.com/problems/rearrange-string-k-distance-apart/

    public static void main(String args[]) {
        String res = rearrangeString("aaaadbbcc", 2);
        System.out.println(res);
    }

    public static String rearrangeString(String s, int k) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        // Use a max heap to do the greedy part
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
                (c1, c2) -> countMap.get(c2) - countMap.get(c1));
        maxHeap.addAll(countMap.keySet());

        // Use wait queue for each iteration of k elements
        Queue<Character> waitQueue = new LinkedList<>();

        StringBuilder rearranged = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Character current = maxHeap.poll();
            rearranged.append(current);
            countMap.put(current, countMap.get(current) - 1);
            waitQueue.offer(current);

            if (waitQueue.size() < k) {
                continue;
            }
            // Release from waitQueue if char is already k apart
            Character front = waitQueue.poll();
            if (countMap.get(front) > 0) {
                maxHeap.offer(front);
            }
        }

        return rearranged.length() == s.length() ? rearranged.toString() : "";
    }

}


//public class MovingAverage {
//    private double previousSum = 0.0;
//    private int maxSize;
//    private Queue<Integer> currentWindow;
//
//    public MovingAverage(int size) {
//        currentWindow = new LinkedList<Integer>();
//        maxSize = size;
//    }
//
//    public double next(int val) {
//        if (currentWindow.size() == maxSize)
//        {
//            previousSum -= currentWindow.remove();
//        }
//
//        previousSum += val;
//        currentWindow.add(val);
//        return previousSum / currentWindow.size();
//    }}
