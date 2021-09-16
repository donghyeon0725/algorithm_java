package com.backjun.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class KthNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        int len = Integer.parseInt(temp[0]);
        int order = Integer.parseInt(temp[1]);
        int[] arr = new int[len];

        String[] line = br.readLine().split(" ");

        for (int i=0; i<len; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }

        Arrays.sort(arr);

        System.out.println(arr[order - 1]);
    }

    // 실패
    public static int quickSelect(int[] arr, int start, int end, int find) {

        int l = start + 1;
        int r = end;

        int p = arr[start];

        while (l <= r) {

            while (l <= end && arr[l] <= p) {
                l++;
            }

            while (r >= start && arr[r] > p) {
                r--;
            }

            // 피벗이 엇갈린 경우
            if (l >= r) {
                int t = arr[start];
                arr[start] = arr[r];
                arr[r] = t;
            } else {
                int t = arr[l];
                arr[l] = arr[r];
                arr[r] = t;
            }
        }

        if (r < find - 1) {
            return quickSelect(arr, r + 1, end, find);
        } else if (r > find - 1) {
            return quickSelect(arr, start, r - 1, find);
        } else {
            return p;
        }

    }
}
