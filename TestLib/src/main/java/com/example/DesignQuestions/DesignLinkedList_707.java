package com.example.DesignQuestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DesignLinkedList_707 {
//    https://leetcode.com/problems/design-linked-list/

    public static void main(String[] args) {

    }

    class MyLinkedList {

        class Node {
            int value;
            Node next;

            public Node(int value) {
                this.value = value;
            }
        }


        Node head = null;
        int size = 0;

        /** Initialize your data structure here. */
        public MyLinkedList() {

        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
          if (index >=size) return -1;
          Node curr = head;
          for (int i = 0; i < index; i++) {
              curr = curr.next;
          }
          return curr.value;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            Node prev = head;
            head = new Node(val);
            head.next = prev;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
           Node node = new Node(val);
           size++;
           if (head == null) head = node;
           else {
               Node curr = head;
               while (curr.next != null) {
                   curr = curr.next;
               }
               curr.next = node;
           }
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if (index > size) return;
            if (index == 0) {
                addAtHead(val);
            } else {
                size++;
                Node current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.next;
                }
                Node node = new Node(val);
                node.next = current.next;
                current.next = node;
            }
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if (index >= size) return;
            size--;
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
    }
}