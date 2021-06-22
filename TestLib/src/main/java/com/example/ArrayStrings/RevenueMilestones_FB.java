package com.example.ArrayStrings;

public class RevenueMilestones_FB {

    public static void main(String[] args) {
        int[] revenues = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int[] milestones = {100, 200, 500};
//        output = [4, 6, 10]
        int[] result = getMilestoneDays(revenues, milestones);
        for (int res: result) {
            System.out.println(res);
        }
    }

    public static int[] getMilestoneDays(int[] revenues, int[] milestones) {
         int days = revenues.length;
         int[] preSum = new int[days+1];
         for (int i = 1; i <= revenues.length; i++) {
             preSum[i] = preSum[i-1]+revenues[i-1];
         }

         int[] result = new int[milestones.length];
         int j = 0;
         for (int i = 0; i < milestones.length; i++) {
             while (j <= revenues.length && milestones[i] > preSum[j]) {
                 j++;
             }
             if (j <= revenues.length) {
                 result[i] = j;
             } else {
                 result[i] = -1;
             }
         }
         return result;
    }
}