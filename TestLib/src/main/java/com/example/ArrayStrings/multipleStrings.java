package com.example.ArrayStrings;

public class multipleStrings {
//    Input: num1 = "123", num2 = "456"
//    Output: "56088"
//    https://leetcode.com/problems/multiply-strings/
//    O(mn) time, O(m+n) space

    public static void main(String[] args) {
        String nums1 = "123";
        String nums2 = "456";
        System.out.println("Product value is: "+multiply(nums1, nums2));
//        System.out.println(rotationalFactor("ZzbB", 3));
    }

    //https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
    //          1 2 3       index i  //len m   i =2, j = 1
    //            4 5       index j  //len n
    //            1 5                //len m+n
    //         1  0 x
    //      0  5  x x
    //         1  2 x
    //      0  8  x x
    //    0 4
    //    0 5 5 3 5
    // i = 2, j = 1
    //p1 i+j = 3
    //p2 i+j+1 = 4
    public static String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p2] = sum % 10;
                pos[p1] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) {   //to avoid leading zero's
                sb.append(p);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();   //when the input is '0', '0'
    }




    public static String rotationalFactor(String input, int factor) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isLowerCase(c)) {
                c  = (char)((c - 'a'+factor)%26+97);
            } else if (Character.isUpperCase(c)) {
                c  = (char)((c - 'A'+factor)%26+65);
            }
            sb.append(c);
        }
        return sb.toString();
    }
}