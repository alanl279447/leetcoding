package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//Input: s = "abcabc", k = 3
//Output: ["abc", "bca", "cab"]
//https://leetcode.com/discuss/interview-question/370112/
public class uniqueSubstringSizeK_Amazon {

    public static void main(String[] args) {
        Set<String> result = uniqueSubstringSizeK("abacab", 3);
        System.out.println(result.size());
        Iterator<String> it = result.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
//        System.out.println(uniqueSubstringSizeK("awaglknagawunagwkwagl", 4));
    }

    public static Set<String> uniqueSubstringSizeK(String s, int k) {
        Set<String> set = new HashSet<>();
        int[] ch = new int[26];
        int lo=0;
        int hi=0;
        while(lo<=hi && hi<s.length()) {
            ch[s.charAt(hi)-'a']++;
            while(ch[s.charAt(hi)-'a'] != 1) {
                ch[s.charAt(lo)-'a']--;
                lo++;
            }
            if(hi-lo+1 == k) {
                set.add(s.substring(lo, hi+1));
                ch[s.charAt(lo)-'a']--;
                lo++;
            }
            hi++;
        }
        return set;
    }

}