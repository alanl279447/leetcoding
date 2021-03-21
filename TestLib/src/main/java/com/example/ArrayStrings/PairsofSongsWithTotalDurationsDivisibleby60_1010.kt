package com.example.ArrayStrings

//Input: time = [30,20,150,100,40]
//Output: 3
//Explanation: Three pairs have a total duration divisible by 60:
//(time[0] = 30, time[2] = 150): total duration 180
//(time[1] = 20, time[3] = 100): total duration 120
//(time[1] = 20, time[4] = 40): total duration 60
//https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
//https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/solution/

fun main (args: Array<String>) {
    System.out.println(numPairsDivisibleBy60(intArrayOf(30,20,150,100,40)))
}

//if a%60=0 add remainders[0] to the result;
// else, add remainders[60 - t % 60] to the result;
//update remainders[a % 60].

//time complexity 0(n).
fun numPairsDivisibleBy60(times: IntArray): Int {
  var remainders: IntArray = IntArray(60)
  var count = 0
  for (time in times) {
      if(time%60 == 0) {    // check if a%60==0 && b%60==0
          count +=remainders[0]
      } else {
          count += remainders[60-time%60] //// check if a%60+b%60==60
      }
      remainders[time%60]++
  }
    return count
}