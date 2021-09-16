package com.backjun.one;

import java.util.Scanner;

public class TropiExhibition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        int max = 0;
        int right = 0, left = 0;
        int[] tropi = new int[len];

        for (int i=0; i<len; i++) {
            tropi[i] = sc.nextInt();
        }

        for (int i=0; i<tropi.length; i++) {
            if (tropi[i] > max) {
                max = tropi[i];
                left++;
            }
        }

        max = 0;
        for (int i=tropi.length - 1; i>=0; i--) {
            if (tropi[i] > max) {
                max = tropi[i];
                right++;
            }
        }

        System.out.println(left);
        System.out.println(right);
    }
}
