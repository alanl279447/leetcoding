package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AccountsMerge721 {
//    Input:
//    accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
//    Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
//    Explanation:
//    The first and third John's are the same person as they have the common email "johnsmith@mail.com".
//    The second John and Mary are different people as none of their email addresses are used by other accounts.
//    We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
//            ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
//    https://leetcode.com/problems/accounts-merge/
//    O(n * log(n)) Time and O(n) Space
//    Without the log factor, this is the complexity to build the graph and search for each component.
//    The log factor is for sorting each component at the end.

    public static TreeNode root = null;
    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
//        addNode();
        String[][] input = {{"John", "johnsmith@mail.com", "john00@mail.com", "johnTest@mail.com"},
                {"John", "johnnybravo@mail.com"},
                {"John", "johnsmith@mail.com", "john_newyork@mail.com"},
                {"Mary", "mary@mail.com"}};
        List<List<String>> res = Arrays.stream(input).map(Arrays::asList).collect(Collectors.toList());
        List<List<String>> result = accountsMerge(res);
        for (List<String> boundary: result) {
            System.out.println(boundary);
        }
    }


//    public static List<List<String>> accountsMergeTest(List<List<String>> accounts) {
//        HashMap<String, Set<String>> map = new HashMap();
//        HashMap<String, String> emailToName = new HashMap<>();
//        buildGraphTest(map, accounts, emailToName);
//
//    }
//
//    public static void buildGraphTest(HashMap<String, Set<String>> map, List<List<String>>  accounts,
//                                      HashMap<String, String> emailToName) {
//        for (List<String> account: accounts) {
//          String name = account.get(0);
//          for (int i =1; i < account.size(); i++) {
//              map.putIfAbsent(account.get(1), new HashSet());
//              if(i ==1) continue;
//              map.get(account.get(i-1)).add()
//
//          }
//
//        }
//    }

    //build graph map key email and other emails
    //another map of email,name loop all the keys
    //dfs keySet(unique emails)
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        if (accounts.size() == 0) return res;
        Map<String, Set<String>> g = new HashMap<>();
        Map<String, String> mailToName = new HashMap<>();
        buildGraph(g, accounts, mailToName);

        Set<String> visited = new HashSet<>();
        for (String mail: mailToName.keySet()) {
            String name = mailToName.get(mail);
            List<String> mails = new ArrayList<>();
            if (visited.add(mail)) {
                dfs(mails, mail, g, visited);
                Collections.sort(mails);
                mails.add(0, name);
                res.add(mails);
            }
        }
        return res;
    }

    private static void dfs(List<String> mails, String mail, Map<String, Set<String>> g, Set<String> visited) {
        mails.add(mail);
        if (g.get(mail).size() == 0) return;
        for (String neigh: g.get(mail)) {
            if (visited.add(neigh)) {
                dfs(mails, neigh, g, visited);
            }
        }
    }

    private static void buildGraph(Map<String, Set<String>> g, List<List<String>> accounts, Map<String, String> mailToName) {
        for (List<String> account: accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String mail = account.get(i);
                mailToName.put(mail, name);
                g.putIfAbsent(mail, new HashSet<>());
                if (i == 1) continue;
                String prev = account.get(i - 1);
                g.get(prev).add(mail);
                g.get(mail).add(prev);
            }
        }
    }


    public static void addNode() {
        root = addNodeRecursive(root, 10);
        root.left = new TreeNode(15);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(17);
        root.right.left = new TreeNode(14);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
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