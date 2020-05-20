package com.example.LinkedList;

public class InsertintoaSortedCircularLinkedList_708 {

//    Input: head = [3,4,1], insertVal = 2
//    Output: [3,4,1,2]
//    Explanation: In the figure above, there is a sorted circular list of three elements.
//    You are given a reference to the node with value 3, and we need to insert 2 into the list.
//        The new node should be inserted between node 1 and node 3.
//    After the insertion, the list should look like this, and we should still return node 3.
//    https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/

    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(3);
        node1.next.next.next = new Node(4);
//        node1.next.next.next.next = new Node(5);

        Node result = null;//reverseList(node1);
        while (result.next != null) {
            System.out.println("val: "+result.val);
            result = result.next;
        }
        System.out.println("val: "+result.val);
    }

    public static Node insert(Node head, int insertVal) {
       if (head == null) {
           Node newNode = new Node(insertVal, null);
           newNode.next = newNode;
           return newNode;
       }
        Node prev = head;
        Node curr = head.next;
        boolean toInsertItem = false;
        do {
            //item is between two nodes!!
            if (prev.val <= insertVal  && insertVal<= curr.val) {
                toInsertItem=true;
            }

            if (prev.val > curr.val) {
                if (insertVal > prev.val || insertVal < curr.val) {
                    toInsertItem=true;
                }
            }
            if (toInsertItem) {
                prev.next = new Node(insertVal, curr);
                return head;
            }
            prev = curr;
            curr = curr.next;

        } while (prev != head);

        prev.next = new Node(insertVal, curr);
        return head;
    }

    static class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };
}
