package com.example.LinkedList;

public class RemoveNthNodeFromEndofList_19 {

//    Given linked list: 1->2->3->4->5, and n = 2.
//    After removing the second node from the end, the linked list becomes 1->2->3->5.
//    https://leetcode.com/problems/remove-nth-node-from-end-of-list/

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);

        ListNode result = removeNthFromEnd(node1, 2);
        while (result.next != null) {
            System.out.println("val: "+result.val);
            result = result.next;
        }
        System.out.println("val: "+result.val);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode p = newHead;
        ListNode runner = newHead;
        while(n>0){
            runner = runner.next;
            n--;
        }
        while(runner.next!=null){
            runner = runner.next;
            p=p.next;
        }
        p.next = p.next.next;
        return newHead.next;
    }

    public static class ListNode {
      int val;
      ListNode next;
      public ListNode(int x) { val = x; }
  }

}
