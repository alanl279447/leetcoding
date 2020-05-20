package com.example.ArrayStrings;

public class sampleHashMap {

    public static void main(String[] args) {
        System.out.println("Testing main");
        TestHashMap hashMap = new TestHashMap();
        hashMap.put(1, 1);
        hashMap.put(1, 2);
//        hashMap.get(1);            // returns 1
//        hashMap.get(3);            // returns -1 (not found)
//        hashMap.put(2, 1);          // update the existing value
//        hashMap.get(2);            // returns 1
    }

}

class TestHashMap {
    ListNode[] lists = new ListNode[10000]; //total number

    public void put(int key, int value) {
       int index = idx(key);
       if (lists[index] == null) {
           lists[index] = new ListNode(key, value);
       }
        ListNode prev = find(lists[index], key);
        if (prev.next == null)
            prev.next = new ListNode(key, value);
        else prev.next.val = value;

    }

    public ListNode find(ListNode bucket, int key) {
        ListNode node = bucket, prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }

    public int idx(int key) {
        return Integer.hashCode(key) % lists.length;
    }

    public int get(int key) {
        int i = idx(key);
        if (lists[i] == null)
            return -1;
        ListNode node = find(lists[i], key);
        return node.next == null ? -1 : node.next.val;
    }

    public void remove(int key) {

    }
}

class ListNode {
    int key, val;
    ListNode next;

    ListNode(int key, int value) {
        this.key = key;
        this.val = value;
    }

    public void setNext(ListNode nextNode) {
        this.next = nextNode;
    }
}
