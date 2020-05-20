package com.example.ArrayStrings;

public class StringWordDictionary {

//    dict[] = { find, a, geeks, all, for, on, geeks, answers, inter }
//    Input: str[] = { “find”, “all”, “answers”, “on”, “geeks”, “for”, “geeks” };
//    Output: YES
//    all words of str[] are present in the dictionary so the output is YES
//    https://www.geeksforgeeks.org/check-if-the-given-string-of-words-can-be-formed-from-words-present-in-the-dictionary/

    public static void main(String[] args) {
        String dictionary[] = { "find", "a", "geeks",
                "all", "for", "on",
                "geeks", "answers", "inter" };

        int n = dictionary.length;

        String sentence[] = { "find", "all", "answers", "on",
                "geeks", "for", "geeks" };
        int m = sentence.length;

        if (match_words(dictionary, sentence, n, m))
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    //function to calculate the number of actions
    // Function to check if the word
// is in the dictionary or not
    static boolean match_words(String dictionary[], String sentence[],
                               int n, int m) {
        return true;

    }

}
