package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/discuss/interview-question/895097/

public class UtilizationChecks_Amazon {
    public static void main(String[] args) {
        List<Integer> averageUtil = Arrays.asList(25,23,1,2,3,4,5,6,7,8,9,10,76,80); //average utilization
        int instances = 2;   //initial server instances
        System.out.println(finalInstances(instances, averageUtil));
    }

    private static final int LIMIT = 2 * 100_000_000;
    public static int finalInstances(int instances, List<Integer> averageUtil) {
         for (int i=0;i<averageUtil.size(); i++) {
             int util = averageUtil.get(i);
             if (util < 25) {
              if (instances > 1) {
                  instances = instances/2 + instances % 2 ==0 ? 0 : 1;
                  i +=10;
              }
             } else if (util > 60) {
                int newLimit = 2 * instances;
                if (newLimit <= LIMIT) {
                    instances = newLimit;
                    i += 10;
                }
             }
         }
         return instances;
    }
}