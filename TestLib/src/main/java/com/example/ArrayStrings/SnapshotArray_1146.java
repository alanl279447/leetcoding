package com.example.ArrayStrings;

import java.util.TreeMap;

public class SnapshotArray_1146 {

//    Input: ["SnapshotArray","set","snap","set","get"]
//            [[3],[0,5],[],[0,6],[0,0]]
//    Output: [null,null,0,null,5]
//    Explanation:
//    SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
//snapshotArr.set(0,5);  // Set array[0] = 5
//snapshotArr.snap();  // Take a snapshot, return snap_id = 0
//snapshotArr.set(0,6);
//snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return 5
//    https://leetcode.com/problems/snapshot-array/
    public static void main(String[] args) {
        int length = 3;
        SnapshotArray obj = new SnapshotArray(length);
        obj.set(0,5);
        int param_2 = obj.snap();
        System.out.println(param_2);
        int param_3 = obj.get(0,0);
        System.out.println(param_3);
    }
}

class SnapshotArray {
    TreeMap<Integer, Integer>[] A;
    int snap_id = 0;
    public SnapshotArray(int length) {
        A = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            A[i] = new TreeMap<Integer, Integer>();
            A[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        A[index].put(snap_id, val);
    }

    public int snap() {
        return snap_id++;
    }

    public int get(int index, int snap_id) {
        return A[index].floorEntry(snap_id).getValue();
    }
}