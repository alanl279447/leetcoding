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
        int[] ages = {16,17,18};
        System.out.println(numFriendRequests(ages));
    }

    //binary search
    public static int numFriendRequestsBS(int[] ages) {
        int res = 0;
        Arrays.sort(ages);
        for (int i = 0; i < ages.length; ++i) {
            int age = ages[i];
            int lower = firstIdx(ages, age/2+7);
            int upper = firstIdx(ages, age);
            res += Math.max(upper-lower-1, 0);
        }
        return res;
    }

    private static int firstIdx(int[] ages, int target) {
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
        int res = 0;
        int[] numInAge = new int[121], sumInAge = new int[121];
        for(int i : ages)
            numInAge[i]++;

        for(int i = 1; i <= 120; ++i)
            sumInAge[i] = numInAge[i] + sumInAge[i - 1];

        for(int i = 15; i <= 120; ++i) {
            if(numInAge[i] == 0) continue;
            int count = sumInAge[i] - sumInAge[i / 2 + 7];
            res += count * numInAge[i] - numInAge[i]; //people will not friend request themselves, so  - numInAge[i]
        }
        return res;
    }
}