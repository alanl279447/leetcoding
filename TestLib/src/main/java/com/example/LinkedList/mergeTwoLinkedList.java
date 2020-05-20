package com.example.LinkedList;

public class mergeTwoLinkedList {

//    Input: 1->2->4, 1->3->4
//    Output: 1->1->2->3->4->4

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(4);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode result = mergeTwoLists(node1, node2);
        while (result.next != null) {
            System.out.println("val: "+result.val);
            result = result.next;
        }
        System.out.println("val: "+result.val);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       ListNode listnode = new ListNode(-1);
       ListNode prev = listnode;

       if (l1 == null) return l2;
       if (l2 == null) return l1;


       while(l1 != null && l2 != null) {
          if (l1.val < l2.val) {
            prev.next = l1;
            l1 = l1.next;
          } else {
              prev.next = l2;
              l2 = l2.next;
          }
          prev = prev.next;
       }

       //either one of l1,l2 is null
        prev.next = l1 == null? l2: l1;

       return listnode.next;
    }

    public static class ListNode {
      int val;
      ListNode next;
      public ListNode(int x) { val = x; }
  }

}
