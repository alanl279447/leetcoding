package com.example.ArrayStrings;

public class addBinary {

//    Input: a = "11", b = "1"
//    Output: "100"
//    https://leetcode.com/problems/add-binary/

    public static void main(String[] args) {
        String a = "11", b = "1";
        String result = addBinary(a, b);
        System.out.println(result);
    }

    public static String addBinary(String a, String b) {
        int l1 = a.length()-1;
        int l2 = b.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while(l1 >= 0 || l2 >=0 || carry >0) {
           int c1 = (l1>=0) ? a.charAt(l1--) - '0':0;
           int c2 = (l2>=0) ? b.charAt(l2--) - '0':0;

           int sum = (c1+c2+carry)%2;
           carry = (c1+c2+carry)/2;
           sb.append(sum);
        }
        return sb.reverse().toString();
    }
}
