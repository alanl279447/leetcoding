package com.example.Stack

import java.util.*

//    Input: "/a//b////c/d//././/.."
//    Output: "/a/b/c"
//    https://leetcode.com/problems/simplify-path/

fun simplifyPath(path: String): String {
    if (path == null) return path
    var stack:Deque<String>  = ArrayDeque()
    var splits = path.split("/".toRegex())

    for (split in splits) {
        if(split.equals(".") || split.equals(" ")) continue
        else if (split.equals("..")) {
            if(!stack.isEmpty()) stack.pollLast()
        } else {
            stack.offerLast(split)
        }
    }
    var sb:StringBuilder = StringBuilder()
    for (st in stack) {
        sb.append("/")
        sb.append(st)
    }
    return if (sb.length > 0) sb.toString() else "/"
}