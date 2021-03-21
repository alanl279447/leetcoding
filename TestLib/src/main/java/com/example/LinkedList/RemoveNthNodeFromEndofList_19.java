package com.example.LinkedList;

public class RemoveNthNodeFromEndofList_19 {

//    Given linked list: 1->2->3->4->5, and n = 2.
//    After removing the second node from the end, the linked list becomes 1->2->3->5.
//    https://leetcode.com/problems/remove-nth-node-from-end-of-list/

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
//        node1.next = new ListNode(2);
//        node1.next.next = new ListNode(3);
//        node1.next.next.next = new ListNode(4);
//        node1.next.next.next.next = new ListNode(5);

        ListNode result = removeNthFromEnd(node1, 1);
        while (result.next != null) {
            System.out.println("val: "+result.val);
            result = result.next;
        }
        System.out.println("val: "+result.val);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode slowPtr = dummyNode;
        ListNode fastPtr = dummyNode;

        while (n > 0) {
            fastPtr = fastPtr.next;
            n--;
        }

        while (fastPtr!= null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }
        slowPtr = slowPtr.next.next;

        return dummyNode.next;
    }

    public static class ListNode {
      int val;
      ListNode next;
      public ListNode(int x) { val = x; }
  }

}
