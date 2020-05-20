package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleTest {

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
//        int[][] prerequisites = {{1, 0}, {0, 1}};
        System.out.print(canFinish(4, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
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

//        for (int i = 0; i < inDegree.length; i++) {
//            if (inDegree[i] == 0)
//                queue.offer(i);
//        }
//        while (!queue.isEmpty()) {
//            int x = queue.poll();
//            for (int i = 0; i < prerequisites.length; i++) {
//                if (x == prerequisites[i][0]) {
//                    inDegree[prerequisites[i][1]]--;
//                    if (inDegree[prerequisites[i][1]] == 0)
//                        queue.offer(prerequisites[i][1]);
//                }
//            }
//        }
//        for (int i = 0; i < inDegree.length; i++) {
//            if (inDegree[i] != 0)
//                return false;
//        }
//        return true;
    }


//    public static boolean canFinish(int numCourses, int[][] prerequisites) {
//        boolean canFinishCourse = false;
//        Queue<Integer> queue = new LinkedList<>();
//        int[] inDegree = new int[numCourses];
//
//        //increment the inDegree for course which are pre-requisitics.
//        for (int i = 0; i < prerequisites.length; i++) {
//            inDegree[prerequisites[i][1]]++;
//        }
//
//        for (int i = 0; i < numCourses; i++) {
//            if (inDegree[i] == 0) {
//                queue.offer(prerequisites[i][1]); //add the course in the
//            }
//        }
//
//        while(!queue.isEmpty()) {
//            int item = queue.poll();
//            for (int i = 0; i < prerequisites.length; i++) {
//                if (item == prerequisites[i][0]) {
//                    inDegree[prerequisites[i][1]]--;
//                    if (inDegree[prerequisites[i][1]] == 0) {
//                        queue.offer(prerequisites[i][1]);
//                    }
//                }
//            }
//        }
//
//        for (int i =0; i < inDegree.length; i++) {
//            if (inDegree[i] != 0) return false;
//        }
//
//        return true;
//    }



}
