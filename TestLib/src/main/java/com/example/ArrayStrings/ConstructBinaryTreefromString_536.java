package com.example.ArrayStrings;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class ConstructBinaryTreefromString_536 {

//    Input: s = "4(2(3)(1))(6(5)(7))"
//    Output: [4,2,6,3,1,5,7]
//    https://leetcode.com/problems/construct-binary-tree-from-string/

    public static void main(String[] args) {
        String s = "4(2(3)(1))(6(5)(7))";
        System.out.println(str2tree(s));
    }

    //use a stack to store all the TreeNode
    // pop from the stack onnce you encounter a ( bracket
    public static TreeNode str2tree(String s) {
        Stack<TreeNode> stack = new Stack<>();
        for(int i = 0, j = i; i < s.length(); i++, j = i){
            char c = s.charAt(i);
            if(c == ')')  {
                stack.pop();
            }
            else if(c >= '0' && c <= '9' || c == '-') {
                while(i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    i++;
                }
                TreeNode currentNode = new TreeNode(Integer.valueOf(s.substring(j, i + 1)));
                if(!stack.isEmpty()){
                    TreeNode parent = stack.peek();
                    if(parent.left != null) {
                        parent.right = currentNode;
                    } else {
                        parent.left = currentNode;
                    }
                }
                stack.push(currentNode);
            }
        }
        return stack.isEmpty() ? null : stack.peek();
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}