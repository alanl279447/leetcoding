package com.example.SortingAndSearching;

public class SortList_148 {
//    Input: -1->5->3->4->0
//    Output: -1->0->3->4->5
//    https://leetcode.com/problems/sort-list/
//    time complexity 0(NlogN)

    public static void main(String[] args) {
        ListNode node1 = new ListNode(-1);
        node1.next = new ListNode(5);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(0);
        ListNode result = sortList(node1);
    }
    // 1,5,3,4,0
    // 1,5  3,4  0
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // step 1. cut the list to two halves
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
//            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

//        prev.next = null;

        // step 2. sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // step 3. merge l1 and l2
        return merge(l1, l2);
    }

    static ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null)
            p.next = l1;

        if (l2 != null)
            p.next = l2;

        return l.next;
    }


    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) { val = x; }
    }
}