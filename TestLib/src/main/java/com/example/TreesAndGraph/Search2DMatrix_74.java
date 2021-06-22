package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.List;

public class    Search2DMatrix_74 {
//    Input:
//    matrix = [
//            [1,   3,  5,  7],
//            [10, 11, 16, 20],
//            [23, 30, 34, 50]
//            ]
//    target = 3
//    Output: true
//    https://leetcode.com/problems/search-a-2d-matrix/


    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7}, {10,11,16,20}, {23,30,34,50}};
        System.out.println(searchMatrix(matrix, 23));
//        System.out.println(searchMatrix(matrix, 20));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
         int column = matrix[0].length;

         int left = 0, right = matrix.length  * matrix[0].length -1;
         while(left <= right) {
             int midIndex = left + (right-left)/2;
             int midValue = matrix[midIndex/column][midIndex%column];
             if (midValue == target) {
                 return true;
             } else if (midValue > target) {
                 right = midIndex - 1;
             } else {
                 left = midIndex+1;
             }
         }
         return false;
    }


//    private static int[][] matrix;
//    private static int target;

//    private static boolean searchRec(int left, int up, int right, int down) {
//        // this submatrix has no height or no width.
//        if (left > right || up > down) {
//            return false;
//            // `target` is already larger than the largest element or smaller
//            // than the smallest element in this submatrix.
//        } else if (target < matrix[up][left] || target > matrix[down][right]) {
//            return false;
//        }
//
//        int mid = left + (right-left)/2;
//
//        // Locate `row` such that matrix[row-1][mid] < target < matrix[row][mid]
//        int row = up;
//        while (row <= down && matrix[row][mid] <= target) {
//            if (matrix[row][mid] == target) {
//                return true;
//            }
//            row++;
//        }
//
//        return searchRec(left, row, mid-1, down) || searchRec(mid+1, up, right, row-1);
//    }
//LocateStoreFragment
//    public static boolean searchMatrix(int[][] mat, int targ) {
//        // cache input values in object to avoid passing them unnecessarily
//        // to `searchRec`
//        matrix = mat;
//        target = targ;
//
//        // an empty matrix obviously does not contain `target`
//        if (matrix == null || matrix.length == 0) {
//            return false;
//        }
//
//        return searchRec(0, 0, matrix[0].length-1, matrix.length-1);
//    }



    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void addNode(int value) {
        root = addNodeRecursive(root, value);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
    }

    public static TreeNode addNodeRecursive(TreeNode node, int value) {
//        TreeNode newNode = null;
        if (node == null) {
            node = new TreeNode(value);
            return node;
        }

        if (value < node.val) {
            node.left = addNodeRecursive(node.left, value);
        } else if (value > node.val){
            node.right = addNodeRecursive(node.right, value);
        } else {
            return node;
        }
        return node;
    }
}
