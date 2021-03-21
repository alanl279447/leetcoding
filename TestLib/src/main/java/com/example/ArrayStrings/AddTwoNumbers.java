package com.example.ArrayStrings;

public class AddTwoNumbers {

//    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//    Output: 7 -> 0 -> 8
//    Explanation: 342 + 465 = 807.
//    https://leetcode.com/problems/add-two-numbers/

    public ListNode sumTwoNode(ListNode l1, ListNode l2) {
        ListNode  dummyHead = new ListNode(0);
        ListNode sum = dummyHead;
        //loop over all elements
        int carrydigit = 0;
        while(l1 != null || l2 != null) {
            int x = l1 != null ? l1.val: 0;
            int y = l2 != null ? l2.val: 0;

            int digitSum = x +  y + carrydigit;
            carrydigit = digitSum/10;

             sum.next = new ListNode(digitSum%10);
             sum = sum.next;
        }
        if (carrydigit > 0) {
            sum.next = new ListNode(carrydigit);
        }
        return dummyHead.next;
    }

    public ListNode createNode(int[] vals) {
        ListNode root = null;
       //addRecusively(root, vals);
       return root;
    }

    private ListNode addRecusively(ListNode node, int value) {
        if (node == null) {
            return node = new ListNode(value);
        } else {
          while (node.next != null) {

          }
        }
        return null;
    }

    public class ListNode {
      int val;
      ListNode next;
      public ListNode(int x) { val = x; }
  }

}
