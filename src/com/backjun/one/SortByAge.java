package com.backjun.one;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SortByAge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        Integer[][] data = new Integer[len][];
        Map<Integer, String> names = new HashMap<>();

        for (int i=0; i<data.length; i++){
            data[i] = new Integer[]{i, sc.nextInt()};
            names.put(i, sc.next());
        }

        Arrays.sort(data, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        for (int i=0; i<data.length; i++) {
            System.out.println(data[i][1] + " " + names.get(data[i][0]));
        }
    }
}
