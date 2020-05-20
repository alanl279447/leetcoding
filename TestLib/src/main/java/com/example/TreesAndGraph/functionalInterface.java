package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.List;

public class functionalInterface {
//    Input: [-10,9,20,null,null,15,7]
//
//            -10
//            / \
//           9  20
//             /  \
//            15   7
//
//    Output: 42

    interface funcInterface {
        //void abstractfun(int number);
        void abstractfun(int number1, int number2);
    }


    public class funClass {
        funcInterface fObj = (int x, int y) -> {
           System.out.println(x);
        };
    }
}
