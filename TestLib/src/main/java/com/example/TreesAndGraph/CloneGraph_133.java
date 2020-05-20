package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph_133 {
//    Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
//    Output: [[2,4],[1,3],[2,4],[1,3]]
//    Explanation: There are 4 nodes in the graph.
//            1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
//            2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
//            3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
//            4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
//    https://leetcode.com/problems/clone-graph/

    public static Node root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
//        addNode(3);
        System.out.print(cloneGraph(root));
    }

    public static Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        HashMap<Node,Node> visitedMap = new HashMap<>();   //visited map of the node and clone
        LinkedList<Node> queue = new LinkedList<>();  //queue of nodes to Visit
        queue.add(node);
        visitedMap.put(node, new Node(node.val, new ArrayList<>()));

        while(!queue.isEmpty()) {
            Node currentNode = queue.remove();
            List<Node> neighbours_list = currentNode.neighbors;
            for(Node neighbor: neighbours_list) {
                if(!visitedMap.containsKey(neighbor)) {
                    visitedMap.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.add(neighbor);
                }
                visitedMap.get(currentNode).neighbors.add(visitedMap.get(neighbor));
            }
        }
        return visitedMap.get(node);
    }

    // Definition for a Node.
   public static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    };
}

