package com.example.ArrayStrings;

public class StringStr {

    public static void main(String[] args) {
        System.out.println("Start main " +strStr("a", "a"));
    }

    public static int strStr(String haystack, String needle) {
        int pn = 0, ph = 0, curr_length = 0;

        if (needle.length() ==0) return 0;
        while (ph < (haystack.length() - needle.length() + 1)) {
            while (ph < haystack.length() &&
                    pn < needle.length() &&
                    haystack.charAt(ph) == needle.charAt(pn)) {
                ph++;
                pn++;
                curr_length++;
            }
            if (curr_length == needle.length()) {
                //System.out.println("matching index: ")
                return ph - needle.length();
            }
            ph = ph - curr_length + 1;
            pn =0;
            curr_length =0;
        }
        return -1;
    }
}
