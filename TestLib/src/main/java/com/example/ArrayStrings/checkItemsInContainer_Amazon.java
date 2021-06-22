package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

public class checkItemsInContainer_Amazon {

//    https://leetcode.com/discuss/interview-question/861453/
    //O(n log n + m log n)
//    https://aonecode.com/amazon-online-assessment-items-in-containers
    public static void main(String[] args) {
        List<Integer> res1=numberOfItems("|**|*|*", Arrays.asList(1,1), Arrays.asList(5,6));  //2,3
//        List<Integer> res2=numberOfItems("*|*", Arrays.asList(1), Arrays.asList(5));    //0
        for (Integer res: res1) System.out.println(res);
//        System.out.println();
//        for (Integer res: res2) System.out.println(res);
    }

    public static List<Integer> numberOfItems(String s, List<Integer> start, List<Integer> end) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int countSoFar = 0;
        for (int i = 0; i< s.length(); i++) {
            if (s.charAt(i) == '|') {
                treeMap.put(i, countSoFar);
            } else {
                countSoFar++;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<start.size(); i++) {
            list.add(number(treeMap, start.get(i) - 1, end.get(i) - 1));
        }
        return list;
    }

    static int number(NavigableMap<Integer, Integer> treemap, int start, int end) {
        if (treemap.floorEntry(end) == null || treemap.ceilingEntry(start) == null)
            return 0;
        int i = treemap.floorEntry(end).getValue() - treemap.ceilingEntry(start).getValue();
        return Math.max(i, 0);
    }
}