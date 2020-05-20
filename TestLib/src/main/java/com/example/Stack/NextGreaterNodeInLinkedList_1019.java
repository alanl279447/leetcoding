package com.example.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NextGreaterNodeInLinkedList_1019 {

//    Input: [1,7,5,1,9,2,5,1]
//    Output: [7,9,9,9,0,5,0,0]
//    https://leetcode.com/problems/next-greater-node-in-linked-list/


    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(7);
        node1.next.next = new ListNode(5);
        node1.next.next.next = new ListNode(1);
        node1.next.next.next.next = new ListNode(9);
        node1.next.next.next.next.next = new ListNode(2);
        node1.next.next.next.next.next.next = new ListNode(5);
        node1.next.next.next.next.next.next.next = new ListNode(1);

        int[] result = nextLargerNodes(node1);
        for (int res: result)
         System.out.print(res);
    }

    //    Input: [1,7,5,1,9,2,5,1]
    //    Output: [7,9,9,9,0,5,0,0]
    public static int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> A = new ArrayList<>();
        for (ListNode node = head; node != null; node = node.next)
            A.add(node.val);
        int[] res = new int[A.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.size(); ++i) {
            while (!stack.isEmpty() && A.get(stack.peek()) < A.get(i))
                res[stack.pop()] = A.get(i);
            stack.push(i);
        }
        return res;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
