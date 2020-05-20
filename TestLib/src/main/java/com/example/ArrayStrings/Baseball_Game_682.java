package com.example.ArrayStrings;

import java.util.Stack;

public class Baseball_Game_682 {

    public static void main(String[] args) {
        String[] input = {"5","2","C","D","+"};
        int result = calPoints(input);
        System.out.print(result);
    }

    public static int calPoints(String[] ops) {
       int score = 0;
       Stack<Integer> stack = new Stack<>();

       for (String op: ops) {
           if (op.equals("+")) {
               int top = stack.pop();
               int newTop = stack.peek() + top;
               stack.push(top);
               stack.push(newTop);
           } else if (op.equals("C")) {
               stack.pop();
           } else if (op.equals("D")) {
               stack.push(2 * stack.peek());
           } else {
               stack.push(Integer.parseInt(op));
           }
       }

       while(!stack.isEmpty()) {
           score+=stack.pop();
       }
       return score;
    }
}
