package com.example.LinkedList;

import java.util.Random;

public class LinkedListRandomNode_382 {

    // Init a singly linked list [1,2,3].
//    ListNode head = new ListNode(1);
//    head.next = new ListNode(2);
//    head.next.next = new ListNode(3);
//    Solution solution = new Solution(head);
//
//    // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
//    solution.getRandom();
//    https://leetcode.com/problems/linked-list-random-node/

//    When we read the first node head, if the stream ListNode stops here,
//    we can just return the head.val. The possibility is 1/1.
//
//    When we read the second node, we can decide if we replace the result r or not.
//    The possibility is 1/2. So we just generate a random number between 0 and 1, and check if it is equal to 1.
//    If it is 1, replace r as the value of the current node, otherwise we don't touch r,
//    so its value is still the value of head.

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);

        Solution obj = new Solution(node1);
        int param_1 = obj.getRandom();
        System.out.println("val: "+param_1);
    }

    static class Solution {
        ListNode head;
        Random random;
        /** @param h The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode h) {
            head = h;
            random = new Random();
        }

        /** Returns a random node's value. */
        public int getRandom() {
            ListNode c = head;
            int r = c.val;

            for (int i = 1; c.next!= null; i++) {
                c = c.next;
                if (random.nextInt(i+1) == i) {  //nextInt is from 0 (inclusive) to bound (exclusive))
                    r = c.val;
                }
            }
            return r;
        }
    }

    public static class ListNode {
      int val;
      ListNode next;
      public ListNode(int x) { val = x; }
  }

}
