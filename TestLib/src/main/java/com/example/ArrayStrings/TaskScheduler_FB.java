package com.example.ArrayStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TaskScheduler_FB {
//    Input: tasks = ["A","B","C","A","B","C"], n = 3
//    Output: 8
//    A-B-C-X-A-B-C
//    https://leetcode.com/problems/task-scheduler/

    public static void main(String args[]) {

        char[] input = {'A','B','C','A','B','C'};
        int result = leastIntervalTest(input, 3);
        System.out.println(result);  //3
    }

    public static int leastIntervalTest(char[] tasks, int n) {
       if (tasks == null || tasks.length==0) return 0;
       HashMap<Character, Integer> lastOccurMap = new HashMap();
       int resultTime = 0;
       for (int i=0; i< tasks.length; i++) {
           int lastOccurTime = lastOccurMap.getOrDefault(tasks[i], -1);
           if (lastOccurTime == -1 || (resultTime-lastOccurTime) >= n) {
               resultTime++;
               lastOccurMap.put(tasks[i], resultTime);
           } else {
               int waitTime = n - (resultTime-lastOccurTime);
               resultTime += waitTime+1;
               lastOccurMap.put(tasks[i], resultTime);
           }
       }
       return resultTime;
    }


//    public static int leastInterval(char[] tasks, int n) {
//        Map<Character, Integer> map = new HashMap<>();
//        int totalTime = 0;
//        for (int i = 0; i < tasks.length; i++) {
//            char c = tasks[i];
//            int tasktime = map.getOrDefault(c, 0);
//            if (tasktime == 0) {
//                totalTime++;
//                map.put(c, totalTime);
//            } else {
//                int expiredTime = totalTime - tasktime;
//                if (expiredTime > n) {
//                    totalTime++;
//                } else {
//                    totalTime +=(n-expiredTime)+1;
//                }
//                map.put(c, totalTime);
//            }
//        }
//        return totalTime;
//    }

}
