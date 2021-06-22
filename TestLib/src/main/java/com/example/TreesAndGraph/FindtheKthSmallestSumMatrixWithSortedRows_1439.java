package com.example.TreesAndGraph;


import java.util.Collections;
import java.util.PriorityQueue;

//Input: mat = [[1,3,11],[2,4,6]], k = 5
//        Output: 7
//        Explanation: Choosing one element from each row, the first k smallest sum are:
//        [1,2], [1,4], [3,2], [3,4], [1,6]. Where the 5th sum is 7.
//https://leetcode.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/
//O(m * n * k * logk)
class FindtheKthSmallestSumMatrixWithSortedRows_1439 {
    public static void main(String[] args) {
//        var sum = kthSmallest(arrayOf(intArrayOf(1, 3, 11), intArrayOf(2, 4, 6)), 5)
////    var sum = kthSmallest(arrayOf(intArrayOf(1,10,10), intArrayOf(1,4,5), intArrayOf(2,3,6)), 2)
//        println(sum)
        int[][] input = {{1,3,11}, {2,4,6}};
        int sum = kthSmallest(input, 5);
        System.out.println(sum);
    }

    public static int kthSmallest(int[][] mat, int k) {
        int col = Math.min(mat[0].length, k);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        for (int[] row : mat) {
            // max priority queue for the i-th row
            PriorityQueue<Integer> nextPq = new PriorityQueue<>(Collections.reverseOrder());
            for (int i : pq) {
                for (int c = 0; c < col; c++) {
                    nextPq.add(i + row[c]);
                    // keep pq size <= k
                    if (nextPq.size() > k) {
                        nextPq.poll();
                    }
                }
            }
            pq = nextPq;
        }
        return pq.poll();
    }
}
//will need two PQ to get the result
//outer pq will be set to 0, then will add K elements from each row 0, 0+1 0+10 0+10, 0+1+1, 0+1+4, 0+1+5
//inner pq will add next row elements to items in the pq
// get item from PQ and

   // 1 3 11
   // 2 4 6
