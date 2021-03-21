package com.example.ArrayStrings;

import java.util.LinkedList;
import java.util.List;

//        Input: seats = [1,0,0,0,1,0,1]
//        Output: 2
//        Explanation:
//        If Alex sits in the second open seat (i.e. seats[2]), then the closest person has distance 2.
//        If Alex sits in any other open seat, the closest person has distance 1.
//        Thus, the maximum distance to the closest person is 2.
//        https://leetcode.com/problems/maximize-distance-to-closest-person/

public class MaximizeDistancetoClosestPerson_849 {
    public static void main(String[] args) {
        int[] seats = {1,0,0,0,1,0,1};
        System.out.println(maxDistToClosest(seats));
    }

    public static int maxDistToClosest(int[] nums) {
        int n = nums.length;
        int max = 0;
        int i = 0;
        while(i < n){
            while(i < n && nums[i] == 1){
                i++;
            }
            int j = i;//start
            while(i < n && nums[i] == 0){
                i++;
            }
            if(j == 0 || i == n){
                max = Math.max(max, i - j);
            }else{
                max = Math.max(max, (i - j + 1) / 2) ;
            }
        }
        return max;
    }
}