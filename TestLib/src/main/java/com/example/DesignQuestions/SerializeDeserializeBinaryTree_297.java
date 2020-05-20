package com.example.DesignQuestions;


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class SerializeDeserializeBinaryTree_297 {

//    You may serialize the following tree:
//
//              1
//             / \
//            2   3
//               / \
//              4   5
//
//    as "[1,2,3,null,null,4,5]"
//    https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

    public static TreeNode root = null;
    public static void main(String[] args) {
        addNode(1);
        Codec codec = new Codec();
        String serialize = codec.serialize(root);
        System.out.println(serialize);
        TreeNode root = codec.deserialize(serialize);
        System.out.println(root.val);
    }

    public static class Codec {
        private static final String spliter = ",";
        private static final String NN = "X";

        public static String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serializeInner(root, sb);
            return sb.toString();
        }

        public static void serializeInner(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append(NN).append(spliter);
                return;
            }
            sb.append(root.val).append(spliter);
            serializeInner(root.left, sb);
            serializeInner(root.right, sb);
        }

        private TreeNode deserialize(String serialize) {
            TreeNode root = null;
            String[] nodeVals = serialize.split(spliter);

            List<String> queue = new LinkedList<>(Arrays.asList(nodeVals));
            root = deserializeTree(queue);
            return root;
        }

        private TreeNode deserializeTree(List<String> lists) {
            String nodeVal =lists.remove(0);
            if (nodeVal.equalsIgnoreCase(NN)) {
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(nodeVal));
            node.left = deserializeTree(lists);
            node.right = deserializeTree(lists);
            return node;
        }


//        public static String serialize(TreeNode root) {
//            StringBuilder sb = new StringBuilder();
//            buildString(root, sb);
//            return sb.toString();
//        }
//
//        private static void buildString(TreeNode node, StringBuilder sb) {
//            if (node == null) {
//                sb.append(NN).append(spliter);
//            } else {
//                sb.append(node.val).append(spliter);
//                buildString(node.left, sb);
//                buildString(node.right,sb);
//            }
//        }

//        public static TreeNode deserialize(String data) {
//            String[] nodes = data.split(spliter);
//            List<String> nodesList = new LinkedList<>(Arrays.asList(nodes));
//            TreeNode node = buildDeserailTree(nodesList);
//            return node;
//        }
//
//        private static TreeNode buildDeserailTree(List<String> nodeStrings) {
//            String currentNodeString = nodeStrings.remove(0);
//            if (currentNodeString.equalsIgnoreCase(NN)) {
//                return null;
//            }
//            TreeNode node = new TreeNode(Integer.parseInt(currentNodeString));
//            node.left = buildDeserailTree(nodeStrings);
//            node.right = buildDeserailTree(nodeStrings);
//            return node;
//        }


    }

    public static void addNode(int value) {
        root = new TreeNode(value);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }



}