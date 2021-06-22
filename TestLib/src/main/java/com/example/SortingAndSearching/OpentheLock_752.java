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

    //Complexity: O(N^2 * A^N + D)
    //where, N is Number of dials (4 in our case)
    //A is number of alphabets (10 in our case -> 0 to 9)
    //D is the size of deadends.
    //
    //There are 10 x 10 x 10 x 10 possible combinations => 10^4 => A^N
    //For each combination, we are looping 4 times (which is N) and in each iteration, there are substring operations ( which is O(N) * constant) => O(4N*constant) => O(4N) => O(NN) => O(N^2)
    //Total complexity => A^N * N^2, plus D to create the hashset => N^2 * A^N + D
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