package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class RobotRoomCleaner_489 {

//    https://leetcode.com/problems/robot-room-cleaner/discuss/151942/Java-DFS-Solution-with-Detailed-Explanation-and-6ms-(99)-Solution
//    time complexity 0(4^n)  n -no of 1's'
    public static Node root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
//        addNode(3);
//        System.out.print();
    }

    //backTracking
    //Visited set, and move along the 4 directions
    public void cleanRoom(Robot robot) {
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};    // 0 is up, 1 is right, 2 is down, 3 is left.
        dfs(robot, 0, 0, 0, dirs, new HashSet<>());  // We assume the robot is initially facing up.
    }

    private void dfs(Robot robot, int row, int col, int dir, int[][] dirs, Set<String> seen) {
        seen.add(row + "," + col);
        robot.clean();
        // Only recurse on neighbouring unseen 1's.
        for (int i = 0; i < 4; ++i) {
            int newDir = (dir + i) % 4;
            int newRow = row + dirs[newDir][0], newCol = col + dirs[newDir][1];
                if (!seen.contains(newRow + "," + newCol) && robot.move()) {
                dfs(robot, newRow, newCol, newDir, dirs, seen);

                // Backtrack. Go back to the initial position (row, col, dir) before the recursive call.
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
        }
    }

    static class Robot {
        public void clean() {}
        public static boolean move(){return true;}
        public void moveLeft() {}
        public void turnRight() {}
    }


    // Definition for a Node.
   public static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {}

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    };
}

