package com.example.ArrayStrings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Input: nums = [1, 1, 2, 45, 46, 46], target = 47
//        Output: 2
//        Explanation:
//        1 + 46 = 47
//        2 + 45 = 47
//        https://leetcode.com/discuss/interview-question/372434

public class TwoSum_UniquePairs {

    public static void main(String[] args) {
//        int[] input = {1, 1, 2, 45, 46, 46};
//        int result = getUniquePairsOpti(input, 47);
//        System.out.println(result);

        int[] test = {-1, 0,0, 0, 1, 2, 3, -2};
        List<List<Integer>> result1 = getUniquePairsZeroSum(test, 0);
        for (List<Integer> res: result1) {
            System.out.println(res.toString());
        }
    }

    // Java O(nlogn)
    public static int getUniquePairs(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int ans = 0;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                ans++;
                i++;
                j--;
                while (i < j && nums[i] == nums[i - 1]) {
                    i++;
                }
                while (i < j && nums[j] == nums[j + 1]) {
                    j--;
                }
            }
        }
        return ans;
    }

    // java O(n)   [1, 1, 2, 45, 46, 46], target = 47
    public static int getUniquePairsOpti(int[] nums, int target) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> seen = new HashSet<Integer>();
        int count = 0;
        for (int num : nums) {
            if (set.contains(target - num) && !seen.contains(num)) {
                count++;
                seen.add(target - num);
                seen.add(num);
            } else if (!set.contains(num)) {
                set.add(num);
            }

        }
        return count;
    }

//    https://leetcode.com/discuss/interview-question/1013361/Facebook-or-Phone-Interview-or-rejected-are-silly-mistakes-not-overlooked-for-E6
    public static List<List<Integer>> getUniquePairsZeroSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> seen = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int num : nums) {
           if (set.contains(target-num) && !seen.contains(num)) {
              result.add(Arrays.asList(num, target-num));
              seen.add(num);
              seen.add(target-num);
           } else if (!set.contains(num)) {
               set.add(num);
           }
        }
        return result;
    }

}