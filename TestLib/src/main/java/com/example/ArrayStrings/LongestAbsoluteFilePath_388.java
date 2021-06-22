package com.example.ArrayStrings;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LongestAbsoluteFilePath_388 {
//    https://leetcode.com/problems/longest-absolute-file-path/
//    Input: input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
//    Output: 32
//    Explanation: We have two files:
//            "dir/subdir1/file1.ext" of length 21
//            "dir/subdir2/subsubdir2/file2.ext" of length 32.
//    We return 32 since it is the longest absolute path to a file.

    public static void main(String[] args) {
//        String s = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        String s = "dir\n\tsubdir12\n\t\tfile12.ext\n\tsubdir2\n\t\tfile2.ext";
        System.out.println(lengthLongestPath(s));
    }

    //maxLen = Global
    // level -> \t + 1  dir =  1, subDirs = 2, subSubDirs - 3
    // stack count based on level
    // 4 - dir/   1
    // 9 - subdir12/  2
    // 10 - file12.ext  3
    public static int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0); // "dummy" length
        int maxLen = 0;
        String[] splits = input.split("\n");
        for(String s: splits){
            int lev = s.lastIndexOf("\t")+1; // number of "\t"    //lev is no of tabs since 0 indexed, add +1
            while(lev+1<stack.size()) {                                //lev here is tabs+1, dir is level 1, subdir1 and subdir2 are level 2, file.ext is level3
                stack.pop(); // find parent
            }
            int len = stack.peek()+s.length()-lev+1; // remove "\t", add"/"
            stack.push(len);
            // check if it is file
            if(s.contains(".")) {
                maxLen = Math.max(maxLen, len-1);
            }
        }
        return maxLen;
    }
}