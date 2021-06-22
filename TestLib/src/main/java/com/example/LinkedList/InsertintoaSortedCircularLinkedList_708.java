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
        Node node1 = new Node(3);
        node1.next = new Node(1);
        node1.next.next = new Node(4);
        //node1.next.next.next = new Node(4);
        node1.next.next.next = node1;

        Node result = insert(node1, 2);
        while (result.next != null) {
            System.out.println("val: "+result.val);
            result = result.next;
        }
        System.out.println("val: "+result.val);
    }

    //is head is null, create node, next pointing to self and return node.
    //find the maxNode, min = maxNode.next, check if insertval >= max || <= min
    //loop and find the previos element
    public static Node insert(Node head, int insertVal) {
        if (head == null) {    //case 1: empty list, insert at the head
            Node node = new Node();
            node.val = insertVal;
            node.next = node;
            return node;
        }
        Node max = head;
        while (max.next != head && max.val <= max.next.val) {
            max = max.next;
        }

        //is insertVal is greater than max or less than min, insert after max
        Node min = max.next, cur = min;
        if (insertVal >= max.val || insertVal <= min.val) {
            Node node = new Node(insertVal, min);
            max.next = node;
        } else {
            while (cur.next.val < insertVal) {//find the node less than the insertValue
                cur = cur.next;
            }
            Node node = new Node(insertVal, cur.next);
            cur.next = node;
        }
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
