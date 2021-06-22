package com.example.ArrayStrings;

//Input: IP = "172.16.254.1"
//        Output: "IPv4"
//        Explanation: This is a valid IPv4 address, return "IPv4".
//
//        Input: IP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
//        Output: "IPv6"
//        Explanation: This is a valid IPv6 address, return "IPv6".
//https://leetcode.com/problems/validate-ip-address/
 // time complexity 0(N)

public class ValidateIPAddress_468 {
    public static void main(String[] args) {
        String s = "172.16.254.1";
        System.out.println(validIPAddress(s));
    }

    public static String validIPAddress(String ip) {
       if (ip == null)  return "Neither";
       if (ip.chars().filter(ch-> ch=='.').count() == 3) {
          return  validateIPv4(ip);
       } else if (ip.chars().filter(ch-> ch==':').count() == 7) {
          return  validateIPv6(ip);
       }
       return "Neither";
    }

    public static String validateIPv6(String IP) {
        String[] nums = IP.split(":", -1);
        String hexdigits = "0123456789abcdefABCDEF";
        for (String x : nums) {
            // Validate hexadecimal in range (0, 2**16):
            // 1. at least one and not more than 4 hexdigits in one chunk
            if (x.length() == 0 || x.length() > 4) return "Neither";
            // 2. only hexdigits are allowed: 0-9, a-f, A-F
            for (Character ch : x.toCharArray()) {
                if (hexdigits.indexOf(ch) == -1) return "Neither";
            }
        }
        return "IPv6";
    }

    public static String validateIPv4(String ip) {
        String[] nums = ip.split("\\.", -1);
        for (String x : nums) {
            // Validate integer in range (0, 255):
            // 1. length of chunk is between 1 and 3
            if (x.length() == 0 || x.length() > 3) return "Neither";
            // 2. no extra leading zeros
            if (x.charAt(0) == '0' && x.length() != 1) return "Neither";
            // 3. only digits are allowed
            for (char ch : x.toCharArray()) {
                if (! Character.isDigit(ch)) return "Neither";
            }
            // 4. less than 255
            if (Integer.parseInt(x) > 255) return "Neither";
        }
        return "IPv4";
    }
}