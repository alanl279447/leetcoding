package com.example.DesignQuestions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinderMain {

//    addNum(1)
//    addNum(2)
//    findMedian() -> 1.5
//    addNum(3)
//    findMedian() -> 2

    public static void main(String[] args) {

        MedianFinder obj = new MedianFinder();
        obj.addNum(41);
        obj.addNum(35);
        obj.addNum(62);
        obj.addNum(5);
        obj.addNum(97);
        obj.addNum(108);
//        41, 35, 62, 5, 97, 108
        double param_2 = obj.findMedian();
        System.out.println(param_2);
    }

    //maxHeap   41
    //minHeap
    //median   41
    //41,35,62,5,97,108
    public static class MedianFinder {
        // max queue is always larger or equal to min queue
        PriorityQueue<Integer> min = new PriorityQueue();
        PriorityQueue<Integer> max = new PriorityQueue(1000, Collections.reverseOrder());
        // Adds a number into the data structure.
        public void addNum(int num) {
            max.add(num);
            min.add(max.remove());
            if (max.size() < min.size()){
                max.add(min.poll());
            }
            System.out.println(max.toString());
        }

        // Returns the median of current data stream
        public double findMedian() {
            if (max.size() == min.size()) {
                return (max.peek() + min.peek()) /  2.0;
            }
            else {
                return max.peek();
            }
        }
    };
}