package com.backjun.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NumberSort3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<len; i++) {
            arr[Integer.parseInt(br.readLine())]++;
        }

        for (int i=0; i<arr.length; i++)
            for (int j=0; j<arr[i]; j++)
                sb.append(i).append("\n");

        System.out.println(sb.toString());
    }
}
