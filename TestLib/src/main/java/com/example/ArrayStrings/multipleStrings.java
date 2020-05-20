package com.example.ArrayStrings;

public class multipleStrings {
//    Input: num1 = "123", num2 = "456"
//    Output: "56088"
//    https://leetcode.com/problems/multiply-strings/
//    O(mn) time, O(1) space

    public static void main(String[] args) {
        String nums1 = "123";
        String nums2 = "456";
        System.out.println("Product value is: "+multiply123(nums1, nums2));
    }

    //https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation

    public static String multiply123(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p2] =  sum % 10;
                pos[p1] += sum / 10;

            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : pos) {
            if(!(sb.length() == 0 && p == 0))  {   //to avoid leading zero's
                sb.append(p);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();   //when the input is '0', '0'
    }


}
