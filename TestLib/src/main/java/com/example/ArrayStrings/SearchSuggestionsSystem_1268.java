package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class SearchSuggestionsSystem_1268 {
//    Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
//    Output: [
//            ["mobile","moneypot","monitor"],
//            ["mobile","moneypot","monitor"],
//            ["mouse","mousepad"],
//            ["mouse","mousepad"],
//            ["mouse","mousepad"]
//            ]
//    Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
//    After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
//    After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
//    https://leetcode.com/problems/search-suggestions-system/

//    Time O(NlogN) for sorting
//    Space O(logN) for quick sort.
//
//    Time O(logN) for each query
//    Space O(query) for each query
//    where I take word operation as O(1)

    public static void main(String args[]) {

        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        List<List<String>> res = suggestedProducts(products, "mouse");

        for(List<String> re: res) {
            System.out.println(re);
        }
    }

//    public static List<List<String>> suggestedProductsPrac(String[] products, String searchWord) {
//        List<List<String>> result = new ArrayList<>();
//        TreeMap<String, Integer> map = new TreeMap<>();
//        Arrays.sort(products);   //nlogn
//
//        for (int i=0; i<products.length;i++) {
//            map.put(products[i], i);
//        }
//
//        for (int i=0; i < searchWord.length(); i++) {
//
//        }
//    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        TreeMap<String, Integer> map = new TreeMap<>();
        Arrays.sort(products);
        List<String> productsList = Arrays.asList(products);

        for (int i = 0; i < products.length; i++) {
            map.put(products[i], i);
        }

        String key = "";
        for (char c : searchWord.toCharArray()) {
            key += c;
            String ceiling = map.ceilingKey(key);
            String floor = map.floorKey(key + "~");
            if (ceiling == null || floor == null) break;
            res.add(productsList.subList(map.get(ceiling), Math.min(map.get(ceiling) + 3, map.get(floor) + 1)));
        }

        while (res.size() < searchWord.length()) res.add(new ArrayList<>());
        return res;
    }

}
