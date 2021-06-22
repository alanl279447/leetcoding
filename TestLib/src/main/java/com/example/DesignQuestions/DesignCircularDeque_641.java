package com.example.DesignQuestions;


public class DesignCircularDeque_641 {

//MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
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
        MyCircularDeque circularDeque = new MyCircularDeque(3); // set the size to be 3
        circularDeque.insertLast(1);			// return true
        circularDeque.insertFront(3);			// return true
        circularDeque.insertLast(2);			// return true
//        circularDeque.insertFront(3);			// return true
        circularDeque.insertFront(4);			// return false, the queue is full
        circularDeque.getRear();  			// return 2
        circularDeque.isFull();				// return true
        circularDeque.getFront();           //3
        circularDeque.deleteLast();			// return true
        circularDeque.insertFront(4);			// return true
        circularDeque.getFront();			// return 4
    }

    //--front%k   addToFront
    //front<0 front+k
    //++front%k   deleteFromFRont

    //++Rear%K        addToRear
    //--Rear%k

    static class MyCircularDeque {
        int front = 0, rear = -1, len = 0, k = 0;
        int[] arr;
        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            arr = new int[k];
            this.k = k;
            rear = k-1;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if (isFull()) return false;
            front = --front % k;
            if (front < 0) front += k;
            arr[front] = value;
            len++;
            //if (len == 1) rear = front;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if (isFull()) return false;
            rear = ++rear % k;
            arr[rear] = value;
            len++;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if (isEmpty()) return false;
            front = ++front % k;
            len--;
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if (isEmpty()) return false;
            rear = --rear % k;
            if (rear < 0) rear += k;
            len--;
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            return isEmpty() ? -1 : arr[front];
        }

        /** Get the last item from the deque. */
        public int getRear() {
            return isEmpty() ? -1 : arr[rear];
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return len == 0;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return len == k;
        }
    }


}