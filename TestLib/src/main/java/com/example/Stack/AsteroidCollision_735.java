package com.example.Stack;

import java.util.Stack;

public class AsteroidCollision_735 {

//    Input:
//    asteroids = [5, 10, -5]
//    Output: [5, 10]
//    Explanation:
//    The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
//    https://leetcode.com/problems/asteroid-collision/
//    (positive meaning right, negative meaning left).

    public static void main(String[] args) {
        //int[] T = {5,10,-5};
        int[] T = {-2, -1, 1, 2};
        int[] result = asteroidCollision(T);
        for (int res: result)
         System.out.print(res);
    }

    //if i>0 s.offer(i)
    // else !stack.isemtpy && pop in loop
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        for(int i: asteroids){
            if(i > 0){
                s.push(i);
            }else{// i is negative
                while(!s.isEmpty() && s.peek() > 0 && s.peek() < Math.abs(i)){
                    s.pop();
                }
                if(s.isEmpty() || s.peek() < 0){
                    s.push(i);
                }else if(i + s.peek() == 0){
                    s.pop(); //equal
                }
            }
        }
        int[] res = new int[s.size()];
        for(int i = res.length - 1; i >= 0; i--){
            res[i] = s.pop();
        }
        return res;
    }


}
