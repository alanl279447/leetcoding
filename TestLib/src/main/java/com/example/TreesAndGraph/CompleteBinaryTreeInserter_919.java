package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Input: inputs = ["CBTInserter","insert","insert","get_root"], inputs = [[[1,2,3,4,5,6]],[7],[8],[]]
//Output: [null,3,4,[1,2,3,4,5,6,7,8]]
//https://leetcode.com/problems/complete-binary-tree-inserter/
public class CompleteBinaryTreeInserter_919 {
    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        addNode();
        CBTInserter obj = new CBTInserter(root);
        int param_1 = obj.insert(8);
        TreeNode param_2 = obj.get_root();
    }

    static class CBTInserter {
        private TreeNode root;
        private Queue<TreeNode> queue;
        //O(N) build tree: Find the first node which doesn't have both left and right child.
        public CBTInserter(TreeNode root) {
            this.root = root;
            queue = new LinkedList<>();
            queue.offer(root);
            while (true) {
                TreeNode cur = queue.peek();
                if (cur.left != null && cur.right != null) {
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                    queue.poll();
                } else {
                    break;
                }
            }
        }

        public int insert(int v) {
            TreeNode cur = queue.peek();
            if (cur.left == null) {
                cur.left = new TreeNode(v);
            } else {
                cur.right = new TreeNode(v);
                queue.offer(cur.left);
                queue.offer(cur.right);
                queue.poll();
            }
            return cur.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void addNode() {
        root = addNodeRecursive(root, 1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
    }

    public static TreeNode addNodeRecursive(TreeNode node, int value) {
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
