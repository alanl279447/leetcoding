package com.example.TreesAndGraph;

public class DistanceBetweenNodesinBST_Amazon {

//    Input: nums = [2, 1, 3], node1 = 1, node2 = 3
//    Output: 2
//    Explanation:
//            2
//            /   \
//            1     3
//    https://leetcode.com/discuss/interview-question/376375/

    public static TreeNode root;
    private static TreeNode ans = null;

    public static void main(String[] args) {
        int[] nums = {2,1,3};
        findDistance(nums, 1, 3);
        System.out.print(ans.val);
    }

    //build the BST
    // Lowest common ancestor
    // sum of distance between node and ancestors
    public static int findDistance(int[] nodes, int i, int j) {
        for (int node: nodes) {
            buildBST(root, node);
        }
       TreeNode lca = lowestCommonAncestor(root, i, j);
       int distance = distanceFromLca(lca, i) + distanceFromLca(lca, j);
       return distance;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, int i , int j) {
        if (i < root.val && j < root.val) {
            return lowestCommonAncestor(root.left, i, j);
        } else if (i > root.val && j > root.val) {
            return lowestCommonAncestor(root.right, i, j);
        } else
            return root;
    }

    public static int distanceFromLca(TreeNode lca, int nodeValue) {
           int distance = 0;
           while(lca != null) {
               if (lca.val > nodeValue) {
                   lca = lca.left;
               } else if (lca.val < nodeValue){
                   lca = lca.right;
               } else {
                   break;
               }
               distance++;
           }
           return distance;
    }

    public static TreeNode buildBST(TreeNode root, int node) {
       if (root == null) {
           return new TreeNode(node);
       } else if (root.val > node) {
           if(root.left == null) {
               root.left = new TreeNode(node);
           } else {
               buildBST(root.left, node);
           }
       } else if (root.val < node) {
           if (root.right == null) {
               root.right = new TreeNode(node);
           } else {
               buildBST(root.right, node);
           }
       }
       return root;
    }

    public static void addNode(int value) {
        root = new TreeNode(value);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
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
