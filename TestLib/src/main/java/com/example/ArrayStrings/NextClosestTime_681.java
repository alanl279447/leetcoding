package com.example.ArrayStrings;

import java.util.HashSet;
import java.util.Set;

public class NextClosestTime_681 {
//    Input: "19:34"
//    Output: "19:39"
//    Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39,
//    which occurs 5 minutes later.  It is not 19:33, because this occurs 23 hours and 59 minutes later.
//    https://leetcode.com/problems/next-closest-time/

    public static void main(String[] args) {
        System.out.println(nextClosestTime("19:34"));
    }

    public static String nextClosestTime(String time) {
        int start = 60 * Integer.parseInt(time.substring(0, 2));
        start += Integer.parseInt(time.substring(3));
        int ans = start;
        int elapsed = 24 * 60;
        Set<Integer> allowed = new HashSet();
        for (char c: time.toCharArray())
            if (c != ':') {
                allowed.add(c - '0');
            }
        for (int h1: allowed)
            for (int h2: allowed)
                if (h1 * 10 + h2 < 24) {
                    for (int m1: allowed)
                        for (int m2: allowed)
                            if (m1 * 10 + m2 < 60) {
                                int cur = 60 * (h1 * 10 + h2) + (m1 * 10 + m2);
                                //int candElapsed = Math.floorMod(cur - start, 24 * 60);
                                int candElapsed = (cur - start < 0) ? cur - start + 24 * 60 : cur - start;
                                if (0 < candElapsed && candElapsed < elapsed) {
                                    ans = cur;
                                    elapsed = candElapsed;
                                }
                            }
                }
        return String.format("%02d:%02d", ans / 60, ans % 60);
    }
}