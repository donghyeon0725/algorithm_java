package com.backjun.one;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        long[] arr = new long[46];
        arr[0] = 0;
        arr[1] = 1;

        final int len = new Scanner(System.in).nextInt();

        for (int i=2; i<=len; i++)
            if (arr[i] == 0)
                arr[i] = arr[i - 1] + arr[i - 2];

        System.out.println(arr[len]);

    }
}
