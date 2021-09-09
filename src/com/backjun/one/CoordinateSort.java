package com.backjun.one;

import java.util.Arrays;
import java.util.Scanner;

public class CoordinateSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        Integer[][] data = new Integer[len][2];

        for (int i=0; i<len; i++) {
            data[i][0] = sc.nextInt();
            data[i][1] = sc.nextInt();
        }


        Arrays.sort(data, (a, b) -> {
            if (a[0].equals(b[0]))
                return a[1] - b[1];
            else
                return a[0] - b[0];
        });

        Arrays.stream(data).forEach(s-> System.out.println(s[0] + " " + s[1]));
    }
}
