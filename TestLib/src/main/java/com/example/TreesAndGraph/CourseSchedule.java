package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

//    Input: 2, [[1,0]]
//    Output: true
//    Explanation: There are a total of 2 courses to take.
//    To take course 1 you should have finished course 0. So it is possible.

//    Input: 2, [[1,0],[0,1]]
//    Output: false
//    Explanation: There are a total of 2 courses to take.
//    To take course 1 you should have finished course 0, and to take course 0 you should
//    also have finished course 1. So it is impossible.
//    https://leetcode.com/problems/course-schedule/
    //time complexity 0(E+V)
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {

        int[][] prerequisites = {{1, 0}, {2, 1}, {2,3}};
//        int[][] prerequisites = {{1, 0}, {0, 1}};
        System.out.print(canFinishSort(4, prerequisites));
    }

    //topological sort
    public static boolean canFinishSort(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0)
            return false;
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
        }
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i =0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                stack.push(i);
            }
        }

        int count = 0;
        while(!stack.isEmpty()) {
            int curr = stack.pop();
            count++;
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == curr) {
                    inDegree[prerequisites[i][0]]--;

                    if (inDegree[prerequisites[i][0]] == 0) {
                        stack.push(prerequisites[i][0]);
                    }
                }
            }
        }
        return numCourses == count;
    }

}
