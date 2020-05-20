package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.List;

public class StringMatchFromKey {

    public static void main(String[] args) {
        String[] src = new String[]{"minecraftgame", "intelligent", "innercrafttalent", "knife", "scissor", "stonecrafter"};
        String key = "craft";
        List<String> result = addBinary(src, key);
    }

    private static List<String> addBinary(String[] srcArray, String key) {
        List<String> result = new ArrayList<>();

        for (String input:srcArray) {
           if (input.contains(key)) {
               result.add(input);
           }
        }
        return result;
    }
}
