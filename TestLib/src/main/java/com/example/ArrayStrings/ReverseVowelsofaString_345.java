package com.example.ArrayStrings;

//        Input: "leetcode"
//        Output: "leotcede"
//        https://leetcode.com/problems/reverse-vowels-of-a-string/

public class ReverseVowelsofaString_345 {
    public static void main(String[] args) {
        System.out.println(reverseVowels("leetcode"));
    }

    public static String vowels = "aeiouAEIOU";
    public static String reverseVowels(String s) {
        int start =0, end = s.length()-1;
        char[] arr = s.toCharArray();
        while (start < end) {
            while(start<end && vowels.indexOf(arr[start]) == -1) {
                start++;
            }
            while(start<end && vowels.indexOf(arr[end]) == -1) {
                end--;
            }
            char temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        return new String(arr);
    }

}