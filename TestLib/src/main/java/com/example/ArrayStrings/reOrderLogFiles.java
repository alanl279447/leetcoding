package com.example.ArrayStrings;
import java.util.Arrays;
import java.util.Comparator;

public class reOrderLogFiles {

    public static void main(String[] args) {
        //String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] logs =  {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        String[] output = reorderLogFiles(logs);
        for (String item:output) {
            System.out.println(""+item);
        }
    }

    //positive return value swap
    //negative return value as is!!
    public static String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (s1, s2) -> {
            String[] split1 = s1.split(" ", 2);
            String[] split2 = s2.split(" ", 2);

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            if (!isDigit1 && !isDigit2) {
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


    public static void testComparator() {
        Integer[] nums = {5,1,4,2,1};
        Arrays.sort(nums, (a,b) -> {
            if (a > b) {
                return -1;
            }
//            else if (a ==b) {
//                return 0;
//            }
            else {
                return 1;
            }
        });
        System.out.println(nums.toString());
    }


}
