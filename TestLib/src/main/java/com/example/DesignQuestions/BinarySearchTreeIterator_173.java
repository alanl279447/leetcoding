package com.example.DesignQuestions;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTreeIterator_173 {
//    BSTIterator iterator = new BSTIterator(root);
//iterator.next();    // return 3
//iterator.next();    // return 7
//iterator.hasNext(); // return true
//iterator.next();    // return 9
//iterator.hasNext(); // return true
//iterator.next();    // return 15
//iterator.hasNext(); // return true
//iterator.next();    // return 20
//iterator.hasNext(); // return false
//    https://leetcode.com/problems/binary-search-tree-iterator/
    public static TreeNode root = null;
    public static void main(String[] args) {
        addNode(7);
        BSTIterator obj = new BSTIterator(root);
        System.out.println("Next :" +obj.next());
        System.out.println("Next :" +obj.next());
        System.out.println("Next :" +obj.hasNext());
        System.out.println("Next :" +obj.next());
        System.out.println("Next :" +obj.hasNext());
        System.out.println("Next :" +obj.next());
        System.out.println("Next :" +obj.hasNext());
        System.out.println("Next :" +obj.next());
        System.out.println("Next :" +obj.hasNext());
    }

    public static class BSTIterator {
        Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            TreeNode curr = root;
            addAll(root);
        }

        private void addAll(TreeNode node) {
            TreeNode curr = node;
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
        }

        /** @return the next smallest number */
        public int next() {
             TreeNode curr = stack.pop();
             if (curr != null) {
                 addAll(curr.right);
                 return curr.val;
             }
             return -1;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
              return !stack.isEmpty();
        }
    }

    public static void addNode(int value) {
        root = new TreeNode(value);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}