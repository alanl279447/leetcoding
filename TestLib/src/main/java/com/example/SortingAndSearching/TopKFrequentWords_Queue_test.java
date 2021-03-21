package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import javafx.scene.layout.Priority;

public class TopKFrequentWords_Queue_test {

//    Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//    Output: ["i", "love"]
//    Explanation: "i" and "love" are the two most frequent words.
//    Note that "i" comes before "love" due to a lower alphabetical order.
//
//    Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
//    Output: ["the", "is", "sunny", "day"]
//    Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
//    with the number of occurrence being 4, 3, 2 and 1 respectively.

//    eg: reviews: ['I love Google', 'I love Apple', 'I love Google more than Apple but Apple products are nice as well', 'Apple products are great', 'I love Microsoft']
//    competitors: ['Google', 'Apple', 'Netflix', 'Microsoft']
//    topNCompetitors: 2
//    time complexity (0nlogn)
//    https://leetcode.com/discuss/interview-question/542597/Amazon-or-OA-2020-or-Top-K-Frequently-Mentioned-Keywords

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
//        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        String[] reviews = {"I love Google", "I love Apple", "I love Google more than Apple but Apple products are nice as well",
                "Apple products are great", "I love Microsoft"};
        String[] competitors = {"Google", "Apple", "Netflix", "Microsoft"};
        int topNCompetitors = 2;
        List<String> result = topKFrequent(reviews, competitors, topNCompetitors);
        for (String res: result) {
            System.out.print(res);
        }
    }

    public static List<String> topKFrequent(String[] reviews, String[] competitors, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Set<String> visitedWords = new HashSet<>();
        List<String> competitorsList = Arrays.asList(competitors);

        for(String review: reviews) {
           String[] words = review.split(" ");
           for (String word: words) {
               if (!visitedWords.contains(word) && competitorsList.contains(word)) {
                   map.put(word, map.getOrDefault(word, 0) + 1);
                   visitedWords.add(word);
               }
           }
           visitedWords.clear();
        }
        PriorityQueue<String> queue = new PriorityQueue<>((w1,w2) -> map.get(w1).equals(map.get(w2)) ? w1.compareTo(w2):
                map.get(w1) - map.get(w2));

        for (String word: map.keySet()) {
            queue.offer(word);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        while(!queue.isEmpty()) {
            result.add(queue.poll());
        }
        return result;
    }
//    public static List<String> topKFrequent(String[] words, int k) {
//        Map<String, Integer> count = new HashMap();
//        for (String word : words) {
//            count.put(word, count.getOrDefault(word, 0) + 1);
//        }
//        List<String> candidates = new ArrayList(count.keySet());
//        Collections.sort(candidates, (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
//                w1.compareTo(w2) : count.get(w2) - count.get(w1));
//
//        return candidates.subList(0, k);
//    }


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
