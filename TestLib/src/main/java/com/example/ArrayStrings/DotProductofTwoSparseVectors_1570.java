package com.example.ArrayStrings;

//    Input: nums1 = [1,0,0,2,3], nums2 = [0,3,0,4,0]
//    Output: 8
//    Explanation: v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
//    v1.dotProduct(v2) = 1*0 + 0*3 + 0*0 + 2*4 + 3*0 = 8
//    https://leetcode.com/problems/dot-product-of-two-sparse-vectors/

import java.util.HashMap;
import java.util.Map;
public class DotProductofTwoSparseVectors_1570 {
    public static void main(String[] args) {
        int[] intput1 = {1,0,0,2,3};
        SparseVector v1 = new SparseVector(intput1);
        int[] intput2 = {0,3,0,4,0};
        SparseVector v2 = new SparseVector(intput2);
        int ans = v1.dotProduct(v2);
        System.out.println(ans);
    }

    static class SparseVector {
        Map<Integer, Integer> map = new HashMap();
        SparseVector(int[] nums) {
          for (int i=0; i< nums.length;i++) {
              if (nums[i] != 0) {
                  map.put(i, nums[i]);
              }
          }
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
          int product = 0;
          if (map.size()==0 || vec.map.size()==0) return 0;
          if (vec.map.size() < map.size()) return vec.dotProduct(this);
          for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
             int key = entry.getKey();
             if(vec.map.containsKey(key)) {
                 product += map.get(key)*vec.map.get(key);
             }
          }
          return product;
        }
    }
}