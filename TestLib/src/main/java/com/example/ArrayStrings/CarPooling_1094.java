package com.example.ArrayStrings;

import java.util.HashMap;
import java.util.TreeMap;

public class CarPooling_1094 {
//    Input: trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
//    Output: true
//    https://leetcode.com/problems/car-pooling/

    public static void main(String[] args) {
        int[][] trips = {{3,2,7}, {3,7,9},{8,3,9}};
        System.out.println(carPooling(trips, 11));
    }

    public static boolean carPoolingHashMap(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] trip: trips) {
            map.put(trip[1], map.getOrDefault(trip[1], 0)+trip[0]);
            map.put(trip[2], map.getOrDefault(trip[2], 0)-trip[0]);
        }

        for (int value: map.values()) {
           capacity -=value;
           if (capacity < 0) {
               return false;
           }
        }
        return true;
    }

    //Process all trips, adding passenger count to the start location, and removing it from the end location.
    // After processing all trips, a positive value for the specific location tells that we are getting more passengers;
    // negative - more empty seats.
    public static boolean carPooling(int[][] trips, int capacity) {
        int[] timestamp = new int[1001];
        for (int[] trip : trips) {
            timestamp[trip[1]] += trip[0];
            timestamp[trip[2]] -= trip[0];
        }
        int usedCapacity = 0;
        for (int number : timestamp) {
            usedCapacity += number;
            if (usedCapacity > capacity) {
                return false;
            }
        }
        return true;
    }
}