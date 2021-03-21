package com.example.LinkedList;

//Input: head = [1,2,3,4]
//Output: [2,1,4,3]
//https://leetcode.com/problems/swap-nodes-in-pairs/
public class SwapNodesinPairs_24 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);

        ListNode result = swapPairs(node1);
        while (result.next != null) {
            System.out.println("val: "+result.val);
            result = result.next;
        }
        System.out.println("val: "+result.val);
    }

    public static ListNode swapPairs(ListNode head) {
        return swapPairs(head, 2);
    }

    public static ListNode swapPairs(ListNode head, int k) {
        ListNode node = head;
        int count = 0;
        while (count <k) {
            if (node == null) {
                return head;
            }
            node = node.next;
            count--;
        }
        ListNode pre = swapPairs(node, k);

        while (count >0) {
            ListNode tempNode = head.next;
            head.next = pre;
            pre = head;
            head = tempNode;
            count--;
        }
        return pre;

    }

    public static class ListNode {
      int val;
      ListNode next;
      public ListNode(int x) { val = x; }
  }

}
