package com.example.ArrayStrings;

//File file("abcdefghijk"); // File is "abcdefghijk", initially file pointer (fp) points to 'a'
//        char[] buf = new char[4]; // Create buffer with enough space to store characters
//        read4(buf); // read4 returns 4. Now buf = "abcd", fp points to 'e'
//        read4(buf); // read4 returns 4. Now buf = "efgh", fp points to 'i'
//        read4(buf); // read4 returns 3. Now buf = "ijk", fp points to end of file
//        https://leetcode.com/problems/read-n-characters-given-read4/

public class ReadNCharactersGivenRead4_157 {

    //submitted to leetcode
    public static void main(String[] args) {
//        String input = "abca";
        String input = "abcdefghijk";
//        System.out.println("Palindrome result:  " + isPalindrome(input));
    }


    public static int read(char[] buf, int n) {
        int total = 0;
        boolean eof = false;
        char[] temp = new char[4];

        while(!eof && total < n) {
         int count = 0;//read4(temp);
         count = Math.min(count, n-total);

         if (count<4) eof = true;

         for (int i=0; i<count;i++) {
             buf[total++] = temp[i];
         }
        }
        return total;
    }
}