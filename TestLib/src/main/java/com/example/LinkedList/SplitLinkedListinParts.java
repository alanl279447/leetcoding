package com.example.LinkedList;

import java.util.List;

public class SplitLinkedListinParts {

//    Input:
//    root = [1, 2, 3], k = 5
//    Output: [[1],[2],[3],[],[]]
//    Explanation:
//    The input and each element of the output are ListNodes, not arrays.
//    For example, the input root has root.val = 1, root.next.val = 2, \root.next.next.val = 3, and root.next.next.next = null.
//    The first element output[0] has output[0].val = 1, output[0].next = null.
//    The last element output[4] is null, but it's string representation as a ListNode is [].
//    https://leetcode.com/problems/split-linked-list-in-parts/
//    time complexity o(n+k)

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
//        node1.next.next.next.next = new ListNode(5);
//        node1.next.next.next.next.next = new ListNode(6);
//        node1.next.next.next.next.next.next = new ListNode(7);

        ListNode[] result = splitListToParts(node1, 5);

        for (ListNode node: result) {
            while (node.next != null) {
                System.out.println("val: " + node.val);
                node = node.next;
            }
            System.out.println("val: "+node.val);
        }
    }


    public static ListNode[] splitListToParts(ListNode root, int k) {
        ListNode cur = root;
        int N = 0;
        while (cur != null) {
            cur = cur.next;
            N++;
        }
        int width = N / k, rem = N % k;

        ListNode[] ans = new ListNode[k];
        cur = root;
        for (int i = 0; i < k; ++i) {
            ListNode head = new ListNode(0), write = head;
            for (int j = 0; j < width + (i < rem ? 1 : 0); ++j) {
                write = write.next = new ListNode(cur.val);
                if (cur != null) {
                    cur = cur.next;
                }
            }
            ans[i] = head.next;
        }
        return ans;
    }

    public static class ListNode {
      int val;
      ListNode next;
      public ListNode(int x) { val = x; }
  }

}
