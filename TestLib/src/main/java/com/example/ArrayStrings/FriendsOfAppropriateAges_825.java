package com.example.ArrayStrings;

import java.util.Arrays;
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
