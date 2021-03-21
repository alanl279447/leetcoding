package com.example.uber;


//Given a list, [1,2,1,2,4], your code should return 1 : ([1,2,1,2]),
//Given a list, [1,2,3,3,3,2,4], your code should return 4 ([3,3], [3,3], [3,3,3], [2,3,3,3,2])
//https://leetcode.com/discuss/interview-question/894762/Uber-OA-Oct-2020

import java.util.HashMap;
import java.util.Map;

public class SubArrayAppearingTwice {

    // Function to get the count
// of subarrays having each
// element occuring at least twice
    static int cntSubarrays(Integer arr[], int N)
    {

        // Stores count of subarrays
        // having each distinct element
        // occuring at least twice
        int cntSub = 0;

        // Stores count of unique
        // elements in a subarray
        int cntUnique = 0;

        // Store frequency of
        // each element of a subarray
        Map<Integer,
                Integer> cntFreq = new HashMap<Integer,
                Integer>();

        // Traverse the given
        // array
        for(int i = 0; i < N; i++)
        {

            // Count frequency and
            // check conditions for
            // each subarray
            for(int j = i; j < N; j++)
            {

                // Update frequency
                cntFreq.put(arr[j],
                        cntFreq.getOrDefault(
                                arr[j], 0) + 1);

                // Check if frequency of
                // arr[j] equal to 1
                if (cntFreq.get(arr[j]) == 1)
                {

                    // Update Count of
                    // unique elements
                    cntUnique++;
                }
                else if (cntFreq.get(arr[j]) == 2)
                {

                    // Update count of
                    // unique elements
                    cntUnique--;
                }

                // If each element of subarray
                // occurs at least twice
                if (cntUnique == 0)
                {

                    // Update cntSub
                    cntSub++;
                }
            }

            // Remove all elements
            // from the subarray
            cntFreq.clear();

            // Update cntUnique
            cntUnique = 0;
        }
        return cntSub;
    }

    // Driver code
    public static void main(String[] args)
    {
        Integer arr[] = { 1,2,3,3,3,2,4 };
        Integer n = arr.length;
        System.out.println(cntSubarrays(arr, n));
    }
}