package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule_ii_210 {

//    Input: 2, [[1,0]]
//    Output: true
//    Explanation: There are a total of 2 courses to take.
//    To take course 1 you should have finished course 0. So it is possible.

//    Input: 2, [[1,0],[0,1]]
//    Output: false
//    Explanation: There are a total of 2 courses to take.
//    To take course 1 you should have finished course 0, and to take course 0 you should
//    also have finished course 1. So it is impossible.
//    https://leetcode.com/problems/course-schedule-ii/solution/

    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {

        int[][] prerequisites = {{1, 0}, {2, 1}, {2,3}};
//        int[][] prerequisites = {{1, 0}, {0,1}};
        int[] result = findOrder(4, prerequisites);
        for(int res: result) {
            System.out.print(res);
        }
    }

    public static int[] findOrderTest(int numCourses, int[][] prerequisites) {
      int[] inDegree = new int[numCourses];
      List<List<Integer>> adj = new ArrayList<>();
      int[] result = new int[numCourses];
      for (int i = 0; i < numCourses; i++) {
          adj.add(new ArrayList<>());
      }
      for (int[] pre: prerequisites) {
          adj.get(pre[1]).add(pre[0]);  //adj list for the dependency
          inDegree[pre[0]]++;           // increase the inDegree for the courses having pre-requisite
      }

      Queue<Integer> queue = new LinkedList<>();
      for (int i = 0; i < numCourses; i++) {
          if (inDegree[i] == 0) {
              queue.offer(i);
          }
      }

      int index = 0;
      while (!queue.isEmpty()) {
          int node = queue.poll();
          result[index++] = node;
          for (int neigh: adj.get(node)) {
              if (--inDegree[neigh] == 0) {
                  queue.offer(neigh);
              }
          }
      }
      return index == numCourses ? result : new int[0];
    }

    //java BFS soln with adj list
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
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
        return index == numCourses ? res : new int[0];
    }

}
