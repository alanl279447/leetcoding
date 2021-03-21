package com.example.ArrayStrings;

public class RepeatedStringMatch_686 {

//    Input: a = "abcd", b = "cdabcdab"
//    Output: 3
//    Explanation: We return 3 because by repeating a three times "abcdabcdabcd", b is a substring of it.
//    https://leetcode.com/problems/repeated-string-match/
    public static void main(String[] args) {
        System.out.println(repeatedStringMatchFast("abcd", "cdabcdab"));
    }

    public static int repeatedStringMatchFast(String a, String b) {
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        for(int i = 0 ; i < A.length ; i ++){
            int numValidChars = validateCharacters(A, B, i);
            if(numValidChars == B.length)
                return (A.length + B.length + i - 1) / A.length;
            if(numValidChars >= A.length)
                return -1;
        }
        return -1;
    }

    public static int validateCharacters(char[] A, char[] B, int offset){
        int res = 0;
        for(char c : B){
            if(A[(res + offset) % A.length] != c)
                return res;
            res ++;
        }
        return res;
    }

    public int repeatedStringMatchSimple(String A, String B) {
        int count = 1; // Minimum number of times A has to be repeated.
        StringBuilder resStr = new StringBuilder(A);

        while (resStr.length() < B.length()) {
            resStr.append(A);
            count++;
        }
        if (resStr.indexOf(B) != -1)
            return count;

        resStr.append(A);
        return (resStr.indexOf(B) == -1) ? -1 : count + 1;
    }
}