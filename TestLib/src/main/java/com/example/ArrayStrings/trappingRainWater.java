package com.example.ArrayStrings;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class trappingRainWater {
    public static void main(String[] args) {
//        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height = {0,1,0,0,3};
        System.out.println("Trapped rain water: "+trap(height));
    }

    //0,1,0,0,3 initial elements
    //stack elements index
    //results
    public static int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0, current =0;
        while(current < height.length) {
          while(!stack.empty() && height[current] > height[stack.peek()]) {
           int topIndex = stack.pop();
           if (stack.isEmpty()) break;
           int distance = current - stack.peek() - 1;
           int value = Math.min(height[current], height[stack.peek()]) - height[topIndex];
           answer += distance * value;
          }
          stack.push(current++);
        }
        return answer;
    }

    //brute force approach
    public static int trapBF(int[] height) {
      Integer[] leftMaximum = new Integer[height.length];
      Integer[] rightMaximum = new Integer[height.length];
      int length = height.length;
      int ans = 0;

      //fill left max
      leftMaximum[0] = height[0];
      for(int i = 1; i < length; i++) {
        leftMaximum[i] = Math.max(leftMaximum[i-1], height[i]);
      }

      //fill right max
       rightMaximum[length-1] = height[length-1];
      for (int i = length - 2; i >= 0; i--) {
          rightMaximum[i] = Math.max(rightMaximum[i+1], height[i]);
      }

      for (int i = 1; i < length - 1; i++) {
          ans = ans + (Math.min(leftMaximum[i], rightMaximum[i]) - height[i]);
      }
      return ans;
    }
}