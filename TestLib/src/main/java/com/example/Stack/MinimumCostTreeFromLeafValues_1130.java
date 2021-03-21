package com.example.Stack;

import java.util.Stack;

public class MinimumCostTreeFromLeafValues_1130 {
//    Input: arr = [6,2,4]
//    Output: 32
//    Explanation:
//    There are two possible trees.  The first has non-leaf node sum 36, and the second has non-leaf node sum 32.
//            24               24
//            /  \            /  \
//           12   4          6    8
//         /  \                /   \
//       6    2                2   4
//    https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
//    https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/discuss/339959/One-Pass-O(N)-Time-and-Space
//    Time complexity 0(n)
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1, 5};
//        int[] arr = {6,2,4};
//        int[] arr = {2,6,4};
        int result = mctFromLeafValues(arr);
        System.out.print(result);
    }

    // 4,3,2,1,5
    // when you find a increase (2,1,5), move backwards to form tree
    //
    public static int mctFromLeafValues(int[] arr) {
        if(arr == null || arr.length < 2){
            return 0;
        }

        int res = 0;
            Stack<Integer> stack = new Stack<>();
        for(int num : arr){

            // while num is bigger than peek(), pop and calculate
            while(!stack.isEmpty() && stack.peek() <= num){
                int mid = stack.pop();
                if(stack.isEmpty())
                    res += mid * num;
                else
                    res += mid * Math.min(stack.peek(), num);
            }

            stack.push(num); // if num is smaller, push into stack
        }

        // if there are values left in the stack, they sure will be mutiplied anyway
        // and added to the result.
        while(stack.size() > 1){ // > 1 because we have a peek() after pop() below
            res += stack.pop() * stack.peek();
        }
        return res;
    }
}