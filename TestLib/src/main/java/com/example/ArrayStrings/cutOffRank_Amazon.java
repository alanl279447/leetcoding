package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

public class cutOffRank_Amazon {
//    https://leetcode.com/discuss/interview-question/890290/

    public static void main(String[] args) {

        int[] input1 = {100,50,50,25};
        System.out.println(cutOffRank(3, 4, input1)); //3   1,2,2,4

        int[] input2 = {2,2,3,4,5};
        System.out.println(cutOffRank(4, 5, input2));//5     4,4,3,2,1
    }

    //time complexity 0(nlogn)
    public static int cutOffRank(int cutOffRank, int num, int[] scores) {
        int position = 1;
        Arrays.sort(scores);
        for (int i = num - 1; i >= 0; i--) {
            if (i == num - 1 || scores[i] != scores[i + 1]) {
                if (position > cutOffRank) return position - 1;
            }
            position++;
        }
        return position-1;
    }

//    public static int cutOffRankTest(int cutOffRank, int num, int[] scores) {
//        int rank = 1;
//        int position= 1;
//        Arrays.sort(scores);
//        for (int i = num-1; i >=0; i--) {
//           if (i == num-1 || scores[i] != scores[i+1]) {
//               rank=position;
//               if (rank > cutOffRank) return position-1;
//           }
//           position++;
//        }
//       return position-1;
//    }
}