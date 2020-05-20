package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.List;

public class SubtreeofAnotherTree_572 {

//               3
//              / \
//             4   5
//          /   \
//          1   2
//
//               4
//              / \
//             1   2
//    Return true, because t has the same structure and node values with a subtree of s.

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        TreeNode s = addNodeNews(3);
        TreeNode t = addNodeNewt(4);

        System.out.print(isSubtree(s,t));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //Time complexity 0(m*n)
    public static boolean isSubtreePrac(TreeNode s, TreeNode t) {
        return traverse(s,t);
    }

    public static boolean isEqual(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if(s==null || t==null) {
            return false;
        }
        return s.val==t.val && isEqual(s.left, t.left) && isEqual(s.right, t.right);
    }

    public static boolean traverse(TreeNode s, TreeNode t) {
        return s != null && ((isEqual(s,t) || traverse(s.left, t)) || traverse(s.right, t));
    }

    //using String
    // time complexity 0(m2+n2+mn)
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        int tValue = t != null ? t.val: -1;
        String sString = preorderString(s);
        String tString = preorderString(t);

        if (sString.contains(tString)) return true;
        else return false;
    }

    public static String preorderString(TreeNode node) {
      String output = "";
        if (node == null) {
          return output += "#null";
      }
      output+="#"+node.val;
        output += preorderString(node.left);
        output += preorderString(node.right);

      return output;
    }

    public static TreeNode addNodeNews(int value) {
        TreeNode node = new TreeNode(value);
        node.left = new TreeNode(4);
        node.right = new TreeNode(5);
        node.left.right = new TreeNode(2);
        node.left.left = new TreeNode(1);
//        root.right.right = new TreeNode(7);
        return node;
    }

    public static TreeNode addNodeNewt(int value) {
        TreeNode node = new TreeNode(value);
        node.left = new TreeNode(1);
        node.right = new TreeNode(2);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);
        return node;
    }

    public static TreeNode addNodeRecursive(TreeNode node, int value) {
//        TreeNode newNode = null;
        if (node == null) {
            node = new TreeNode(value);
            return node;
        }

        if (value < node.val) {
            node.left = addNodeRecursive(node.left, value);
        } else if (value > node.val){
            node.right = addNodeRecursive(node.right, value);
        } else {
            return node;
        }
        return node;
    }
}
