package com.example.SortingAndSearching;

import com.example.LinkedList.ReverseNodeinKList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MiddleoftheLinkedList_876 {

//    Input: [1,2,3,4,5]
//    Output: Node 3 from this list (Serialization: [3,4,5])
//    The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
//    Note that we returned a ListNode object ans, such that:
//    ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
//    https://leetcode.com/problems/middle-of-the-linked-list/

    public static ListNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);
        System.out.print(middleNode(node1));
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) { val = x; }
    }

}
