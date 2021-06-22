package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

//Input: people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
//        Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
//        Explanation:
//        Person 0 has height 5 with no other people taller or the same height in front.
//        Person 1 has height 7 with no other people taller or the same height in front.
//        Person 2 has height 5 with two persons taller or the same height in front, which is person 0 and 1.
//        Person 3 has height 6 with one person taller or the same height in front, which is person 1.
//        Person 4 has height 4 with four people taller or the same height in front, which are people 0, 1, 2, and 3.
//        Person 5 has height 7 with one person taller or the same height in front, which is person 1.
//        Hence [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] is the reconstructed queue.
//        https://leetcode.com/problems/queue-reconstruction-by-height/

//  {7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}
//  (7,0), (7,1), (6,1), (5,0), (5,2), (4,4)
//  (5,0), (7,0), (5,2), (6,1),(4,4), (7,1)

public class QueueReconstructionbyHeight_406 {
    public static void main(String[] args) {
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        System.out.println(reconstructQueue(people));
    }

    public static int[][] reconstructQueue(int[][] people) {
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ?  o1[1] - o2[1] : o2[0] - o1[0] );
        for( int[] p : people ) {
            pq.add(p);
        }
        List<int[]> list = new ArrayList<>();
        while( ! pq.isEmpty() ) {
            int[] cur = pq.poll();
            list.add( cur[1], cur );
        }

//        return list.toArray(new int[list.size()][2]);
        int[][] res = new int[people.length][2];
        for( int i = 0; i < people.length; i++ ) {
            res[i] = list.get(i);
        }
        return res;
    }
}