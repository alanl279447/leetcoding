package com.example.ArrayStrings;

public class BinaryTreeSample {

    private Node root = null;
    public void add(int value) {
        root = addRecursive(root, value);
    }

    public Node getRoot() {
        return root;
    }

    public Node addRecursive(Node node, int value) {
         if (node == null) {
             return new Node(value);
         }

         if (value < node.value) {
             node.leftNode = addRecursive(node.leftNode, value);
         } else if(value > node.value){
             node.rightNode = addRecursive(node.rightNode, value);
         } else {
             return node;
        }
         return node;
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            // Case 1: no children
            if (current.leftNode == null && current.rightNode == null) {
                return null;
            }

            // Case 2: only 1 child
            if (current.rightNode == null) {
                return current.leftNode;
            }

            if (current.leftNode == null) {
                return current.rightNode;
            }

            // Case 3: 2 children
            int smallestValue = findSmallestValue(current.rightNode);
            current.value = smallestValue;
            current.rightNode = deleteRecursive(current.rightNode, smallestValue);
            return current;
        }
        if (value < current.value) {
            current.leftNode = deleteRecursive(current.leftNode, value);
            return current;
        }

        current.rightNode = deleteRecursive(current.rightNode, value);
        return current;
    }

    private int findSmallestValue(Node root) {
        return root.leftNode == null ? root.value : findSmallestValue(root.leftNode);
    }



     class Node {
        Integer value;
        Node leftNode = null;
        Node rightNode = null;

        Node(Integer val) {
            value = val;
        }
    }

    public void preOrderTraversal(Node node) {

        if (node != null) {
            System.out.println(node.value);
            preOrderTraversal(node.leftNode);
            preOrderTraversal(node.rightNode);
        }
    }

    public boolean doesContainNumber(Integer number) {
        Node node = checkNumber(root, number);
        return node != null;
    }

    private Node checkNumber(Node node, Integer value) {
       if (node != null) {
           if (node.value == value) {
               return node;
           } else if (node.value > value) {
               node = checkNumber(node.leftNode, value);
           } else if (node.value < value) {
               node = checkNumber(node.rightNode, value);
           }
       }

        return node;
    }
}
