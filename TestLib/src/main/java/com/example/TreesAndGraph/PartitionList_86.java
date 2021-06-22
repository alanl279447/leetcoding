package com.example.TreesAndGraph;

//https://leetcode.com/problems/partition-list/
//        Input: head = [1,4,3,2,5,2], x = 3
//        Output: [1,2,2,4,3,5]

import java.util.ArrayList;
import java.util.List;

public class PartitionList_86 {
    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(2);
        node1.next.next.next.next = new ListNode(5);
        node1.next.next.next.next.next = new ListNode(2);
    }

        //1,4,3,2,5,2
        //1,2,2,       before
        //4,3,5,null   after
        //1,2,2,4,3,5,null
        //before start
    public ListNode partition(ListNode head, int x) {
        ListNode before_head = new ListNode(0);
        ListNode before = before_head;

        ListNode after_head = new ListNode(0);
        ListNode after = after_head;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }

            head = head.next;
        }

        after.next = null;
        before.next = after_head.next;

        return before_head.next;

    }


    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) { val = x; }
    }
    
}
