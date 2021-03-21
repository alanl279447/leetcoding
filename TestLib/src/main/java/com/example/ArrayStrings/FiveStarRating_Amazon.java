package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//For ex, there are 3 products (n=3) with productRatings =[[4,4],[1,2],[3,6]], percentage rating threshold = 77.
//[1,2] indicates => [1 (five star reviews) ,2 (total reviews)].
//We need to get the seller reach the threshold with minimum number of additional five star reviews.
// https://leetcode.com/discuss/interview-question/854110/
public class FiveStarRating_Amazon {
    public static void main(String[] args) {
        List<List<Integer>> ratings = new ArrayList(){{
                add(Arrays.asList(4,4));
                add(Arrays.asList(1,2));
                add(Arrays.asList(3,6)); }
        };
        int threshold = 77;
        System.out.println(fiveStarReviews(ratings, threshold));
    }

    public static int fiveStarReviews(List<List<Integer>> productRatings, int ratingsThreshold){
        int num = 0;
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((l1, l2) -> diff(l2) - diff(l1)); // max-heap.
        for(List<Integer> rating : productRatings) {
            pq.offer(rating); // initialize PriorityQueue.
        }
        double curRating = 0;
        for(List<Integer> rating : productRatings) {
            curRating += 100.0 * rating.get(0) / rating.get(1); // initialize curRating.
        }
        while(curRating < ratingsThreshold * productRatings.size()) {
            num++;
            List<Integer> rating = pq.poll();
            List<Integer> newRating = Arrays.asList(rating.get(0)+1, rating.get(1)+1);
            curRating = curRating - 100.0 * rating.get(0) / rating.get(1) + 100.0 * newRating.get(0) / newRating.get(1); // keep updating the rating.
            pq.offer(newRating);
        }
        return num;
    }

    // the diff between the current product rating and the product added one more five-star rating.
    private static int diff(List<Integer> p) {
        double currRating = 100.0 * p.get(0) / p.get(1);
        double newRating = 100.0 * (p.get(0)+1) / (p.get(1)+1);
        return (int)(newRating - currRating);
    }
}