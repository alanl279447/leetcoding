package com.example.ArrayStrings;

//Input: "GGLLGG"
//        Output: true
//        Explanation:
//        The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
//        When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
//        https://leetcode.com/problems/robot-bounded-in-circle/

public class RobotBoundedInCircle_1041 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(isRobotBounded("GGLLGG"));
    }

    public static boolean isRobotBounded(String ins) {
        // north = 0, east = 1, south = 2, west = 3
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // Initial position is in the center
        int x = 0, y = 0;
        // facing north
        int idx = 0;

        for (char i : ins.toCharArray()) {
            if (i == 'L')
                idx = (idx + 3) % 4;
            else if (i == 'R')
                idx = (idx + 1) % 4;
            else {
                x += directions[idx][0];
                y += directions[idx][1];
            }
        }

        // after one cycle:
        // robot returns into initial position
        // or robot doesn't face north
        return (x == 0 && y == 0) || (idx != 0);
    }
}