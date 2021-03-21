package com.example.SortingAndSearching;

//        Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//        Output: 6
//        Explanation:
//        A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
//        Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
//        because the wheels of the lock become stuck after the display becomes the dead end "0102".
//        https://leetcode.com/problems/open-the-lock/
//        time complexity is O(N^2*digits^N + D)   N = 4, digits = 10, D = deadEnd digits
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpentheLock_752 {
    public static void main(String[] args) {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        System.out.print(openLock(deadends, "0202"));
    }

    //0000
    public static int openLockTest(String[] deadends, String target) {
       Deque<String> queue = new LinkedList();
       Set<String> visited = new HashSet();
       Set<String> deadEndsSet = new HashSet<>(Arrays.asList(deadends));

       queue.offer("0000");
       visited.add("0000");
       int level = 0;
       while (!queue.isEmpty()) {
           int size  = queue.size();
           while (size >0) {
               String entry = queue.poll();
               if (entry.equals(target)) return level;
               if (visited.contains(entry)) continue;
               for (int i=0;i<4;i++) {
                   char c = entry.charAt(i);
                   String s1 = entry.substring(0,i)+ (c=='0'?9:c-'0'+1)+entry.substring(i+1);
                   String s2 = entry.substring(0,i)+ (c=='9'?0:c-'0'-1)+entry.substring(i+1);
                   if (!visited.contains(s1) && !deadEndsSet.contains(s1)) {
                       queue.offer(s1);
                   }
                   if (!visited.contains(s2) && !deadEndsSet.contains(s2)) {
                       queue.offer(s2);
                   }
               }
               size--;
           }
           level++;
       }
       return -1;
    }

    public static int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        q.offer("0000");
        visited.add("0000");
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                String s = q.poll();
                if(deads.contains(s)) {
                    size --;
                    continue;
                }
                if(s.equals(target)) return level;
                StringBuilder sb = new StringBuilder(s);
                for(int i = 0; i < 4; i ++) {
                    char c = sb.charAt(i);
                    String s1 = sb.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(i + 1);
                    String s2 = sb.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(i + 1);
                    if(!visited.contains(s1) && !deads.contains(s1)) {
                        q.offer(s1);
                        visited.add(s1);
                    }
                    if(!visited.contains(s2) && !deads.contains(s2)) {
                        q.offer(s2);
                        visited.add(s2);
                    }
                }
                size --;
            }
            level ++;
        }
        return -1;
    }
}