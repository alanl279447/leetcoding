package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class PathWithMaximumMinimumValue_1102 {
//    Input: [[5,4,5],[1,2,6],[7,4,6]]
//    Output: 4
//    Explanation:
//    The path with the maximum score is highlighted in yellow.
//    https://leetcode.com/problems/path-with-maximum-minimum-value/

    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
//        System.out.println(boundary);
        int [] sticks = {2,4,3};
          int result = connectSticks(sticks);
        System.out.println(result);
    }


//    Input: sticks = [2,4,3]
//    Output: 14
//  2+3=5
// 5+4=9

    public static int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i: sticks) pq.add(i);
        int res = 0;
        while(pq.size() > 1){
            int t = pq.poll() + pq.poll();   // sum the two smallest
            res +=t;  // count the cost
            pq.offer(t); //
        }
        return res;
    }

}
