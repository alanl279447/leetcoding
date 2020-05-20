package com.example.ArrayStrings;

public class NumberofDaysBetweenTwoDates_1360 {

//    Input: date1 = "2020-01-15", date2 = "2019-12-31"
//    Output: 15
//    https://leetcode.com/problems/number-of-days-between-two-dates/

    public static void main(String args[]) {
        int res = daysBetweenDates("2020-01-15", "2019-12-31");
        System.out.println(res);
    }

    public static int daysBetweenDates(String date1, String date2) {
        return Math.abs(computeDays(date1) - computeDays(date2));
    }

    private static int computeDays(String date) {
        int[] monthDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] data = date.split("-");

        int year = Integer.parseInt(data[0]);
        int month = Integer.parseInt(data[1]);
        int day = Integer.parseInt(data[2]);

        for (int i = 1971; i < year; i++) {
            day += isALeapYear(i) ? 366 : 365;
        }
        for (int i = 1; i < month; i++) {
            if (isALeapYear(year) && i == 2) {
                day += 1;
            }
            day += monthDays[i];
        }
        return day;
    }

    private static boolean isALeapYear(int year) {
        return (year %4 ==0 && year % 100 != 0) || year %400 == 0;
    }
}
