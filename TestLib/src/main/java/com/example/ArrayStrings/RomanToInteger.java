package com.example.ArrayStrings;

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println("Start main " +myromanToInteger("MCMXCIV"));
    }

    private static int myromanToIntegerPractice(String input) {
      int currentValue = 0, prevValue=0, totalValue = 0;
      int length = input.length();

      for (int i = length-1; i >=0; i--) {
          char c = input.charAt(i);
          switch(c) {
              case 'I':
                  currentValue = 1;
                  break;
              case 'V':
                  currentValue = 5;
                  break;
              case 'X':
                  currentValue = 10;
                  break;
              case 'L':
                  currentValue = 50;
                  break;
              case 'C':
                  currentValue = 100;
                  break;
              case 'D':
                  currentValue = 500;
                  break;
              case 'M':
                  currentValue = 1000;
                  break;
          }
         if (prevValue>0 && currentValue < prevValue) {
             totalValue -=currentValue;
         } else {
             totalValue += currentValue;
         }
         prevValue=currentValue;
      }

     return totalValue;
    }

    //need to improve of time complexity
    private static int myromanToInteger(String input) {
      int totalValue = 0;
      int currValue = 0;
      int prevValue = 0;

      for(int i =input.length() -1; i>=0; i--) {
          char c = input.charAt(i);
          switch(c) {
              case 'I':
                  currValue = 1;
                  break;
              case 'V':
                  currValue = 5;
                  break;
              case 'X':
                  currValue = 10;
                  break;
              case 'L':
                  currValue = 50;
                  break;
              case 'C':
                  currValue = 100;
                  break;
              case 'D':
                  currValue = 500;
                  break;
              case 'M':
                  currValue = 1000;
                  break;
          }
          if (prevValue >0 && currValue < prevValue) {
              totalValue = totalValue - currValue;
          } else {
              totalValue = totalValue + currValue;
          }
          prevValue = currValue;
      }
      return totalValue;
    }




















    public static int romanToInt(String s) {
        int total = 0;
        int prevVal = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            int currVal = 0;
            char curr = s.charAt(i);
            switch(curr) {
                case 'I':
                    currVal = 1;
                    break;
                case 'V':
                    currVal = 5;
                    break;
                case 'X':
                    currVal = 10;
                    break;
                case 'L':
                    currVal = 50;
                    break;
                case 'C':
                    currVal = 100;
                    break;
                case 'D':
                    currVal = 500;
                    break;
                case 'M':
                    currVal = 1000;
                    break;
            }
            if(prevVal != 0 && currVal < prevVal) {
                total -= currVal;
            } else {
                total += currVal;
            }
            prevVal = currVal;
        }
        return total;
    }

}
