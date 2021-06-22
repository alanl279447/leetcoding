package com.example.LinkedList;

public class OddEvenLinkedList_328 {

//    Input: 1->2->3->4->5->NULL
//    Output: 1->3->5->2->4->NULL
//    https://leetcode.com/problems/odd-even-linked-list/

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);
        node1.next.next.next.next.next = new ListNode(6);
        ListNode result = oddEvenList(node1);

        while (result.next != null) {
            System.out.println("val: "+result.val);
            result = result.next;
        }
        System.out.println("val: "+result.val);
    }

//    1->2->3->4->5->NULL
//    1->3->2->3->4->5->Nul
    public static ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next!= null) {
            odd.next = even.next; //head.next.next -> odd
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static class ListNode {
      int val;
      ListNode next;
      public ListNode(int x) { val = x; }
  }

}
