package com.example.DesignQuestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class All0oneDataStructure_432 {
//    https://leetcode.com/problems/all-oone-data-structure/
//    https://leetcode.com/problems/all-oone-data-structure/discuss/731468/HashMap-%2B-DoublyLinkedList-strategy
    public static void main(String[] args) {

        AllOne obj = new AllOne();
        obj.inc("a");  // a -1
        obj.inc("b");  // b -1
        obj.inc("b");  //b -2
        obj.inc("c");  // c -1
        obj.inc("c");
        obj.inc("c");  // c- 3

        obj.dec("b");
        obj.dec("b");  //b  - 0

        System.out.println(obj.getMinKey());   // a
        System.out.println(obj.getMaxKey());   //c

        obj.dec("a"); // a = 0

        System.out.println(obj.getMinKey()); // c
        System.out.println(obj.getMaxKey()); //c
    }

    public static class AllOne {
        private Node head;
        private Node tail;
        Map<String, Node> map;

        /** Initialize your data structure here. */
        public AllOne() {
            head = null;
            tail = null;
            map = new HashMap<>();
        }

        //if map contains key
        // - get the Node, remove element form node,
        // node.next == null (create the next element & add key)
        // else check if node.next freq = node.freq+1, if yes, node.next.keys.add(String)
        //

        /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
        public void inc(String key) {

            if (map.containsKey(key)) {
                Node node = map.get(key);
                int freq = node.freq;
                node.keys.remove(key);
                if (node.next == null) {
                    Node newNode = new Node(freq + 1);
                    node.next = newNode;
                    newNode.prev = node;
                    newNode.keys.add(key);
                    map.put(key, newNode);
                    tail = newNode;
                } else {
                    Node next = node.next;
                    if (next.freq - freq > 1) {
                        Node newNode = new Node(freq + 1);
                        newNode.keys.add(key);
                        node.next = newNode;
                        newNode.prev = node;
                        newNode.next = next;
                        next.prev = newNode;
                        map.put(key, newNode);
                    } else {
                        next.keys.add(key);
                        map.put(key, next);
                    }
                }

                if (node.keys.size() == 0) {
                    removeNode(node);
                }

            } else { // map does not contains the key
                if (head == null) {
                    head = new Node(1);
                    head.keys.add(key);
                    tail = head;
                } else {
                    if (head.freq == 1) {
                        head.keys.add(key);
                    } else {
                        Node newNode = new Node(1);
                        newNode.keys.add(key);
                        newNode.next = head;
                        head.prev = newNode;
                        head = newNode;
                    }
                }
                map.put(key, head);
            }
        }

        //Check key in map, get Node
        //Remove the key from Node.keys

        /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
        public void dec(String key) {
            if (!map.containsKey(key)) {
                return;
            }
            Node node = map.get(key);
            node.keys.remove(key);
            int freq = node.freq;
            if (freq == 1) {
                map.remove(key);

            } else if (node == head) {
                Node newNode = new Node(freq - 1);
                newNode.keys.add(key);
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
                map.put(key, head);
            } else {
                Node prev = node.prev;
                if (freq - prev.freq == 1) {
                    prev.keys.add(key);
                    map.put(key, prev);
                } else {
                    Node newNode = new Node(freq - 1);
                    prev.next = newNode;
                    newNode.prev = prev;
                    newNode.next = node;
                    node.prev = newNode;
                    newNode.keys.add(key);
                    map.put(key, newNode);
                }
            }
            if (node.keys.size() == 0) {
                removeNode(node);
            }
        }


        /** Returns one of the keys with maximal value. */
        public String getMaxKey() {
            if (head == null) {
                return "";
            }
            return tail.keys.iterator().next();
        }

        /** Returns one of the keys with Minimal value. */
        public String getMinKey() {
            if (head == null) {
                return "";
            }
            return head.keys.iterator().next();
        }


        private void removeNode(Node node) {
            if (node == head) {
                head = head.next;
                node.next = null;
                if (head != null) {
                    head.prev = null;
                }
            } else if (node == tail) {
                tail = tail.prev;
                node.prev = null;
                if (tail != null) {
                    tail.next = null;
                }
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.prev = null;
                node.next = null;
            }
        }
    }

    static class Node {
        int freq;
        Node prev;
        Node next;
        Set<String> keys;

        public Node(int freq) {
            this.freq = freq;
            keys = new HashSet<>();
        }
    }
}