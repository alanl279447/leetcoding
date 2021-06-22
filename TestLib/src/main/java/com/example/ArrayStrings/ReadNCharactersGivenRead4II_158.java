package com.example.ArrayStrings;

//        File file("abcdefghijk"); // File is "abcdefghijk", initially file pointer (fp) points to 'a'
//        char[] buf = new char[4]; // Create buffer with enough space to store characters
//        read4(buf); // read4 returns 4. Now buf = "abcd", fp points to 'e'
//        read4(buf); // read4 returns 4. Now buf = "efgh", fp points to 'i'
//        read4(buf); // read4 returns 3. Now buf = "ijk", fp points to end of file
//https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/
//   go over ReadNCharactersGivenRead4_157 first

public class ReadNCharactersGivenRead4II_158 {

    //submitted to leetcode
    public static void main(String[] args) {
        String input = "abcdefghijk";
        // System.out.println("Palindrome result:  " + isPalindrome(input));
    }

    char[] temp = new char[4];    //prev buffer
    int tmpPtr = 0;               //chars read
    int tmpCount = 0;             //total chars
    public int read(char[] buf, int n) {
        int total = 0;
        while (total < n) {
            if (tmpPtr ==0) {
                tmpCount = 0;//read4(temp);
            }
            if (tmpCount == 0) break;
            while (total < n && tmpPtr < tmpCount) {
                buf[total++]=temp[tmpPtr++];
            }
            if (tmpPtr==tmpCount) tmpPtr=0;
            if (tmpCount <4) break;
        }
       return total;
    }
}