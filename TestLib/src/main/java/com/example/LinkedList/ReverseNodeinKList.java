package com.example.LinkedList;

public class ReverseNodeinKList {

//    Given this linked list: 1->2->3->4->5
//    For k = 2, you should return: 2->1->4->3->5
//    For k = 3, you should return: 3->2->1->4->5
//    https://leetcode.com/problems/reverse-nodes-in-k-group/

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);

        ListNode result = reverseKGroup(node1, 2);
        while (result.next != null) {
            System.out.println("val: "+result.val);
            result = result.next;
        }
        System.out.println("val: "+result.val);
    }

    //1-2-3-4-5
    //1-2-4-3-5
    public static ListNode reverseKGroup(ListNode head, int k) {
        //1. test weather we have more then k node left, if less then k node left we just return head
        ListNode node = head;
        int count = 0;

        while (count < k) {
            if (node == null) {
                return head;
            }
            node = node.next;
            count ++;
        }

        ListNode pre = reverseKGroup(node, k);  //5-null,   4-3-5
                                                //head 3-4,  1-2
        while(count > 0) {
         ListNode headNext = head.next;
         head.next = pre;
         pre = head;
         head = headNext;
         count --;
        }
        return pre;
    }

    //head, create a node object
    //

    public static class ListNode {
      int val;
      ListNode next;
      public ListNode(int x) { val = x; }
  }
}