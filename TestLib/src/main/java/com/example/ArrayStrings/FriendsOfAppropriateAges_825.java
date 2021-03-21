package com.example.ArrayStrings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class FriendsOfAppropriateAges_825 {

//    Input: [16,16]
//    Output: 2
//    Explanation: 2 people friend request each other.
//    https://leetcode.com/problems/friends-of-appropriate-ages/

//    age[B] <= 0.5 * age[A] + 7
//    age[B] > age[A]
//    age[B] > 100 && age[A] < 100

    public static void main(String[] args) {
        int[] ages = {16,17, 18};
        System.out.println(numFriendRequests(ages));
    }

    //binary search
    public static int numFriendRequestsTest(int[] ages) {
        int result =0;
        for (int i=0; i <ages.length;i++) {
           int age = ages[i];
           int lower = findFirstIdx(ages, age/2-7);
           int upper = findFirstIdx(ages, age);
           result += Math.max(0, upper-lower-1);
        }
        return result;
    }

    public static int findFirstIdx(int[] ages, int target) {
        int beg = 0;
        int end = ages.length-1;
        while (beg <= end) {
            int mid = beg + (end-beg)/2;
            if (ages[mid] <= target) beg = mid + 1;
            else end = mid - 1;
        }
        return beg;
    }

   //fixed based on ages
    public static int numFriendRequests(int[] ages) {
        int[] map = new int[121];

        for(int age:ages){
            map[age]++;
        }

        for(int i=1;i<map.length;i++){
            map[i] += map[i-1];
        }

        int fr = 0;
        for(int age:ages){
            fr += Math.max(0,map[age] - map[(age/2)+7] - 1);
        }

        return fr;
    }
}
