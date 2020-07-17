package com.example.ArrayStrings;

public class GasStation_134 {
//    Input:
//    gas  = [1,2,3,4,5]
//    cost = [3,4,5,1,2]
//
//    Output: 3
//
//    Explanation:
//    Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
//    Travel to station 4. Your tank = 4 - 1 + 5 = 8
//    Travel to station 0. Your tank = 8 - 2 + 1 = 7
//    Travel to station 1. Your tank = 7 - 3 + 2 = 6
//    Travel to station 2. Your tank = 6 - 4 + 3 = 5
//    Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
//    Therefore, return 3 as the starting index.
//    https://leetcode.com/problems/gas-station/

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        int sumCost = 0;
        int start = 0;
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        if (sumGas < sumCost) {
            return -1;
        } else {
            return start;
        }
    }
}