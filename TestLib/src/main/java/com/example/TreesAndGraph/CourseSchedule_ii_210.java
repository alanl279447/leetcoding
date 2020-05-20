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

    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {

        int[][] prerequisites = {{1, 0}, {2, 1}, {2,3}};
//        int[][] prerequisites = {{1, 0}, {0,1}};
        int[] result = findOrder(4, prerequisites);
        for(int res: result) {
            System.out.print(res);
        }
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];

        for (int i =0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i =0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] result = new int[numCourses];
        int count = 0;
        while(!queue.isEmpty()) {
            int course = queue.poll();
            result[count] = course;
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == course) {
                    inDegree[prerequisites[i][0]]--;

                    if (inDegree[prerequisites[i][0]] == 0) {
                        queue.offer(prerequisites[i][0]);
                    }
                }
            }
            count++;
        }
        return result;
    }

}
