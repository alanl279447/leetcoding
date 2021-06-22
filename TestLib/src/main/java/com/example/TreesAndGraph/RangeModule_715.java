package com.example.TreesAndGraph;

import java.util.TreeMap;

//        addRange(int left, int right) Adds the half-open interval [left, right), tracking every real number in that interval. Adding an interval that partially overlaps with currently tracked numbers should add any numbers in the interval [left, right) that are not already tracked.
//        queryRange(int left, int right) Returns true if and only if every real number in the interval [left, right) is currently being tracked.
//        removeRange(int left, int right) Stops tracking every real number currently being tracked in the interval [left, right).
//        addRange(10, 20): null
//        removeRange(14, 16): null
//        queryRange(10, 14): true (Every number in [10, 14) is being tracked)
//        queryRange(13, 15): false (Numbers like 14, 14.03, 14.17 in [13, 15) are not being tracked)
//        queryRange(16, 17): true (The number 16 in [16, 17) is still being tracked, despite the remove operation)
//       [0, 5) = 0, 1, 2, 3, 4

public class RangeModule_715 {

    public static void main(String[] args) {
        RangeModule rm = new RangeModule();
        rm.addRange(10, 20);
        rm.removeRange(14, 16);
        System.out.println(rm.queryRange(10, 14));   //true
        System.out.println(rm.queryRange(13, 15));   //false
        System.out.println(rm.queryRange(16, 17));   //true
    }

    static class RangeModule {
        TreeMap<Integer, Integer> intervals = null;
        public RangeModule() {
            intervals = new TreeMap<>();;
        }

        public void addRange(int left, int right) {
            Integer start = intervals.floorKey(left);
            Integer end = intervals.floorKey(right);
            if(start != null && intervals.get(start) >= left){
                left = start;
            }
            if(end != null && intervals.get(end) > right){
                right = intervals.get(end);
            }
            intervals.put(left, right);
            // clean up intermediate intervals
            intervals.subMap(left, false, right, true).clear();
        }

        public boolean queryRange(int left, int right) {
            Integer start = intervals.floorKey(left);
            if(start == null) return false;
            return intervals.get(start) >= right;
        }

        public void removeRange(int left, int right) {
            Integer start = intervals.floorKey(left);
            Integer end = intervals.floorKey(right);

            if(end != null && intervals.get(end) > right){
                intervals.put(right, intervals.get(end));
            }
            if(start != null && intervals.get(start) > left){
                intervals.put(start, left);
            }
            intervals.subMap(left, true, right, false).clear();
        }
    }
}