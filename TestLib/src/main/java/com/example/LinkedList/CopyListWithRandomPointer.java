package com.example.LinkedList;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class CopyListWithRandomPointer {

//    Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//    Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = new Node(4);
        node1.next.next = new Node(5);

        Node node2 = new Node(1);
        node2.next = new Node(3);
        node2.next.next = new Node(4);

        Node node3 = new Node(2);
        node3.next = new Node(6);


        Node result = copyRandomList(node1);
        while (result.next != null) {
            System.out.println("val: "+result.val);
            result = result.next;
        }
        System.out.println("val: "+result.val);
    }



    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static HashMap<Node, Node> visited = new HashMap<Node, Node>();
    public static Node getClonedNode(Node node) {
        // If the node exists then
        if (node != null) {
            // Check if the node is in the visited dictionary
            if (visited.containsKey(node)) {
                // If its in the visited dictionary then return the new node reference from the dictionary
                return visited.get(node);
            } else {
                // Otherwise create a new node, add to the dictionary and return it
                visited.put(node, new Node(node.val));
                return visited.get(node);
            }
        }
        return null;
    }

    public static Node copyRandomList(Node head) {
      if (head == null) {
          return null;
      }
      Node oldNode = head;
      Node newNode = new Node(oldNode.val);
      visited.put(oldNode, newNode);

      while(oldNode != null) {
          newNode.next = getClonedNode(oldNode.next);
          newNode.random = getClonedNode(oldNode.random);

          oldNode = oldNode.next;
          newNode = newNode.next;
      }
      return visited.get(head);
    }
}