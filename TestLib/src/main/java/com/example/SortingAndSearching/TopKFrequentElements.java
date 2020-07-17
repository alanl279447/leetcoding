package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

//    Input: nums = [1,1,1,2,2,3], k = 2
//    Output: [1,2]

//    Input: nums = [1], k = 1
//    Output: [1]

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1, 2, 2, 2, 2, 3};
        System.out.print(topKFrequentFast(nums1, 2));
    }

    // solution with time complexity for O(n)
    public static List<Integer> topKFrequentFast(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        List<Integer> res = new ArrayList<>();
        for(int num: nums){
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        for(int key: hm.keySet()){
            int frequency = hm.get(key);
            if(bucket[frequency] == null)
                bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(key);
        }
        for(int pos = bucket.length-1; pos >= 0; pos--){
            if(bucket[pos] != null){
                for(int i = 0; i < bucket[pos].size() && res.size() < k; i++)
                    res.add(bucket[pos].get(i));
            }
        }
        return res;
    }


//    Time complexity : \mathcal{O}(N \log(k))O(Nlog(k)).
//    The complexity of Counter method is \mathcal{O}(N)O(N).
//    To build a heap and output list takes \mathcal{O}(N \log(k))O(Nlog(k)).
//    Hence the overall complexity of the algorithm is \mathcal{O}(N + N \log(k)) = \mathcal{O}(N \log(k))O(N+Nlog(k))=O(Nlog(k)).
//
//    Space complexity : \mathcal{O}(N)O(N) to store the hash map.
    public static List<Integer> topKFrequent(int[] nums, int k) {
        final Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return count.get(i1) - count.get(i2);
            }
        });

        for (int i: count.keySet()) {
            queue.add(i);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            output.add(queue.poll());
        }
        Collections.reverse(output);
        return output;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void addNode(int value) {
        root = addNodeRecursive(root, value);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
    }

    public static TreeNode addNodeRecursive(TreeNode node, int value) {
//        TreeNode newNode = null;
        if (node == null) {
            node = new TreeNode(value);
            return node;
        }

        if (value < node.val) {
            node.left = addNodeRecursive(node.left, value);
        } else if (value > node.val){
            node.right = addNodeRecursive(node.right, value);
        } else {
            return node;
        }
        return node;
    }
}
