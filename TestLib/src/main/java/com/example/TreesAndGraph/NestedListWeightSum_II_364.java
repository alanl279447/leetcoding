package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.List;

public class NestedListWeightSum_II_364 {
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


        int result = depthSumInverse(nestedList);
        System.out.println(result);
    }

//    unweighted = Running sum of all numbers
//
//    weighted = Running sum OF above sum
//
//    e.g.                                   unweighted        weighted
//    level 1 - integers = [2]     sum = 2     2                2      =2
//    level 2 - integers = [1,3]   sum = 4     2 + 4            2 +  2+4  =8
//    level 3 - integers = [2,2] sum = 4     2 + 4 + 4       2 +  2+4 +  2+4+4  = 18

    public static int depthSumInverse(List<NestedInteger> nestedList) {
        int unweighted = 0, weighted = 0;
        while (!nestedList.isEmpty()) {
            List<NestedInteger> nextLevel = new ArrayList<>();
            for (NestedInteger ni : nestedList) {
                if (ni.isInteger())
                    unweighted += ni.getInteger();
                else
                    nextLevel.addAll(ni.getList());
            }
            weighted += unweighted;
            nestedList = nextLevel;
        }
        return weighted;
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
