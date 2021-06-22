package com.example.ArrayStrings;

public class AngleBetweenHandsofClock_1344 {
//    Input: hour = 12, minutes = 30
//    Output: 165
//    https://leetcode.com/problems/angle-between-hands-of-a-clock/
    public static void main(String[] args) {
        System.out.println(angleClock(12, 30));
    }

    public static double angleClock(int hour, int minutes) {
        // Degree covered by hour hand (hour area + minutes area)
//        double h = (hour%12)/12 * 360 + ((double)minutes/60 * 30);
         double h = (hour%12 + (double)minutes/60) *360/12;

        // Degree covered by minute hand (Each minute = 6 degree)
        double m = minutes * 360/60;

        // Absolute angle between them
        double angle = Math.abs(m - h);

        // If the angle is obtuse (>180), convert it to acute (0<=x<=180)
        if (angle > 180) angle = 360.0 - angle;

        return angle;
    }
}