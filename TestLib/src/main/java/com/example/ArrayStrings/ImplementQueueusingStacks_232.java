package com.example.ArrayStrings;

import java.util.Stack;

public class ImplementQueueusingStacks_232 {

//MyQueue queue = new MyQueue();
//queue.push(1);
//queue.push(2);
//queue.peek();  // returns 1
//queue.pop();   // returns 1
//queue.empty(); // returns false
//https://leetcode.com/problems/implement-queue-using-stacks/

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
        System.out.println();
    }

    static class MyQueue {

        Stack<Integer> input=null;
        Stack<Integer> output=null;
        /** Initialize your data structure here. */
        public MyQueue() {
           input=new Stack<>();
           output=new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
          input.add(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            peek();
            return output.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (output.empty()) {
                while(!input.isEmpty()) {
                    output.add(input.pop());
                }
            }
            return output.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
          return input.empty() && output.empty();
        }
    }

}
