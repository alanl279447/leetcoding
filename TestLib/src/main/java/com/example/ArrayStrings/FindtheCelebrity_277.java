package com.example.ArrayStrings;

public class FindtheCelebrity_277 {
//    Input: graph = [
//            [1,1,0],
//            [0,1,0],
//            [1,1,1]
//            ]
//    Output: 1
//    Explanation: There are three persons labeled with 0, 1 and 2.
//    graph[i][j] = 1 means person i knows person j, otherwise graph[i][j] = 0 means person i does not know person j.
//    The celebrity is the person labeled as 1 because both 0 and 2 know him but 1 does not know anybody.
//    https://leetcode.com/problems/find-the-celebrity/

    public static void main(String args[]) {
        int n  = 3;
        int res = findCelebrity(n);
        System.out.println(res);
    }

    private static int numberOfPeople;
    // 0,1,2,3
    // 0-1
    // 1

    public static int findCelebrity(int n) {
        numberOfPeople = n;
        int celebrityCandidate = 0;
        for (int i = 0; i < n; i++) {
//            if (knows(celebrityCandidate, i)) {
//                celebrityCandidate = i;
//            }
        }
        if (isCelebrity(celebrityCandidate)) {
            return celebrityCandidate;
        }
        return -1;
    }

    private static boolean isCelebrity(int i) {
        for (int j = 0; j < numberOfPeople; j++) {
            if (i == j) continue; // Don't ask if they know themselves.
//            if (knows(i, j) || !knows(j, i)) {
//                return false;
//            }
        }
        return true;
    }
}
