package com.example.TreesAndGraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//      https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
//              Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
//              Output: [1,2,3,7,8,11,12,9,10,4,5,6]
//              Explanation:

public class FlattenaMultilevelDoublyLinkedList_430 {
    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        addNode();
    }

    public static Node flatten(Node head) {
        if (head == null) return head;

        Node pseudoHead = new Node(0, null, head, null);
        Node curr, prev = pseudoHead;

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(head);     //1

        while (!stack.isEmpty()) {
            curr = stack.pop(); //first element at the start  //1
            prev.next = curr;
            curr.prev = prev;

            if (curr.next != null) {
                stack.push(curr.next);      //3,2,1
            }
            if (curr.child != null) {
                stack.push(curr.child);   //start of the queue  //
                // don't forget to remove all child pointers.
                curr.child = null;
            }
            prev = curr;
        }
        // detach the pseudo node from the result
        pseudoHead.next.prev = null;
        return pseudoHead.next;
    }

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public void Node(int value) {
            val = value;
        }

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    };

    public static void addNode() {
        //root = addNodeRecursive(root, 4);

    }
}