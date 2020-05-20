package com.example.ArrayStrings;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement169 {

//    Input: [2,2,1,1,1,2,2]
//    Output: 2
//    https://leetcode.com/problems/majority-element/
    //time complexity 0(n)
    //space complexity 0(1)

    public static void main(String[] args) {
        int[] input = {2,2,1,1,1,2,2};
        System.out.println("Longest subString is: "+majorityElement(input));
    }


    public static int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public ListNode createNode(int[] vals) {
        ListNode root = null;
       //addRecusively(root, vals);
       return root;
    }

    private ListNode addRecusively(ListNode node, int value) {
        if (node == null) {
            return node = new ListNode(value);
        } else {
          while (node.next != null) {

          }
        }
        return null;
    }

    public class ListNode {
      int val;
      ListNode next;
      public ListNode(int x) { val = x; }
  }

}
