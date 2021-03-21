package com.example.ArrayStrings;

//Input: n = 9,
//1 2 3 4 5 6 7 8 9
//2 4 6 8
//2 6
//6
//Output: 6
//https://leetcode.com/problems/elimination-game/
//https://leetcode.com/problems/elimination-game/discuss/87119/JAVA%3A-Easiest-solution-O(logN)-with-explanation

//class LastSubstringLexicographicalOrder_1163 {
fun main(args: Array<String>) {
    System.out.println(lastRemaining(24))
}

//1,2,3,4,5,6,7,8,9
//head will move when left=true || remaining%2==1
fun lastRemaining(n: Int): Int {
    var left = true
    var remaining = n
    var step = 1
    var head = 1
    while (remaining > 1) {
        if (left || remaining % 2 == 1) {
            head = head + step
        }
        remaining = remaining / 2
        step = step * 2
        left = !left
    }
    return head

}
//}