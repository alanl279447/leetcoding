package com.example.DesignQuestions;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {

//    You may serialize the following tree:
//
//              1
//             / \
//            2   3
//               / \
//              4   5
//
//    as "[1,2,3,null,null,4,5]"

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

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            buildString(root, sb);
            return sb.toString();
        }

        private void buildString(TreeNode node, StringBuilder sb) {
            if (node == null) {
                sb.append(NN).append(spliter);
            } else {
                sb.append(node.val).append(spliter);
                buildString(node.left, sb);
                buildString(node.right,sb);
            }
        }
        
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Queue<String> nodes = new LinkedList<>();
            nodes.addAll(Arrays.asList(data.split(spliter)));
            return buildTree(nodes);
        }

        private TreeNode buildTree(Queue<String> nodes) {
            String val = nodes.remove();
            if (val.equals(NN)) return null;
            else {
                TreeNode node = new TreeNode(Integer.valueOf(val));
                node.left = buildTree(nodes);
                node.right = buildTree(nodes);
                return node;
            }
        }
    }


//    public static class Codec {
//
//        // Encodes a tree to a single string.
//        String serialValue = null;
//        public String serialize(TreeNode root) {
//
//            String serial = preOrderTraversal(root, "");
//            return serial;
//        }
//
//        public String preOrderTraversal(TreeNode node, String str) {
//            if (node == null) return str+= "null,";
//
//            else {
//                str+=String.valueOf(node.val) +",";
//                str = preOrderTraversal(node.left, str);
//                str = preOrderTraversal(node.right, str);
//            }
//
//            return str;
//        }
//
//        public TreeNode rdeserialize(List<String> l) {
//            // Recursive deserialization.
//           if (l.get(0).equals( "null")) {
//               l.remove(0);
//               return null;
//           }
//
//           TreeNode root = new TreeNode(Integer.parseInt(l.get(0)));
//           l.remove(0);
//           root.left = rdeserialize(l);
//           root.right = rdeserialize(l);
//
//           return root;
//        }
//
//        // Decodes your encoded data to tree.
//        public TreeNode deserialize(String data) {
//            String[] data_array = data.split(",");
//            List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
//            TreeNode node = rdeserialize(data_list);
//            return node;
//        }
//    }

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