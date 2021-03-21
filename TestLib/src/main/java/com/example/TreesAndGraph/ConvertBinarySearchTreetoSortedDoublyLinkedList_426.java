package com.example.TreesAndGraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class ConvertBinarySearchTreetoSortedDoublyLinkedList_426 {
//    Input: root = [4,2,5,1,3]
//    Output: [1,2,3,4,5]
//
//    Explanation: The figure below shows the transformed BST.
//    The solid line indicates the successor relationship,
//            while the dashed line means the predecessor relationship.
//     https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/

    public static Node root;
    private static Node ans = null;

    public static void main(String[] args) {
        addNode(3);
        Node first = treeToDoublyList(root);
          while(first != null) {
              System.out.println(first.val);
              first = first.left;
          }
    }

    public static Node helperIterative(Node node) {
        if( node == null) return node;
        Node dummy = new Node(0);
        Node prev = dummy;
        Stack<Node> stack = new Stack();
        Node curr = node;

        while(!stack.isEmpty()|| curr != null){
            while(curr!= null){
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            prev.right = curr;
            curr.left = prev;
            prev = curr;
            curr = curr.right;
        }
        dummy.right.left = prev;
        prev.right = dummy.right;
        return dummy.right;
    }

    static Node first = null;
    static Node last = null;
    public static Node treeToDoublyList(Node root) {
        if (root == null) return null;
        helper(root);
        // close DLL
        last.right = first;
        first.left = last;
        return first;
    }

    public static void helper(Node node) {
        if (node != null) {
            // left
            helper(node.left);
            // node
            if (last != null) {
                // link the previous node (last)
                // with the current one (node)
                last.right = node;
                node.left = last;
            }
            else {
                // keep the smallest node
                // to close DLL later on
                first = node;
            }
            last = node;
            // right
            helper(node.right);
        }
    }

    public static void addNode(int value) {
        root = new Node(value);
        root.left = new Node(9);
//        root.right = new TreeNode(6);
//        root.left.right = new TreeNode(5);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
    }

    public static class Node {
        int val;
        Node left;
        Node right;
        Node(int x) {
            val = x;
        }
    }
}