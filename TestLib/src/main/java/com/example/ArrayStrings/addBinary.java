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

//    public static String addBinary(String a, String b) {
//        int aLength = a.length(); //2
//        int bLength = b.length(); //1
//
//        StringBuilder sb = new StringBuilder();
//        int sum = 0;
//        int carry = 0;
//
//        while(aLength > 0 || bLength > 0) {
//            sum = carry;
//
//            if (aLength > 0) {
//                sum += a.charAt(aLength - 1) - '0';
//                aLength--;
//            }
//            if (bLength > 0) {
//                sum += b.charAt(bLength - 1) - '0';
//                bLength--;
//            }
//
//            carry = sum/2;
//            sum = sum%2;
//
//            sb.append(sum);
//        }
//        if (carry != 0) {
//            sb.append(carry);
//        }
//        return sb.reverse().toString();
//    }

//    public static String addBinary(String a, String b) {
//        StringBuilder sb = new StringBuilder();
//        int aLength = a.length() - 1, bLength = b.length() - 1, carry = 0;
//        while (aLength >= 0 || bLength >= 0) {
//            int sum = carry;
//            if (bLength >= 0) {
//                sum += b.charAt(bLength--) - '0';
//            }
//            if (aLength >= 0) {
//                sum += a.charAt(aLength--) - '0';
//            }
//            sb.append(sum % 2);
//            carry = sum / 2;
//        }
//        if (carry != 0) sb.append(carry);
//        return sb.reverse().toString();
//    }
}
