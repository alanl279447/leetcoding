package com.example.TreesAndGraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.stream.Collectors;

public class ReconstructItinerary_332 {
//    Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
//    Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
//    https://leetcode.com/problems/reconstruct-itinerary/
    //["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
//        String [][] inputString = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
        String [][] inputString = {{"JFK","SFO"}, {"JFK","ATL"}, {"SFO","ATL"}, {"ATL","JFK"}, {"ATL","SFO"}};
        List<List<String>> res = Arrays.stream(inputString).map(Arrays::asList).collect(Collectors.toList());
        List<String> result = findItinerary(inputString);
        for (String res1:result)
           System.out.print(res1);
    }

//    Map<String, PriorityQueue<String>>
//    JFK, {SFO, ATL}  SFO, {ATL},  ATL, {JFK, SFO}
//    BFS queue start from JFK

//    public static List<String> findItineraryTest(String[][] tickets) {
//        Map<String, PriorityQueue<String>> targetMap = new HashMap<>();
//        for (String[] ticket: tickets) {
//           targetMap.computeIfAbsent(ticket[0], k-> new PriorityQueue<>()).add(ticket[1]);
//        }
//
//
//    }


    public static List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> targets = new HashMap<>();
        for (String[] ticket : tickets)
            targets.computeIfAbsent(ticket[0], k -> new PriorityQueue()).add(ticket[1]);

        List<String> route = new LinkedList();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.empty()) {
            while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty()) {
                String value = targets.get(stack.peek()).poll();
                stack.push(value);
            }
            route.add(0, stack.pop());
        }
        return route;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void addNode(int value) {
        root = addNodeRecursive(root, value);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
    }

    public static TreeNode addNodeRecursive(TreeNode node, int value) {
//        TreeNode newNode = null;
        if (node == null) {
            node = new TreeNode(value);
            return node;
        }

        if (value < node.val) {
            node.left = addNodeRecursive(node.left, value);
        } else if (value > node.val){
            node.right = addNodeRecursive(node.right, value);
        } else {
            return node;
        }
        return node;
    }
}
