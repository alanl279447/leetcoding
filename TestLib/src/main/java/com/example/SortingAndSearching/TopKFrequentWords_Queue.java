package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords_Queue {

//    Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//    Output: ["i", "love"]
//    Explanation: "i" and "love" are the two most frequent words.
//    Note that "i" comes before "love" due to a lower alphabetical order.
//
//    Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
//    Output: ["the", "is", "sunny", "day"]
//    Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
//    with the number of occurrence being 4, 3, 2 and 1 respectively.
//    https://leetcode.com/problems/top-k-frequent-words/

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.print(topKFrequent(words, 2));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<String>(
                (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                        w1.compareTo(w2) : count.get(w1) - count.get(w2) );

        for (String word: count.keySet()) {
            heap.offer(word);
            if (heap.size() > k) heap.poll();
        }

        List<String> ans = new ArrayList();
        while (!heap.isEmpty()) ans.add(heap.poll());
        Collections.reverse(ans);
        return ans;
    }

    // time complexity 0(n)
    public static List<String> topKFrequentFast(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) +1);
            max = Math.max(max, map.get(word));
        }
        List<String>[] bucket = new ArrayList[max+1];
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            int freq = entry.getValue();
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(entry.getKey());
        }
        List<String> result = new ArrayList<>();
        for (int i = max; i>=0 && result.size() < k; i--) {
             List<String> entries = bucket[i];
             if (entries != null) {
                 Collections.reverse(bucket[i]);
                 result.addAll(bucket[i]);
             }
        }
        return result.subList(0, k);
    }

    // solution with time complexity for O(n)
//    public static List<Integer> topKFrequentFast(int[] nums, int k) {
//        Map<Integer, Integer> hm = new HashMap<>();
//        List<Integer>[] bucket = new List[nums.length + 1];
//        List<Integer> res = new ArrayList<>();
//        for(int num: nums){
//            hm.put(num, hm.getOrDefault(num, 0) + 1);
//        }
//        for(int key: hm.keySet()){
//            int frequency = hm.get(key);
//            if(bucket[frequency] == null)
//                bucket[frequency] = new ArrayList<>();
//            bucket[frequency].add(key);
//        }
//        for(int pos = bucket.length-1; pos >= 0; pos--){
//            if(bucket[pos] != null){
//                for(int i = 0; i < bucket[pos].size() && res.size() < k; i++)
//                    res.add(bucket[pos].get(i));
//            }
//        }
//        return res;
//    }
//
//    public static List<Integer> topKFrequent(int[] nums, int k) {
//        final Map<Integer, Integer> count = new HashMap<Integer, Integer>();
//        for (int num: nums) {
//            count.put(num, count.getOrDefault(num, 0)+1);
//        }
//
//        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer i1, Integer i2) {
//                return count.get(i1) - count.get(i2);
//            }
//        });
//
//        for (int i: count.keySet()) {
//            queue.add(i);
//            if (queue.size() > k) {
//                queue.poll();
//            }
//        }
//
//        List<Integer> output = new ArrayList<>();
//        for (int i = 0; i < k; i++) {
//            output.add(queue.poll());
//        }
//        Collections.reverse(output);
//        return output;
//    }

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
