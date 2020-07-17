package com.example.ArrayStrings;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ImplementStackusingQueues_225 {

//    MyStack stack = new MyStack();
//
//stack.push(1);
//stack.push(2);
//stack.top();   // returns 2
//stack.pop();   // returns 2
//stack.empty(); // returns false
//    https://leetcode.com/problems/implement-stack-using-queues/

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        int param_2 = obj.pop();
        System.out.println(param_2);
        int param_3 = obj.top();
        System.out.println(param_3);
        boolean param_4 = obj.empty();
        System.out.println(param_4);
        System.out.println();
    }

    static class MyStack {

        //one Queue solution
        private Queue<Integer> q = new LinkedList<Integer>();

        // Push element x onto stack.
        public void push(int x) {
            q.add(x);
            for(int i = 1; i < q.size(); i ++) { //rotate the queue to make the tail be the head
                q.add(q.poll());
            }
        }

        // Removes the element on top of the stack.
        public int pop() {
           return q.poll();
        }

        // Get the top element.
        public int top() {
            return q.peek();
        }

        // Return whether the stack is empty.
        public boolean empty() {
            return q.isEmpty();
        }
    }
}
