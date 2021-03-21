package com.example.Stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class FlattenNestedListIterator_341 {

//    Input: [[1,1],2,[1,1]]
//    Output: [1,1,2,1,1]
//    Explanation: By calling next repeatedly until hasNext returns false,
//    the order of elements returned by next should be: [1,1,2,1,1].
//    https://leetcode.com/problems/flatten-nested-list-iterator/

//    public static TreeNode root = null;
//    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {

        List<NestedInteger> nestedList = new ArrayList<>();
        NestedInteger item1 = new NestedInteger();
        List<NestedInteger> itemArray1 = new ArrayList<>();
        NestedInteger item1sub = new NestedInteger();
        item1sub.integer = 1;
        NestedInteger item1sub2 = new NestedInteger();
        item1sub2.integer = 3;
        itemArray1.add(item1sub);
        itemArray1.add(item1sub2);
        item1.list =itemArray1;

        NestedInteger item2 = new NestedInteger();
        item2.integer =2;

        NestedInteger item3 = new NestedInteger();
        List<NestedInteger> itemArray3 = new ArrayList<>();
        NestedInteger item3sub = new NestedInteger();
        item3sub.integer = 2;
        NestedInteger item3sub2 = new NestedInteger();
        item3sub2.integer = 2;
        itemArray3.add(item3sub);
        itemArray3.add(item3sub2);
        item3.list =itemArray3;

        nestedList.add(item2);
        nestedList.add(item1);
        nestedList.add(item3);
        NestedIterator i = new NestedIterator(nestedList);
        int[] result = new int[5];
        int count =0;
        while (i.hasNext()) {
            result[count++] = i.next();
        }
        System.out.print(result.toString());
    }

    public static class NestedIterator implements Iterator<Integer> {

        Deque<NestedInteger> stack = null;
        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new ArrayDeque(nestedList);
        }

        @Override
        public Integer next() {
             if (!hasNext()) throw new NoSuchElementException();
            NestedInteger item = stack.removeFirst();
            return item.getInteger();
        }

        @Override
        public boolean hasNext() {
            while(!stack.isEmpty() && !stack.peekFirst().isInteger()) {
                List<NestedInteger> list = stack.removeFirst().getList();
                for (int i = list.size()-1; i >0; i--) {
                    stack.offerFirst(list.get(i));
                }
            }
            return !stack.isEmpty();
        }
    }

    static class NestedInteger {
        int integer;
        List<NestedInteger> list;

        public int getInteger() {
            return integer;
        }

        public boolean isInteger() {
            if (list == null) {
                return true;
            }
            return false;
        }

        public List<NestedInteger> getList() {
            return list;
        }
    }

//    public static class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//        TreeNode(int x) { val = x; }
//    }
//
//    public static void addNode(int value) {
//        root = addNodeRecursive(root, value);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);
//    }
//
//    public static TreeNode addNodeRecursive(TreeNode node, int value) {
////        TreeNode newNode = null;
//        if (node == null) {
//            node = new TreeNode(value);
//            return node;
//        }
//
//        if (value < node.val) {
//            node.left = addNodeRecursive(node.left, value);
//        } else if (value > node.val){
//            node.right = addNodeRecursive(node.right, value);
//        } else {
//            return node;
//        }
//        return node;
//    }
}