package com.example.ArrayStrings;
//        Input: arr = [2,3,4,7,11], k = 5
//        Output: 9
//        Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
//        https://leetcode.com/problems/kth-missing-positive-number/

public class KthMissingPositiveNumber_1539 {
    public static void main(String[] args) {
//        int[] arr = {2,3,4,7,11};
        int[] arr = {1,4,5,8};
        System.out.println(findKthPositiveWork(arr, 3));
    }

    // arr[0] > k return k

    //1,4,5,8   3
    //find the first index having greater than k missing elements
    //a[l] - (l+1)  = a(2)-(2+1) = 5-3 = 2
    // a[l] having more than K elements missing
    //a[l-1] + k - (missing element until a[l-1])
    //a[l-1] + k - (a[l-1] - (l-1+1))
    //k+l answer
    //3+3 = 6

//    the count of missing numbers in these i numbers is arr[mid] - (mid + 1)
//    A=[1,4,5,8]   i  = 3
//    A[i-1]-i = 5-3 = 2 // There are two missing numbers in [1,4,5]

//    We use binary search to find the smallest index, l, such that there are more than k missing numbers in [0, A[l]].
//    The actual number of missing numbers in [0, A[l-1]] is A[l-1] - (l - 1) - 1 = A[l-1] - l.
//    Counting from A[l-1], The k-th missing number is therefore (A[l-1] + k - (A[l-1] - l) = l + k

    //find the a[l] where the missing numbers is more than k
    //missing numbers between 0, l-1   a[l-1] - (l-1+1)   = a[l-1]-l
    //a[l-1] + k - (a[l-1] - l)
    // k + l
    public static int findKthPositiveWork(int[] A, int k) {
        if (A == null) return -1;
        int low  = 0, high = A.length;
        while (low < high) {
            int midpt = low + (high-low)/2;
            if (A[midpt] - (midpt+1) < k) {
                low = midpt+1;
            } else {
                high = midpt;
            }
        }
        return low+k;
    }

    public static int findKthPositiveFastTest(int[] A, int k) {
        int l = 0, r = A.length, m;
        while (l < r) {
            m = l + (r-l) / 2;
            if (A[m] - (m+1) < k)
                l = m + 1;
            else
                r = m;
        }
        return l + k;
    }

    public static int findKthPositive(int[] arr, int k) {
        if (arr[0] > k) return k;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int pivot = left + (right - left) / 2;
            // If number of positive integers
            // which are missing before arr[pivot]
            // is less than k -->
            // continue to search on the right.
            if (arr[pivot] - pivot - 1 < k) {
                left = pivot + 1;
                // Otherwise, go left.
            } else {
                right = pivot - 1;
            }
        }

        // At the end of the loop, left = right + 1,
        // and the kth missing is in-between arr[right] and arr[left].
        // The number of integers missing before arr[right] is
        // arr[right] - right - 1 -->
        // the number to return is
        // arr[right] + k - (arr[right] - right - 1) = k + left
        return left + k;
    }

    public static int findKthPositiveTest(int[] arr, int k) {
        if (arr[0] < k) return k;
        int num = k;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < num) {
                num++;
            } else {
                break;
            }
        }
        return num;
    }

}

 //a[m]-m-1
 //4-2-1  == 1