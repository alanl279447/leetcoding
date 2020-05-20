package com.example.ArrayStrings;
import java.util.Arrays;
import java.util.Comparator;

public class reOrderLogFiles {

    public static void main(String[] args) {
        //String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] logs =  {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        String[] output = reorderLogFilesWorking(logs);


//        String[] logs = {"dig1","let3","dig2","let1","let2"};
//        String[] output = reorderLogFiles1(logs);

        for (String item:output) {
            System.out.println(""+item);
        }
    }

    //positive return value no swap
    //negative return value swap
    public static String[] reorderLogFiles1(String[] logs) {
        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                int l1 = str1.length();
                int l2 = str2.length();
                int lmin = Math.min(l1, l2);

                for (int i = 0; i < lmin; i++) {
                    int str1_ch = (int)str1.charAt(i);
                    int str2_ch = (int)str2.charAt(i);

                    if (str1_ch != str2_ch) {
                        int diff = str1_ch - str2_ch;
                        return diff;
                    }
                }
                return 0;
            }
        };

        Arrays.sort(logs, myComp);
        return logs;
    }


//    String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig"};
    public static String[] reorderLogFiles(String[] logs) {
         Comparator<String> myComparator = new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {

                int str1Start = str1.indexOf(' ');
                int str2Start = str2.indexOf(' ');

                Character str1Char = str1.charAt(str1Start+1);
                Character str2Char = str2.charAt(str2Start+1);

                if (str1Char <= '9') {
                    if (str2Char <= '9') {
                        return 0;
                    } else {
                        //return 0;
                    }
                }

                if (str2Char < '9') {
                    return -1;
                }

                String preStr1 = str1.substring(str1Start+1);
                String preStr2 = str2.substring(str2Start+1);

                int compute = preStr1.compareTo(preStr2);
                if (compute == 0) {
                  compute = str1.substring(0, str1Start).compareTo(str2.substring(0, str2Start));
                }

                return compute;
            }
        };
        Arrays.sort(logs, myComparator);
        return logs;
    }

    //positive no swap
    //negative swap
    public static String[] reorderLogFilesWorking(String[] logs) {
        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int s1si = s1.indexOf(' ');
                int s2si = s2.indexOf(' ');
                char s1fc = s1.charAt(s1si+1);
                char s2fc = s2.charAt(s2si+1);

                if (s1fc <= '9') {
                    if (s2fc <= '9') return 0;
                    else return 1;
                }
                if (s2fc <= '9') return -1;

                int preCompute = s1.substring(s1si+1).compareTo(s2.substring(s2si+1));
                if (preCompute == 0) return s1.substring(0,s1si).compareTo(s2.substring(0,s2si));
                return preCompute;
            }
        };

        Arrays.sort(logs, myComp);
        return logs;
    }

}
