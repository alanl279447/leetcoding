package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConvertSortedListBinarySearchTree_109 {

//    Given the sorted linked list: [-10,-3,0,5,9],
//
//    One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
//             0
//            / \
//          -3  9
//          /   /
//        -10  5
//    https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
    //Time complexity 0(nlogn)

    public static ListNode root;
    public static void main(String[] args) {
        addNode(-10);
        TreeNode result = sortedListToBST(root);
        //while(result != null)
            System.out.println(result.val);
        result = result.left;
    }

    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode slow = head, pre = null, fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null; //cut left sub list here
        TreeNode n = new TreeNode(slow.val);
        n.left = sortedListToBST(head);
        n.right = sortedListToBST(slow.next);
        return n;
    }

//    public static TreeNode sortedListToBST(ListNode head) {
//        if(head==null) {
//            return null;
//        }
//        return toBST(head,null);
//    }
//
//    public static TreeNode toBST(ListNode head, ListNode tail){
//        ListNode slow = head;
//        ListNode fast = head;
//        if(head==tail) {
//            return null;
//        }
//
//        while(fast!=tail&&fast.next!=tail){
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        TreeNode thead = new TreeNode(slow.val);
//        thead.left = toBST(head,slow);
//        thead.right = toBST(slow.next,tail);
//        return thead;
//    }

    public static void addNode(int value) {
        root = new ListNode(value);
        root.next = new ListNode(-3);
        root.next.next = new ListNode(0);
        root.next.next.next = new ListNode(5);
        root.next.next.next.next = new ListNode(9);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
