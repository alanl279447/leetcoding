package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.List;

public class Search2DMatrixII_240 {
//       [
//        [1,   4,  7, 11, 15],
//        [2,   5,  8, 12, 19],
//        [3,   6,  9, 16, 22],
//        [10, 13, 14, 17, 24],
//        [18, 21, 23, 26, 30]
//        ]
//    https://leetcode.com/problems/search-a-2d-matrix-ii/
//
//    Given target = 5, return true.
//    Given target = 20, return false.

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
//        addNode(-10);
        int[][] matrix = {{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
//        int[][] matrix = {{-5}};
        System.out.println(searchMatrix(matrix, 12));
//        System.out.println(searchMatrix(matrix, 20));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length ==0) return false;
        int curRow = 0;
        int curColumn = matrix[0].length-1;
        while(curRow>0 && curColumn>0 && curRow<matrix.length && curColumn<matrix[0].length) {
            if (matrix[curRow][curColumn] == target) return true;
            else if (matrix[curRow][curColumn] < target){
                curRow++;
            } else {
                curColumn--;
            }
        }
        return false;
    }

//    private static int[][] localMatrix;
//    private static int localTarget;

//    public static boolean searchRecInMatrix( int left, int up, int right, int bottom) {
//        if (left < 0 || left > right || up < 0 || up > bottom) {
//            return false;
//        }
//
//        int mid = left + (right - left)/2;
//        int row = up;
//
//        //find row such that matrix[row-1][left] < target < matrix [row+1][left]
//        while(row <= bottom && localMatrix[row][mid] < localTarget) {
//            if (localMatrix[row][mid] == localTarget) {
//                return true;
//            }
//            row++;
//        }
//        return searchRecInMatrix(left, row, mid-1, bottom) || searchRecInMatrix(mid+1, up, right, row-1);
//    }
//
//
//    public static boolean searchMatrix(int[][] matrix, int target) {
//        if (matrix.length == 0) return false;
//        int rowLength = matrix.length;
//        int columnLength = matrix[0].length;
//        localMatrix = matrix;
//        localTarget = target;
//
//        return searchRecInMatrix(0, 0, matrix[0].length, matrix.length);
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
