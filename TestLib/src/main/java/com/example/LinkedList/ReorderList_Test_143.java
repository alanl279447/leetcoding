package com.example.LinkedList;

public class ReorderList_Test_143 {

//    Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
//    https://leetcode.com/problems/reorder-list/

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);
        node1.next.next.next.next.next = new ListNode(6);

        reorderList(node1);
        while (node1.next != null) {
            System.out.println("val: "+node1.val);
            node1 = node1.next;
        }
        System.out.println("val: "+node1.val);
    }

    public static void reorderListPractice(ListNode head) {
        ListNode slowNode = head, fastNode= head, prev = head;

        while(fastNode != null && fastNode.next != null) {
            prev =
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

    }


    public static void reorderList(ListNode head) {
       ListNode slowNode = head;
       ListNode fastNode = head;
       ListNode l1 = head;   //head of first
       ListNode prev = null;

       if (head == null || head.next == null) return;

       while(fastNode != null && fastNode.next != null) {
           prev = slowNode;   //tail of first
           slowNode = slowNode.next; //head of second
           fastNode = fastNode.next.next;  //tail of second
       }
       prev.next = null;
       slowNode = reverseSecondLinkedList(slowNode);
       mergeLinkedList(l1, slowNode);
    }

    public static void mergeLinkedList(ListNode l1, ListNode l2) {
        ListNode temp = l1;
        while(l1 != null) {
            ListNode l1_next = l1.next;
            ListNode l2_next = l2.next;

            l1.next = l2;
            if (l1_next == null) {
                break;
            }

            l2.next = l1_next;
            l1 = l1_next;
            l2 = l2_next;
          }
    }

    public static ListNode reverseSecondLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode currentNode = head;

        while(currentNode != null) {
            ListNode tempNode = currentNode.next;   //2-3-4,  3-4-null          4-null     null             null
            currentNode.next = prev;       //1-null           2-1-null     3-2-1-null     4-3-2-1-null
            prev = currentNode;           //1-null            2-1-null     3-2-1-null    4-3-2-1-null
            currentNode = tempNode;       //2-3-4             3-4-null      4-null       null
        }
        return prev;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int value) {
            val = value;
        }
    }
}

