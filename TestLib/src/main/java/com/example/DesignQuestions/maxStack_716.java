package com.example.DesignQuestions;

import java.util.*;
//Explanation
//MaxStack stk = new MaxStack();
//stk.push(5);   // [5] the top of the stack and the maximum number is 5.
//stk.push(1);   // [5, 1] the top of the stack is 1, but the maximum is 5.
//stk.push(5);   // [5, 1, 5] the top of the stack is 5, which is also the maximum, because it is the top most one.
//stk.top();     // return 5, [5, 1, 5] the stack did not change.
//stk.popMax();  // return 5, [5, 1] the stack is changed now, and the top is different from the max.
//stk.top();     // return 1, [5, 1] the stack did not change.
//stk.peekMax(); // return 5, [5, 1] the stack did not change.
//stk.pop();     // return 1, [5] the top of the stack and the max element is now 5.
//stk.top();     // return 5, [5] the stack did not change.
//https://leetcode.com/problems/max-stack/

//Time Complexity: O(log N)O(logN) for all operations except peek which is O(1)O(1),
//        where NN is the number of operations performed. Most operations involving TreeMap are O(log N)O(logN).
//Space Complexity: O(N)O(N), the size of the data structures used.

public class maxStack_716 {

    public static void main(String[] args) {
        MaxStack obj = new MaxStack();
        obj.push(5);
        obj.push(1);
        obj.push(5);
        int top = obj.pop();
        int popMax1 = obj.popMax();
        int top2 = obj.pop();
        int peekMax1 = obj.peekMax();

        int param_2 = obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.peekMax();
        int param_5 = obj.popMax();
    }

  //DoubleLinkedList   head - 1 - 5 - Tail
  // TreeMap <Int, List<Node>>  1, Node2  -  5, Node1,Node3
  // tail DDL-tail-prev
  //popMax - TreeMap.lastKey get the first node 1
  //top tail.prev (without remove)
  //pop() - tail.prev remove

    static class MaxStack {
        TreeMap<Integer, List<Node>> map;
        DoubleLinkedList dll;

        public MaxStack() {
            map = new TreeMap();
            dll = new DoubleLinkedList();
        }

        public void push(int x) {
            Node node = dll.add(x);
            if (!map.containsKey(x))
                map.put(x, new ArrayList<Node>());
            map.get(x).add(node);
        }

        public int pop() {
            int val = dll.pop();
            List<Node> L = map.get(val);
            L.remove(L.size() - 1);
            if (L.isEmpty()) map.remove(val);
            return val;
        }

        public int top() {
            return dll.peek();
        }

        public int peekMax() {
            return map.lastKey();
        }

        public int popMax() {
            int max = peekMax();
            List<Node> L = map.get(max);
            Node node = L.remove(L.size() - 1);
            dll.unlink(node);
            if (L.isEmpty()) map.remove(max);
            return max;
        }

        class DoubleLinkedList {
            Node head, tail;

            public DoubleLinkedList() {
                head = new Node(0);
                tail = new Node(0);
                head.next = tail;
                tail.prev = head;
            }

            public Node add(int val) {
                Node x = new Node(val);
                x.next = tail;
                x.prev = tail.prev;
                tail.prev = tail.prev.next = x;
                return x;
            }

            public int pop() {
                return unlink(tail.prev).val;
            }

            public int peek() {
                return tail.prev.val;
            }

            public Node unlink(Node node) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                return node;
            }
        }

        class Node {
            int val;
            Node prev, next;

            public Node(int v) {
                val = v;
            }
        }
    }
}