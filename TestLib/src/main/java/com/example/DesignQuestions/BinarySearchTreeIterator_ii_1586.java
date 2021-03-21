package com.example.DesignQuestions;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class BinarySearchTreeIterator_ii_1586 {
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
        System.out.println("Hasprev :" +obj.hasPrev());  //true
        System.out.println("Prev :" +obj.prev());    //9
        System.out.println("hasPrev :" +obj.hasPrev());
        System.out.println("Next :" +obj.hasNext());  //
        System.out.println("Next :" +obj.next());
        System.out.println("Next :" +obj.hasNext());
    }

    static class BSTIterator {
        private TreeNode dummy = new TreeNode(-1);
        private TreeNode curr = dummy;
        private Stack<TreeNode> stack = new Stack<>();

        // Init
        public BSTIterator(TreeNode root) {
            this.collectMins(root);
        }

        // If there's no right and there's no node to append to the 'list', there's no next
        public boolean hasNext() {
            return !(curr.right == null && stack.isEmpty());
        }

        // Go forward. If no right, then we're at the end, append next node. Otherwise, just move forward
        public int next() {
            // If there's no next then we must have a node ready in the Stack
            if (curr.right == null) {
                TreeNode next = stack.pop();

                // Discover next mins and unlink
                collectMins(next.right);
                next.right = null;

                // Append to 'list'
                next.left = curr;
                curr.right = next;
            }

            curr = curr.right;

            return curr.val;
        }

        // If the 'list' is empty or we're at the first nodes, there is no prev
        public boolean hasPrev() {
            return (curr != dummy && curr.left != dummy);
        }

        // Go back
        public int prev() {
            curr = curr.left;
            return curr.val;
        }

        // Should only be called once per node
        private void collectMins(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
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