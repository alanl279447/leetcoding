package com.example.TreesAndGraph;

import java.net.BindException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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

        int[][] prerequisites = {{1, 0}, {2, 1}, {2,3}, {3,4}};
//        int[][] prerequisites = {{1, 0}, {0, 1}};
        System.out.print(canFinishSort(5, prerequisites));
    }

    //topological sort
    public static boolean canFinishSort(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses], res = new int[numCourses];
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        int index = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                q.offer(i);
                res[index++] = i;
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nei : graph[cur]) {
                if (--degree[nei] == 0) {
                    q.offer(nei);
                    res[index++] = nei;
                }
            }
        }
        return index == numCourses ? true : false;
    }

}
