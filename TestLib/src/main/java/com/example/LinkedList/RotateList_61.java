package com.example.LinkedList;

public class RotateList_61 {

//    Input: 1->2->3->4->5->NULL, k = 2
//    Output: 4->5->1->2->3->NULL
//    Explanation:
//    rotate 1 steps to the right: 5->1->2->3->4->NULL
//    rotate 2 steps to the right: 4->5->1->2->3->NULL
//    https://leetcode.com/problems/rotate-list/

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

        ListNode pre = reverseKGroup(node, k);

        while(count > 0) {
         ListNode headNext = head.next;
         head.next = pre;
         pre = head;
         head = headNext;
         count --;
        }
        return pre;
    }

    public static class ListNode {
      int val;
      ListNode next;
      public ListNode(int x) { val = x; }
  }

}
