package com.example.ArrayStrings;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class countSubArray_FB {

//    An array where each index i contains an integer denoting the maximum number of contiguous subarrays of arr[i]
//    Example:
//    arr = [3, 4, 1, 6, 2]
//    output = [1, 3, 1, 5, 1]
//    Explanation:
//    For index 0 - [3] is the only contiguous subarray that starts (or ends) with 3, and the maximum value in this subarray is 3.
//    For index 1 - [4], [3, 4], [4, 1]
//    For index 2 - [1]
//    For index 3 - [6], [6, 2], [1, 6], [4, 1, 6], [3, 4, 1, 6]
//    For index 4 - [2]
//    So, the answer for the above input is [1, 3, 1, 5, 1]
//    https://leetcode.com/discuss/interview-question/742523/facebook-prep-question-contiguous-subarrays-on-solution
    public static void main(String[] args) {
        int[] input = {3, 4, 6, 2};
        int[] res = countSubarrays(input);
        for (int re: res) {
            System.out.println(re);
        }
    }

    static int[] countSubarrays(int[] arr) {
        // Write your code here
        Stack<Integer> s = new Stack<>();
        int[] L = new int[arr.length];
        L[0] = 1;
        s.push(0);

        //check for elements to the left of current index
        for(int i = 1; i < arr.length; i++) {   //3, 4,  2,  6, 2           //1, 3, 1, 5, 1
            while(!s.isEmpty() && arr[s.peek()] < arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                L[i] = i + 1;    //this element is greater than all elements to it left!
            }
            else {
                L[i] = i - s.peek();  //calculate the no of elements greater
            }
            s.push(i);
        }

        int[] R = new int[arr.length];
        R[arr.length - 1] = L[arr.length - 1];
        s.clear();
        s.push(arr.length - 1);

        //check for elements to the right of current index
        for(int i = arr.length - 2; i >= 0; i--) {
            while(!s.isEmpty() && arr[s.peek()] < arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                R[i] = (arr.length - i) + L[i] - 1;
            }
            else {
                R[i] = (s.peek() - i) + L[i] - 1;
            }
            s.push(i);
        }
        return R;
    }
}