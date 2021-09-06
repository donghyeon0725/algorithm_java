package com.backjun.one;

import java.util.Scanner;

public class Scale {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[8];
        int index = 0;

        while (sc.hasNext()) {
            arr[index++] = sc.nextInt();
        }

        System.out.println(solution(arr));
    }
    public static String solution(int[] arr) {
        for (int i=0; i<arr.length - 1; i++) {

            if (Math.abs(arr[i] - arr[i + 1]) != 1)
                return "mixed";
        }

        if (arr[1] - arr[0] == 1)
            return "ascending";
        else
            return "descending";
    }
}
