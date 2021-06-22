package com.example.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class StickerstoSpellWord_691 {
//    https://leetcode.com/problems/stickers-to-spell-word/
//    ["with", "example", "science"], "thehat"
//    3
    //O((m ^ n) * (26 ^ n) * n!)
//    https://leetcode.com/problems/stickers-to-spell-word/discuss/108318/C%2B%2BJavaPython-DP-%2B-Memoization-with-optimization-29-ms-(C%2B%2B)

    public static void main(String[] args) {
        String[] stickers = {"with", "example", "science"};
        System.out.print(minStickers(stickers, "thehat"));
    }

    //create a DP array int[][] map = new int[n][26]
    //create a memo Map<String, Int> dpMap
//    level 1: m * 26 * n
//    level 2: m * 26 * (n - 1)
//            ....
//    level n: m * 26 * 1

    public static int minStickers(String[] stickers, String target) {
        int n = stickers.length;
        int[][] map = new int[n][26];
        for (int i = 0; i < n; i++) {
            for (char c : stickers[i].toCharArray()) {
                map[i][c - 'a']++;
            }
        }
        Map<String, Integer> dpMap = new HashMap<>();
        return dfs(target, map, dpMap);
    }

    private static int dfs(String target, int[][] map, Map<String, Integer> dpMap) {
        if (target.length() == 0)  return 0;
        if (dpMap.containsKey(target))
            return dpMap.get(target);

        int[] curMap = new int[26];
        for (char c : target.toCharArray()) {
            curMap[c - 'a']++;    //thehat
        }

        int n = map.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int[] compare = map[i];    //with", "example", "science
            StringBuilder sb = new StringBuilder();

            //prune:
            if (compare[target.charAt(0) - 'a'] == 0)  continue;

            for (int j = 0; j < 26; j++) {
                if (curMap[j] != 0) {
                    for (int k = 0; k < curMap[j] - compare[j]; k++) {
                        sb.append((char)(j + 'a'));
                    }
                }
            }

            int tmp = dfs(sb.toString(), map, dpMap);
            if (tmp != -1) {
                res = Math.min(res, tmp + 1);
            }
        }
        if (res == Integer.MAX_VALUE) {
            dpMap.put(target, -1);
            return -1;
        } else {
            dpMap.put(target, res);
            return res;
        }
    }
}