package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.List;

public class LinkedListCycle_141 {

//    Input: head = [3,2,0,-4], pos = 1
//    Output: true
//    Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
//    https://leetcode.com/problems/linked-list-cycle/

    public static ListNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(0);
        node1.next.next.next = new ListNode(-4);
        node1.next.next.next.next = new ListNode(2);
        System.out.print(hasCycle(node1));
    }

    public static boolean hasCycle(ListNode head) {
       ListNode walker = head, runner = head;
       while(runner != null && runner.next != null) {
           walker = walker.next;
           runner = runner.next.next;
           if (walker == runner) return true;
       }
       return false;
    }

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) { val = x; }
    }
}