package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveSubFoldersfromtheFilesystem_1233 {

//    Input: folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
//    Output: ["/a","/c/d","/c/f"]
//    Explanation: Folders "/a/b/" is a subfolder of "/a" and "/c/d/e" is inside of folder "/c/d" in our filesystem.
//    https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/
    public static void main(String[] args) {
        String[] folder = {"/a","/a/b","/c/d","/c/d/e","/c/f"};
        System.out.println(removeSubfolders(folder));
    }

    public static List<String> removeSubfolders(String[] folders) {
        TrieNode root = new TrieNode();
        for (String folder : folders) {
            String[] parts = folder.substring(1).split("/");
            TrieNode curr = root;
            for (String part : parts) {
                if (!curr.children.containsKey(part)) {
                    curr.children.put(part, new TrieNode());
                }
                curr = curr.children.get(part);
            }
            curr.word = folder;
        }
        parentFolders.clear();
        getResults(root);
        return parentFolders;
    }

    private static class TrieNode {
        HashMap<String, TrieNode> children = new HashMap<>();
        String word = null;
    }

    private static List<String> parentFolders = new ArrayList<>();
    static void getResults(TrieNode root) {
        for (Map.Entry<String, TrieNode> entry : root.children.entrySet()) {
            if (entry.getValue().word != null) {
                parentFolders.add(entry.getValue().word);
            } else {
                getResults(entry.getValue());
            }
        }
    }
}