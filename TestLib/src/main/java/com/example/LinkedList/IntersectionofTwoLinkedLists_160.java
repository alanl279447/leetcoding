package com.example.LinkedList;

public class IntersectionofTwoLinkedLists_160 {

//    Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
//    Output: Reference of the node with value = 8
//    Input Explanation: The intersected node's value is 8
//            (note that this must not be 0 if the two lists intersect).
//    From the head of A, it reads as [4,1,8,4,5].
//    From the head of B, it reads as [5,6,1,8,4,5].
//    There are 2 nodes before the intersected node in A;
//    There are 3 nodes before the intersected node in B.
//    https://leetcode.com/problems/intersection-of-two-linked-lists/

    public static void main(String[] args) {

        ListNode nodeA = new ListNode(4);
        nodeA.next = new ListNode(1);
        nodeA.next.next = new ListNode(8);
        nodeA.next.next.next = new ListNode(4);
        nodeA.next.next.next.next = new ListNode(5);

        ListNode nodeB = new ListNode(5);
        nodeB.next = new ListNode(6);
        nodeB.next.next = new ListNode(1);
        nodeB.next.next.next = new ListNode(8);
        nodeB.next.next.next.next = new ListNode(4);
        nodeB.next.next.next.next.next = new ListNode(5);
        //System.out.println("val: "+getIntersectionNode(nodeA, nodeB));
    }

//    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//
//    }

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) { val = x; }
    }
}
