package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class allCombinationsRec_FB {
//    Input :  n = 3
//    Output : 3 1 2 1 3 2
//            2 3 1 2 1 3
//    All elements from 1 to 3 appear
//    twice and distance between two
//    appearances is equal to value
//    of the element.
//
//            Input :  n = 4
//    Output : 4 1 3 1 2 4 3 2
//            2 3 4 2 1 3 1 4
//    https://www.geeksforgeeks.org/combinations-every-element-appears-twice-distance-appearances-equal-value/
//    Time complexity 0(n^2).

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();

    // Driver method
    public static void main(String[] args) {
        // given number
        int n = 3;
        allCombinations(n);
    }

    static void allCombinations(int n) {
        // create a vector of double the size of given number with
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 2*n; i++) {
            arr.add(-1);
        }

        // all its elements initialized by 1
        int elem = 1;

        // start from element 1
        allCombinationsRec(arr, elem, n);
    }

    // Find all combinations that satisfies given constraints
    static void allCombinationsRec(List<Integer> arr, int elem, int n)
    {
        // if all elements are filled, print the solution
        if (elem > n) {
            for (int i : arr)
                System.out.print(i + " ");
            System.out.println();
            return;
        }
        // try all possible combinations for element elem
        for (int i = 0; i < 2*n; i++)
        {
            // if position i and (i+elem+1) are not occupied
            // in the vector
            if (arr.get(i) == -1 && (i + elem + 1) < 2*n &&
                    arr.get(i + elem + 1) == -1)
            {
                // place elem at position i and (i+elem+1)
                arr.set(i, elem);
                arr.set(i + elem + 1, elem);

                // recurse for next element
                allCombinationsRec(arr, elem + 1, n);

                // backtrack (remove elem from position i and (i+elem+1) )
                arr.set(i, -1);
                arr.set(i + elem + 1, -1);
            }
        }
    }

    // Definition for a Node.
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}

