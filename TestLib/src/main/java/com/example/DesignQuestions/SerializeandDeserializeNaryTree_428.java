package com.example.DesignQuestions;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeandDeserializeNaryTree_428 {

//    [1 [3[5 6] 2 4]].
//    https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/

    public static Node root = null;
    public static void main(String[] args) {
//        addNode(1);
        Codec codec = new Codec();
        String serialize = codec.serialize(root);
        System.out.println(serialize);
        Node root = codec.deserialize(serialize);
        System.out.println(root.val);
    }

    static class Codec {
        // Encodes a tree to a single string.
        public String serialize(Node root) {
            List<String> list=new LinkedList<>();
            serializeHelper(root,list);
            return String.join(",",list);
        }

        private void serializeHelper(Node root, List<String> list){
            if(root==null){
                return;
            }else{
                list.add(String.valueOf(root.val));
                list.add(String.valueOf(root.children.size()));
                for(Node child:root.children){
                    serializeHelper(child,list);
                }
            }
        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            if(data.isEmpty())
                return null;

            String[] ss=data.split(",");
            Queue<String> q=new LinkedList<>(Arrays.asList(ss));
            return deserializeHelper(q);
        }

        private Node deserializeHelper(Queue<String> q){
            Node root=new Node();
            root.val=Integer.parseInt(q.poll());
            int size=Integer.parseInt(q.poll());
            root.children=new ArrayList<Node>(size);
            for(int i=0;i<size;i++){
                root.children.add(deserializeHelper(q));
            }
            return root;
        }
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}