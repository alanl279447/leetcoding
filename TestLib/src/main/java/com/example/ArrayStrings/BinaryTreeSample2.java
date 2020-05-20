package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeSample2 {
    private BinaryTreeSample2.TreeNode root;


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        preOrder.add(preOrderTraversalInner(root));
        return preOrder;
    }

    Integer preOrderTraversalInner(TreeNode node) {
       return node.val;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
}
