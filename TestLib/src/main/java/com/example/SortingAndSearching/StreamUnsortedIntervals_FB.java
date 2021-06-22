package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class StreamUnsortedIntervals_FB {

//    dm = DownloadManager(11)
//        dm.add([10, 11]) -> false
//        dm.add([7, 8]) -> false
//        dm.add([2, 5]) -> false
//        dm.add([0, 3]) -> false
//        dm.add([6, 9]) -> true
//    https://leetcode.com/discuss/interview-question/1140838/Facebook-Stream-of-Unsorted-Intervals
    public static void main(String[] args) {
        DownloadManager dm = new DownloadManager(11);
        System.out.println(dm.add( new int[] {10, 11}));
        System.out.println(dm.add( new int[] {7, 8}));
        System.out.println(dm.add( new int[] {2, 5}));
        System.out.println(dm.add( new int[] {0, 3}));
        System.out.println(dm.add( new int[] {6, 9}));
    }

    static class DownloadManager {
        private PriorityQueue<int[]> pq;
        int n;

        public DownloadManager(int n) {
            pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
            this.n = n;
        }

        public boolean add(int[] interval) {
            if (interval == null || interval.length != 2)
                return false;
            pq.add(interval);
            if (pq.size() > 1)
                mergeIntervals(pq);
            System.out.println(pq.size());
            if (pq.size() == 1) {
                if (pq.peek()[0] == 0 && pq.peek()[1] == n)
                    return true;
            }
            return false;
        }

        private void mergeIntervals(PriorityQueue<int[]> pq) {
            LinkedList<int[]> merged = new LinkedList<>();
            while (!pq.isEmpty()) {
                int[] interval = pq.poll();
                if (merged.isEmpty() || merged.getLast()[1] < interval[0] - 1)
                    merged.addLast(interval);
                else
                    merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
            pq.addAll(merged);
        }
    }
}