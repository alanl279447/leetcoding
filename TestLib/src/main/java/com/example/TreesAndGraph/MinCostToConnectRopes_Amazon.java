package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinCostToConnectRopes_Amazon {
//    Input: ropes = [8, 4, 6, 12]
//    Output: 58
//    Explanation: The optimal way to connect ropes is as follows
//1. Connect the ropes of length 4 and 6 (cost is 10). Ropes after connecting: [8, 10, 12]
//            2. Connect the ropes of length 8 and 10 (cost is 18). Ropes after connecting: [18, 12]
//            3. Connect the ropes of length 18 and 12 (cost is 30).
//    Total cost to connect the ropes is 10 + 18 + 30 = 58
//    https://leetcode.com/discuss/interview-question/344677

    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
//        System.out.println(boundary);
        int [] ropes = {8,4,6,12};
          int result = connectRopes(ropes);
        System.out.println(result);
    }

    public static int connectRopes(int[] ropes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int rope:ropes) {
            pq.offer(rope);
        }
        int result =0;
        while(pq.size()>1) {
            int first = pq.poll();
            int second = pq.poll();
             int temp =first+second;
            pq.offer(temp);
            result +=temp;
        }
        return result;
    }

}
