package com.example.DesignQuestions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DesignHitCounter_362 {
// HitCounter counter = new HitCounter();
//// hit at timestamp 1.
//counter.hit(1);
//
//// hit at timestamp 2.
//counter.hit(2);
//
//// hit at timestamp 3.
//counter.hit(3);
//
//// get hits at timestamp 4, should return 3.
//counter.getHits(4);
//
//// hit at timestamp 300.
//counter.hit(300);

//// get hits at timestamp 300, should return 4.
//counter.getHits(300);
// https://leetcode.com/problems/design-hit-counter/
    public static void main(String[] args) {
        HitCounter obj = new HitCounter();
        obj.hit(1);
        obj.hit(2);
        obj.hit(3);
        int param_1 = obj.getHits(4); //3
    }

    static class HitCounter {
        private int timeWindow;
        private Deque<HitPair> hits;    // hits.getFirst() is the oldest hit, hits.getLast() is the newest hit.

        /** Initialize your data structure here. */
        public HitCounter() {
            timeWindow = 60 * 5;        // 5 minutes
            hits = new ArrayDeque<>();
        }

        /** Record a hit.
         @param timestamp - The current timestamp (in seconds granularity). */
        public void hit(int timestamp) {
            if (hits.size() > 0 && hits.getLast().timestamp == timestamp) {
                hits.getLast().numHits++;
            } else {
                hits.addLast(new HitPair(timestamp, 1));
            }
            //removeTooOldHits(timestamp);
        }


        /** Return the number of hits in the past 5 minutes.
         @param timestamp - The current timestamp (in seconds granularity). */
        public int getHits(int timestamp) {
            removeTooOldHits(timestamp);
            int result = 0;
            for (HitPair currPair : hits) {     // assert(hits.size() <= 300);  // this loop is O(300) == O(1) because all too old hits have been removed
                result += currPair.numHits;
            }
            return result;
        }

        // Remove all hits that are too old. Return the number of removed hits.
        private int removeTooOldHits(int currTimestamp) {
            int hitsRemoved = 0;
            while (hits.size() > 0 && currTimestamp - hits.getFirst().timestamp >= timeWindow) {
                hits.removeFirst();
                hitsRemoved++;
            }
            return hitsRemoved;
        }

        // Use pairs to deal with many hits with the same timestamp.
        // Instead of having one element in the queue for each hit,
        // one element can now store many hits with the same timestamp.
        private class HitPair {
            int timestamp;
            int numHits;    // number of hits at that timestamp
            public HitPair(int timestamp, int numHits) {
                this.timestamp = timestamp;
                this.numHits = numHits;
            }
        }
    }

}