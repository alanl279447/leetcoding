package com.example.HashTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class EmployeeFreeTime_759 {

//    Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
//    Output: [[3,4]]
//    Explanation: There are a total of three employees, and all common
//    free time intervals would be [-inf, 1], [3, 4], [10, inf].
//    We discard any intervals that contain inf as they aren't finite.
//    https://leetcode.com/problems/employee-free-time/

    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {

        List<List<Interval>> intervals =  new ArrayList<>();

        List<Interval> first = new ArrayList<>();
        first.add(new Interval(1,2));
        first.add(new Interval(5,6));
        intervals.add(first);

        List<Interval> second = new ArrayList<>();
        second.add(new Interval(1,3));
        intervals.add(second);

        List<Interval> third = new ArrayList<>();
        third.add(new Interval(4,10));
        intervals.add(third);

        List<Interval> result = employeeFreeTime(intervals);
        for (Interval res: result) {
            System.out.print(res.start +" "+res.end);
        }
    }

    public static List<Interval> employeeFreeTime(List<List<Interval>> avails) {

        List<Interval> result = new ArrayList<>();

        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
        avails.forEach(e -> pq.addAll(e));

        Interval temp = pq.poll();
        while(!pq.isEmpty()) {
            if(temp.end < pq.peek().start) { // no intersect
                result.add(new Interval(temp.end, pq.peek().start));
                temp = pq.poll(); // becomes the next temp interval
            }else { // intersect or sub merged
                temp = temp.end < pq.peek().end ? pq.peek() : temp;
                pq.poll();
            }
        }
        return result;
    }

    public static class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    };
}
