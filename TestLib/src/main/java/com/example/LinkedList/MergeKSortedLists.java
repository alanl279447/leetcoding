package com.example.LinkedList;
import java.util.PriorityQueue;

public class MergeKSortedLists {
//    Input:
//            [
//            1->4->5,
//            1->3->4,
//            2->6
//            ]
//    Output: 1->1->2->3->4->4->5->6
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);

        ListNode[] listArray = new ListNode[3];
        listArray[0] = node1;
        listArray[1] = node2;
        listArray[2] = node3;

        ListNode result = mergeKLists(listArray);
        while (result.next != null) {
            System.out.println("val: "+result.val);
            result = result.next;
        }
        System.out.println("val: "+result.val);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b)-> a.val-b.val);
        ListNode dummyNode = new ListNode(0);
        ListNode head = dummyNode;

        for (ListNode list: lists) {
              queue.offer(list);
        }

        while(!queue.isEmpty()) {
            ListNode node = queue.poll();
            dummyNode.next = node;
            dummyNode = dummyNode.next;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        return head.next;
    }

    public static class ListNode {
      int val;
      ListNode next;
      public ListNode(int x) { val = x; }
  }
}