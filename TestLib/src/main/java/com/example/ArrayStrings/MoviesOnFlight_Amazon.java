package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoviesOnFlight_Amazon {
//    Input: movieDurations = [90, 85, 75, 60, 120, 150, 125], d = 250
//    Output: [0, 6]
//    Explanation: movieDurations[0] + movieDurations[6] = 90 + 125 = 215 is the maximum number within 220 (250min - 30min)
//    https://leetcode.com/discuss/interview-question/313719/Amazon-or-Online-Assessment-2019-or-Movies-on-Flight

    public static void main(String[] args) {
        int[] movie_duration1 = {90, 85, 75, 60, 120, 150, 125};  //[0, 6]
        int d1 = 250;
        int[] movie_duration2 = {90, 85, 75, 60, 155, 150, 125};  //[3, 4]
        int d2 = 250;
        int[] movie_duration3 = {90, 85, 75, 60, 120,110,110, 150, 125};  //[5, 6]
        int d3 = 250;
        System.out.println(Arrays.toString(get2SumClosest(movie_duration1, d1-30)));
//        System.out.println(Arrays.toString(get2SumClosest(movie_duration2, d2-30)));
//        System.out.println(Arrays.toString(get2SumClosest(movie_duration3, d3-30)));
    }

//    private static int[] get2SumClosestTest(int[] movie_duration, int d) {
//
//
//    }

    private static int[] get2SumClosest(int[] movie_duration, int d) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<movie_duration.length;i++) {
            map.putIfAbsent(movie_duration[i], new ArrayList<>());
            map.get(movie_duration[i]).add(i);
        }
        Arrays.sort(movie_duration);
        int l = 0, r = movie_duration.length - 1;
        int max = 0;
        int[] res = new int[]{-1, -1};
        while(l < r) {
            int sum = movie_duration[l] + movie_duration[r];
            if((sum > max || (sum == max && Math.max(movie_duration[l] , movie_duration[r]) > Math.max(res[0],  res[1]))) && sum <= d) {
                max = sum;
                res[0] = movie_duration[l];
                res[1] = movie_duration[r];
            }
            if(sum > d)
                r--;
            else
                l++;
        }
        if(map.get(res[0]) == map.get(res[1])) {
            res[0] = map.get(res[0]).get(0);
            res[1] = map.get(res[1]).get(1);
        }else {
            res[0] = map.get(res[0]).get(0);
            res[1] = map.get(res[1]).get(0);
        }
        return res;
    }
}