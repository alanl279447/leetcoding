package com.example.LinkedList;

public class ReverseLinkedListII_92 {

//    Input: 1->2->3->4->5->NULL, m = 2, n = 4
//    Output: 1->4->3->2->5->NULL
//    https://leetcode.com/problems/reverse-linked-list-ii/
// time complexity 0(n)

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);

        ListNode result = reverseBetween(node1, 2, 4);
        while (result.next != null) {
            System.out.println("val: "+result.val);
            result = result.next;
        }
        System.out.println("val: "+result.val);
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prev =null;
        ListNode current_node = head;

        while (m > 1) {
          prev=current_node;
          current_node=current_node.next;
          m--;
          n--;
        }
        ListNode connectionNode=prev;
        ListNode tail=current_node;

        while(n>0) {
            ListNode temp = current_node.next;
            current_node.next=prev;
            prev=current_node;
            current_node=temp;
            n--;
        }
        if (connectionNode!= null) {
            connectionNode.next=prev;
        } else {
            head=prev;
        }
        tail.next=current_node;
        return head;
    }

    public static class ListNode {
      int val;
      ListNode next;
      public ListNode(int x) { val = x; }
  }

}
