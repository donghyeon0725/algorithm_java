package com.backjun.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NumberSort2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] arr = new int[len];
        int index = 0;

        for (int i=0; i<len; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<arr.length; i++)
            sb.append(arr[i] + "\n");

        System.out.println(sb.toString());
    }
}
