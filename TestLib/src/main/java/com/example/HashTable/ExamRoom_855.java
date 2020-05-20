package com.example.HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class ExamRoom_855 {
//    Input: ["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
//    Output: [null,0,9,4,2,null,5]
//    Explanation:
//    ExamRoom(10) -> null
//    seat() -> 0, no one is in the room, then the student sits at seat number 0.
//    seat() -> 9, the student sits at the last seat number 9.
//    seat() -> 4, the student sits at the last seat number 4.
//    seat() -> 2, the student sits at the last seat number 2.
//    leave(4) -> null
//    seat() -> 5, the student sits at the last seat number 5.
//    https://leetcode.com/problems/exam-room/

//    seat(): Get the longest segment in pq, get the middle, update the pq
//    leave(): Iterate the pq, get the two segments beside the p, update the pq

    public static void main(String[] args) {
        ExamRoom obj = new ExamRoom(10);
        int seat1 = obj.seat();
        System.out.println(seat1);
        int seat2 = obj.seat();
        System.out.println(seat2);
        int seat3 = obj.seat();
        System.out.println(seat3);
        int seat4 = obj.seat();
        System.out.println(seat4);
        obj.leave(4);
    }

    static class ExamRoom {
        PriorityQueue<int[]> pq;
        int N;

        public ExamRoom(int N) {
            this.N = N;
            pq = new PriorityQueue<>((a, b) -> {
                int distA = intervalToDist(a);
                int distB = intervalToDist(b);
                if (distA != distB) {
                    return distB - distA;
                } else {
                    return a[0] - b[0];
                }
            });
            pq.add(new int[]{-1, N});
        }

        private int intervalToDist(int[] interval) {
            int dist = 0;
            if (interval[0] == -1) {
                dist = interval[1];
            } else if (interval[1] == N) {
                dist = N - 1 - interval[0];
            } else {
                dist = (interval[1] - interval[0]) / 2;
            }
            return dist;
        }

        public int seat() {
            int result = 0;
            int[] interval = pq.poll();
            if (interval[0] == -1) {
                result = 0;
            } else if (interval[1] == N) {
                result = N - 1 ;
            } else {
                result = interval[0] + (interval[1] - interval[0]) / 2;
            }
            pq.add(new int[]{interval[0], result});
            pq.add(new int[]{result, interval[1]});
            return result;
        }

        public void leave(int p) {
            int[] leftInterval = null;
            int[] rightInterval = null;
            for (int[] interval : pq) {
                if (interval[1] == p) {
                    leftInterval = interval;
                }
                if (interval[0] == p) {
                    rightInterval = interval;
                }
            }
            pq.remove(leftInterval);
            pq.remove(rightInterval);
            pq.add(new int[]{leftInterval[0], rightInterval[1]});
        }
    }

}
