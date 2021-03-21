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
        MyStackTest obj = new MyStackTest();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        int param_2 = obj.pop();
        System.out.println(param_2); //3
        int param_3 = obj.top();
        System.out.println(param_3); //2
        boolean param_4 = obj.empty();
        System.out.println(param_4); //false
        System.out.println();
    }

    //using single queue
    static class MyStack {
        //one Queue solution
        private Queue<Integer> q = new LinkedList<Integer>();

        // Push element x onto stack.
        public void push(int x) {
            q.add(x);
            for(int i = 1; i < q.size(); i++) { //rotate the queue to make the tail be the head
                Integer item = q.poll();
                q.add(item);
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

    //using two queue
    static class MyStackTest {
        private Queue<Integer> q1 = new LinkedList<>();
        private Queue<Integer> q2 = new LinkedList<>();
        private int top;

        // Push element x onto stack.
        public void push(int x) {
            q1.add(x);
            top = x;
        }

        // Removes the element on top of the stack.
        public int pop() {
            while (q1.size() > 1) {
                top = q1.remove();
                q2.add(top);
            }
            int result = q1.remove();
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
            return result;
        }

        public int top() {
            return top;
        }

        public boolean empty() {
            return q1.size() == 0;
        }

    }


}
