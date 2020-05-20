package com.example.ArrayStrings;

public class sumTwoNumbers {

    public static void main(String[] args) {
        System.out.println("Testing main");

        //char[] input = "Testing".toCharArray();
        ListNode l1 = new ListNode(2);
        ListNode l1_1 = new ListNode(4);
        ListNode l1_2 = new ListNode(3);

        l1.next = l1_1;
        l1_1.next = l1_2;

        ListNode l2 = new ListNode(5);
        ListNode l2_1 = new ListNode(6);
        ListNode l2_2 = new ListNode(4);

        l2.next = l2_1;
        l2_1.next = l2_2;

        printNoSum(l1, l2);
    }

    public static ListNode printNoSum(ListNode l1, ListNode l2) {
        int carryValue = 0;
        ListNode dummyHead = new ListNode(0);
        ListNode p, q, curr = dummyHead;

        while (l1 != null || l2 != null) {
            p = l1;
            q = l2;

            int sum = p.value + q.value + carryValue;
            carryValue = sum / 10;

            curr.value = sum;
            System.out.println("Testing" +sum);
            curr.next = new ListNode(sum % 10);

            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        return dummyHead;
    }

    public static class ListNode {
      int value;
      ListNode next;

      ListNode() {

      }

      ListNode(int val) {
          this.value = val;
      }
    }
}
