package com.example.DesignQuestions;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class DesignCircularQueue_622 {

//    MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
//circularQueue.enQueue(1);  // return true
//circularQueue.enQueue(2);  // return true
//circularQueue.enQueue(3);  // return true
//circularQueue.enQueue(4);  // return false, the queue is full
//circularQueue.Rear();  // return 3
//circularQueue.isFull();  // return true
//circularQueue.deQueue();  // return true
//circularQueue.enQueue(4);  // return true
//circularQueue.Rear();  // return 4
//    https://leetcode.com/problems/design-circular-queue/

    public static void main(String[] args) {
//        addNode(1);
        MyCircularQueue obj = new MyCircularQueue(3);
        boolean param_1 = obj.enQueue(1);
        boolean param_2 = obj.enQueue(2);
        boolean param_3 = obj.enQueue(3);
//        boolean param_4 = obj.enQueue(4);
        boolean param_5 = obj.deQueue();
        boolean param_4 = obj.enQueue(4);
        int param_6 = obj.Front();
        int param_7 = obj.Rear();
        boolean param_8 = obj.isEmpty();
        boolean param_9 = obj.isFull();
    }

    //int[] queue
    //int head
    //int count
    //int capacity
    static class MyCircularQueue {
        private int[] queue;
        private int headIndex;
        private int count;
        private int capacity;

        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            this.capacity = k;
            this.queue = new int[k];
            this.headIndex = 0;   //points to the first element in the queue.
            this.count = 0;       //number of eleements in the queue.
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if (this.count == this.capacity)
                return false;
            this.queue[(this.headIndex + this.count) % this.capacity] = value;
            this.count += 1;
            return true;
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if (this.count == 0)
                return false;
            this.headIndex = (this.headIndex + 1) % this.capacity;
            this.count -= 1;
            return true;
        }

        /** Get the front item from the queue. */
        public int Front() {
            if (this.count == 0)
                return -1;
            return this.queue[this.headIndex];
        }


        /** Get the last item from the queue. */
        public int Rear() {
            if (this.count == 0)
                return -1;
            int tailIndex = (this.headIndex + this.count - 1) % this.capacity;
            return this.queue[tailIndex];
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return (this.count == 0);
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return (this.count == this.capacity);
        }
    }

}