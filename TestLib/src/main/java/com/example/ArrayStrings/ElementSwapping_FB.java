package com.example.ArrayStrings;

public class ElementSwapping_FB {

//    n = 5
//    k = 3
//    arr = [8, 9, 11, 2, 1]
//    output = [2, 8, 9, 11, 1]
//    We can swap [11, 2], followed by [9, 2], then [8, 2].

    public static void main(String[] args) {

        int[] input = {8, 9, 11, 2, 1};
        int[] res = findMinArray(input, 3);
        for (int re: res) {
            System.out.println(re);
        }
    }

    public static int[] findMinArray(int[] arr, int k) {
        for(int i =0; i < arr.length && k >0; i++) {
            int minIndex = findMinAtDistanceK(arr, i, k);
            //if minimum element is already at position i, nothing to do
            if(minIndex == i) {
                continue;
            }
            swap(arr, i, minIndex);
            // we have used up minindex-i swaps
            k -= minIndex - i;
        }
        return arr;
    }

    private static int findMinAtDistanceK(int [] arr, int start, int k) {
        int index = 0, min = Integer.MAX_VALUE;
        // find minimum element at distance k from start
        for(int i=start; i <= start + k; i++) {
            if(arr[i] < min) {
                min = arr[i];
                index =i;
            }
        }
        return index;
    }

    private static void swap(int [] arr, int start, int end) {
        //move element at position end to start
        while(end > start) {
            int temp = arr[end];
            arr[end] = arr[end-1];
            arr[end-1] = temp;
            end--;
        }
    }
}