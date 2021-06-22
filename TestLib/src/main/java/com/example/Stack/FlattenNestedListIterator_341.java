package com.example.Stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

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
        Deque<NestedInteger> stack = new ArrayDeque<>();
        public NestedIterator(List<NestedInteger> nestedList) {
            prepareStack(nestedList);
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                return null;
            }
            return stack.pop().getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty() && !stack.peek().isInteger()) {
                List<NestedInteger> list = stack.pop().getList();
                prepareStack(list);
            }
            return !stack.isEmpty();
        }

        private void prepareStack(List<NestedInteger> nestedList) {
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                stack.push(nestedList.get(i));
            }
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
}