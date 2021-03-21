package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeftmostColumnwithLeastaOne_1428 {

//    https://leetcode.com/problems/leftmost-column-with-at-least-a-one/
    public static void main(String[] args) {
        BinaryMatrix bm = new BinaryMatrix() {
            int[][] matrix = {{0,0,0,0}, {0,0,0,1}, {0,0,0,1}, {0,1,1,1}};
            @Override
            public int get(int row, int col) {
                return matrix[row][col];
            }

            @Override
            public List<Integer> dimensions() {
                return new ArrayList<>(Arrays.asList(4,4));
            }
        };
        System.out.println(leftMostColumnWithOne(bm));
    }

    //time complexity 0(m+n)
    //space complexity 0(1)
    public static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
       List<Integer> dimens = binaryMatrix.dimensions();
       int rows = dimens.get(0), column = dimens.get(1);
       int r = 0, c = column-1, answer = -1;
       while (r < rows && c >=0) {
         if (binaryMatrix.get(r, c)==1) {
             c--;
             answer=c;
         } else {
             r++;
         }
       }
       return answer;
    }

    interface BinaryMatrix {
      public int get(int row, int col);
      public List<Integer> dimensions();
  };
}