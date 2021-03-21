package com.example.TreesAndGraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreePostorderTraversal_145 {
//    Input: root = [1,null,2,3]
//    Output: [3,2,1]
//    https://leetcode.com/problems/binary-tree-postorder-traversal/
//    https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
//    https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45551/Preorder-Inorder-and-Postorder-Iteratively-Summarization

    public static TreeNode root;
    public static void main(String[] args) {
        addNode(1);
       List<Integer> result = postorderTraversal(root);
        for (Integer res : result)
            System.out.println(res.toString());
    }

    //left, right, node..with resolving for topological dependency
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if(root==null){
            return result;
        }
        stack.push(root);
        TreeNode cur=root;
        TreeNode pre=null;
        while (!stack.isEmpty()){
            cur=stack.peek();
            if(cur.left==null&&cur.right==null||(pre!=null&&(pre==cur.left||pre==cur.right))){
                result.add(cur.val); //deal with topological dependency
                stack.pop();
                pre=cur;
            }else {
                if (cur.right!=null){
                    stack.push(cur.right);
                }
                if(cur.left!=null){
                    stack.push(cur.left);
                }
            }
        }
        return result;
    }

    //node, left, right
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                result.add(p.val);  // Add before going to children
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                p = node.right;
            }
        }
        return result;
    }


    // Left, root, right
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                result.add(node.val);  // Add after all left children
                p = node.right;
            }
        }
        return result;
    }


    public static void addNode(int value) {
        root = new TreeNode(value);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
    }

    public static class Node {
        TreeNode node;
        int hd;

        public Node(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
