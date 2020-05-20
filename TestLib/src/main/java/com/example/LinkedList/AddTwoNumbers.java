package com.example.LinkedList;

import java.util.Stack;

public class AddTwoNumbers {

//    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//    Output: 7 -> 0 -> 8
//    Explanation: 342 + 465 = 807.

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);

//        ListNode result = sumTwoNode(node1, node2);
        ListNode result = addTwoNumbers(node1, node2);

        while (result != null) {
            System.out.println("val: "+result.val);
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> l1Stack = new Stack<>();

        while(l1 != null) {
            l1Stack.push(l1);
            l1 = l1.next;
        }

        Stack<ListNode> l2Stack = new Stack<>();

        while(l2 != null) {
            l2Stack.push(l2);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode dummy = null;

        while(!l1Stack.isEmpty() || !l2Stack.isEmpty() ||  carry != 0) {
            int f = l1Stack.isEmpty() ? 0 : l1Stack.pop().val;
            int s = l2Stack.isEmpty() ? 0 : l2Stack.pop().val;

            int t = f + s + carry;

            ListNode newNode = new ListNode(t % 10);

            newNode.next = dummy;
            dummy = newNode;
            carry = t/10;

        }

        return dummy;

    }

    public static ListNode sumTwoNode(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int carry = 0;
        ListNode dummyNode = new ListNode(0);
        ListNode sumNode = dummyNode;

        while(l1 != null || l2 != null) {
            int x = 0;
            int y = 0;

            if (l1 != null) {
                x = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                y = l2.val;
                l2 = l2.next;
            }

            int sum = (x+y+carry)%10;
            carry = (x+y+carry)/10;
            sumNode.next = new ListNode(sum);
            sumNode = sumNode.next;
        }
        if (carry >0) {
           sumNode.next = new ListNode(carry);
        }
        return dummyNode.next;
    }

    public static ListNode sumTwoNodeWorking(ListNode l1, ListNode l2) {
        ListNode  dummyHead = new ListNode(0);
        ListNode sum = dummyHead;
        //loop over all elements
        int carrydigit = 0;
        while(l1 != null || l2 != null) {
            int x = l1 != null ? l1.val: 0;
            int y = l2 != null ? l2.val: 0;

            if (l1!= null) l1= l1.next;
            if (l2!= null) l2= l2.next;

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

//    public static ListNode sumTwoNode(ListNode l1, ListNode l2) {
//        ListNode listnode = new ListNode(-1);
//        ListNode head = listnode;
//        if (l1 == null)
//            return l2;
//        if (l2 == null)
//            return l1;
//
//        int carry = 0;
//        int result;
//        while(l1 != null && l2 != null) {
//            result = carry;
//            carry = 0;
//            if (l1 != null) {
//                result += l1.val;
//                l1 = l1.next;
//            }
//            if (l2 != null) {
//                result += l2.val;
//                l2 = l2.next;
//            }
//
//            if (result > 9) {
//                carry = 1;
//                result = result - 10;
//            }
//
//            listnode.next = new ListNode(result);
//            listnode = listnode.next;
//         }
//
//        if (carry > 0) {
//            listnode.next = new ListNode(carry);
//        }
//        return head.next;
//    }

    public static class ListNode {
      int val;
      ListNode next;
      public ListNode(int x) { val = x; }
  }

}
