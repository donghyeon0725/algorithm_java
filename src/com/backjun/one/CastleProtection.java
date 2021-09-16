package com.backjun.one;

import java.util.Arrays;
import java.util.Scanner;

public class CastleProtection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int column = sc.nextInt();
        int[] rArr = new int[row];
        int[] cArr = new int[column];
        int left = 0;

        for (int r=0; r<row; r++) {
            String[] space = sc.next().split("");

            for (int c=0; c<column; c++) {
                if ("X".equals(space[c])) {
                    rArr[r] = 1;
                    cArr[c] = 1;
                }
            }
        }
        System.out.println(Math.max(Arrays.stream(rArr).filter(s -> s == 0).count(), Arrays.stream(cArr).filter(s -> s == 0).count()));
    }
}
