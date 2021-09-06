package com.backjun.one;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BlackJack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        int capacity = sc.nextInt();
        int[] arr = new int[len];

        for (int i=0; i<len; i++)
            arr[i] = sc.nextInt();

        System.out.println(solution(arr, capacity));

    }

    public static int solution(int[] arr, int capacity) {
        int max = Integer.MIN_VALUE;

        // 두 수의 합
        for (int i=0; i<arr.length-2; i++) {
            for (int j=i+1; j<arr.length-1; j++) {
                for (int k=j+1; k<arr.length; k++) {

                    if (max < arr[i] + arr[j] + arr[k] && arr[i] + arr[j] + arr[k] <= capacity)
                        max = arr[i] + arr[j] + arr[k];

                }
            }
        }

        return max;
    }
}
