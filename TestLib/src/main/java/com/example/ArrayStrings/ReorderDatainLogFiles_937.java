package com.example.ArrayStrings;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderDatainLogFiles_937 {

//    Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
//    Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
//    https://leetcode.com/problems/reorder-data-in-log-files/

    //    public static int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}, {-1,1}, {1,-1}, {1,1}, {-1,-1}};
    public static void main(String[] args) {
        String[] input = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        String[] output = reorderLogFilesPrac(input);
        for (String out: output) {
            System.out.println(out);
        }
    }


    public static String[] reorderLogFilesPrac(String[] logs) {
       Arrays.sort(logs, (a,b) -> {
           String[] split1 = a.split("\\s");
           String[] split2 = b.split("\\s");

           boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
           boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

           if (!isDigit1 && !isDigit2) {
               //both are words
               int compare = split1[1].compareTo(split2[1]);
               if (compare==0) {
                   return split1[0].compareTo(split2[0]); //compare identifier in case of tie
               }
               return compare;
           } else if (isDigit1 && !isDigit2) {
               return 1;
           } else if (!isDigit1 && isDigit2) {
               return -1;
           } else {
               return 0;
           }
       });
       return logs;
    }


//   if return ==0 // nothing will happen original order will be maintained.
//   if return ==1// values will be swapped.
//   if return ==-1 //need to keep in same order

    public static String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (s1, s2) -> {
            String[] split1 = s1.split(" ", 2);
            String[] split2 = s2.split(" ", 2);

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            if(!isDigit1 && !isDigit2) {
                // both letter-logs.
                int comp = split1[1].compareTo(split2[1]);
                if (comp == 0) return split1[0].compareTo(split2[0]);
                else return comp;
            } else if (isDigit1 && isDigit2) {
                // both digit-logs. So keep them in original order
                return 0;
            } else if (isDigit1 && !isDigit2) {
                // first is digit, second is letter. bring letter to forward.
                return 1;
            } else {
                //first is letter, second is digit. keep them in this order.
                return -1;
            }
        });
        return logs;
    }
}
