package com.codePlus;

public class One {
    public static void main(String[] args) {

        // 0, 1, 2, 3, 4, 5, 6, 7
        // 7 > 0
        // 6 > 1
        // 5 > 2
        // 3 > 4
        // 4 > 3, 7 > 3
        // 2 > 5
        // 1 > 6, 7 > 6
        // 0 > 7, 6 > 7, 3 > 7

        int[][] dp = new int[7][8];

        dp[0][7] = 1;
        for (int i=1; i<=6; i++) {
            dp[i][0] = dp[i - 1][7];
            dp[i][1] = dp[i - 1][6];
            dp[i][2] = dp[i - 1][5];
            dp[i][3] = dp[i - 1][4] + dp[i - 1][7];
            dp[i][4] = dp[i - 1][3];
            dp[i][5] = dp[i - 1][2];
            dp[i][6] = dp[i - 1][1] + dp[i - 1][7];
            dp[i][7] = dp[i - 1][0] + dp[i - 1][3] + dp[i - 1][6];
        }

    }
}
