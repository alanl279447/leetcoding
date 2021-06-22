package com.example.LinkedList;

//Input:  1->2->6->3->4->5->6, val = 6
//Output: 1->2->3->4->5
//https://leetcode.com/problems/remove-linked-list-elements/

public class RemoveLinkedListElements_203 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(6);
        node1.next.next.next = new ListNode(3);
        node1.next.next.next.next = new ListNode(4);
        node1.next.next.next.next.next = new ListNode(5);
        node1.next.next.next.next.next.next = new ListNode(6);

        ListNode node = removeElements(node1, 6);
        while(node != null) {
            System.out.println("val: " + node.val);
            node = node.next;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
       ListNode sentinel = new ListNode(0);
       ListNode prev = sentinel;
       sentinel.next = head;
       ListNode curr = head;

       while(curr != null) {  //1->2->6->3->4->5->6
           if(curr.val == val) {
               prev.next = curr.next;
           } else {
               prev = curr;
           }
           curr = curr.next;
       }
       return sentinel.next;
    }

    public static class ListNode {
      int val;
      ListNode next;
      public ListNode(int x) { val = x; }
  }
}