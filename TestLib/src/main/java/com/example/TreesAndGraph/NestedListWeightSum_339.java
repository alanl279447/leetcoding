package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class NestedListWeightSum_339 {
//    Input: [[1,1],2,[1,1]]
//    Output: 10
//    Input: [1,[4,[6]]]
//    Output: 27
//    Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27.
//    Explanation: Four 1's at depth 2, one 2 at depth 1.
//    https://leetcode.com/problems/nested-list-weight-sum/

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

        int result = depthSum(nestedList);
        System.out.println(result);
    }

    //BFS approach
    public static int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) return 0;
        int total = 0, depth = 1;
        Deque<NestedInteger> queue = new LinkedList(nestedList);
        while (!queue.isEmpty()) {
           int size  = queue.size();
           for (int i=0; i < size; i++) {
               NestedInteger item = queue.poll();
               if(item.isInteger()) {
                   total += item.integer * depth;
               } else {
                   queue.addAll(item.list);
               }
           }
            depth++;
        }
        return total;
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
