package com.example.HashTable;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//        int k = 3;
//        int[] arr = [4,5,8,2];
//        KthLargest kthLargest = new KthLargest(3, arr);
//        kthLargest.add(3);   // returns 4
//        kthLargest.add(5);   // returns 5
//        kthLargest.add(10);  // returns 5
//        kthLargest.add(9);   // returns 8
//        kthLargest.add(4);   // returns 8
//        https://leetcode.com/problems/kth-largest-element-in-a-stream/

public class KthLargestElementinaStream_703 {

    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[] arr = {4,5,8,2};
        KthLargest obj = new KthLargest(3, arr);
        int param_1 = obj.add(3);
        System.out.println(param_1);
    }

    static class KthLargest {
        PriorityQueue<Integer> pq = null;
        int k=0;
        public KthLargest(int k, int[] nums) {
          pq = new PriorityQueue<>(k);
          k = k;
          for (int num:nums) {
              add(num);
          }
        }

        public int add(int val) {
           if (pq.size() < k) {
               pq.offer(val);
           } else if (pq.peek() < val) {
              pq.poll();
              pq.offer(val);
           }
           return pq.peek();
        }
    }
}
