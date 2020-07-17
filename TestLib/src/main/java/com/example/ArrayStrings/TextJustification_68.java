package com.example.ArrayStrings;

//Input:
//        words = ["This", "is", "an", "example", "of", "text", "justification."]
//        maxWidth = 16
//        Output:
//        [
//        "This    is    an",
//        "example  of text",
//        "justification.  "
//        ]
//        https://leetcode.com/problems/text-justification/

import java.util.ArrayList;
import java.util.List;

public class TextJustification_68 {

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> result = fullJustify(words, 16);

        for (String res: result)
          System.out.println(res);
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        int index = 0;

        while (index < n) {
            int totalChars = words[index].length();
            int last = index + 1;

            while (last < n) {
                if (totalChars + 1 + words[last].length()
                        > maxWidth) break;
                totalChars += 1 + words[last].length();
                last++;
            }

            int gaps = last - index - 1;
            StringBuilder sb = new StringBuilder();

            if (last == n || gaps == 0) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    sb.append(' ');
                }
                sb.deleteCharAt(sb.length() - 1);
                while (sb.length() < maxWidth) {
                    sb.append(' ');
                }
            } else {
                int spaces = (maxWidth - totalChars) / gaps;
                int rest = (maxWidth - totalChars) % gaps;

                for (int i = index; i < last - 1; i++) {
                    sb.append(words[i]);
                    sb.append(' ');

                    for (int j = 0; j < spaces + (i - index < rest ? 1 : 0); j++) {
                        sb.append(' ');
                    }
                }
                sb.append(words[last - 1]);
            }
            res.add(sb.toString());
            index = last;
        }
        return res;
    }


}