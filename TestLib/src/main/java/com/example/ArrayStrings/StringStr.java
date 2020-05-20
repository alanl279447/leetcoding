package com.example.ArrayStrings;

public class StringStr {

    public static void main(String[] args) {
        System.out.println("Start main " +strStr("a", "a"));
    }

        public static int strStr1(String haystack, String needle) {
            int L = needle.length(), n = haystack.length();
            if (L == 0) return 0;

            int pn = 0;
            while (pn < n - L +1) {
                // find the position of the first needle character
                // in the haystack string
                while (pn < n - L +1  && haystack.charAt(pn) != needle.charAt(0)) ++pn;

                // compute the max match string
                int currLen = 0, pL = 0;
                while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
                    ++pn;
                    ++pL;
                    ++currLen;
                }

                // if the whole needle string is found,
                // return its start position
                if (currLen == L) return pn - L;

                // otherwise, backtrack
                pn = pn - currLen + 1;
            }
            return -1;
        }


    public static int strStr(String haystack, String needle) {
      int pn = 0, ph = 0, curr_length = 0, index = 0;

      while (pn < (haystack.length() - needle.length()  + 1)) {
          while (ph < haystack.length() &&
                  pn < needle.length() &&
                  haystack.charAt(ph) == needle.charAt(pn)) {
              ph++;
              pn++;
              curr_length++;
          }
          if (curr_length == needle.length()) {
              //System.out.println("matching index: ")
              return ph - needle.length() + 1;
          }
          ph = ph - curr_length + 1;
          pn =0;
          curr_length =0;
      }
      return -1;
    }
}
