package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class pancakeSorting_969 {

//    Input: [3,2,4,1]
//    Output: [4,2,4,3]
//    Explanation:
//    We perform 4 pancake flips, with k values 4, 2, 4, and 3.
//    Starting state: A = [3, 2, 4, 1]
//    After 1st flip (k=4): A = [1, 4, 2, 3]
//    After 2nd flip (k=2): A = [4, 1, 2, 3]
//    After 3rd flip (k=4): A = [3, 2, 1, 4]
//    After 4th flip (k=3): A = [1, 2, 3, 4], which is sorted.
//    https://leetcode.com/problems/pancake-sorting/
//    time complexity 0(N^2)
    public static void main(String args[]) {
        int[] input = {3,1,4,2};
        List<Integer> res = pancakeSort(input);
        for(Integer re: res)
          System.out.println(re);
//        List<Integer> input = Arrays.asList(5,1,4,2);
//        countSmaller(input);
    }

//    At each round, we identify the value to sort (named as value_to_sort), which is the number we would put in place at this round.
//    We then locate the index of the value_to_sort.
//    If the value_to_sort is not at its place already, we can then perform at most two pancake flips as we explained in the intuition.
//    At the end of the round, the value_to_sort would be put in place.
    public static List<Integer> pancakeSort(int[] A) {
        List<Integer> result = new ArrayList<>();
        int n = A.length, largest = n;
        for (int i = 0; i < n; i++) {
            // locate the position for the value to sort in this round
            int index = find(A, largest);

            // sink the value_to_sort to the bottom,
            // with at most two steps of pancake flipping.
            if(index==largest-1) {
                continue;
            }
            flip(A, index);
            flip(A, largest - 1);   //5,1,4,2
            result.add(index + 1);
            result.add(largest--);
        }
        return result;
    }
    private static int find(int[] A, int target) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                return i;
            }
        }
        return -1;
    }
    private static void flip(int[] A, int index) {
        int i = 0, j = index;
        while (i < j) {
            int temp = A[i];
            A[i++] = A[j];
            A[j--] = temp;
        }
    }

    public static List<Integer> countSmaller(List<Integer> nums) {
        int[] res = new int[nums.size()];
        List<Integer> resList = new ArrayList<>();
        for (int i = nums.size() - 1; i >= 0; i--) {
            res[i] = biInsert(resList, nums.get(i));
            //System.out.println(res[i]);
        }
        resList.clear();

        for (int i = 0; i < nums.size(); i++) {
            resList.add(res[i]);
        }
        return resList;
    }
        //5,1,4,2
    public static int biInsert(List<Integer> list, int target) {
        int l = 0;
        int r = list.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int m = list.get(mid);
            if (m < target) {
                l = mid + 1;
            }
            else if (m >= target) {
                r = mid - 1;
            }
        }
        list.add(l, target);
        return l;
    }
}
