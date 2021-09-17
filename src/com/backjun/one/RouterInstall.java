package com.backjun.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RouterInstall {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String temp = br.readLine();
        int len = Integer.parseInt(temp.split(" ")[0]);
        int router = Integer.parseInt(temp.split(" ")[1]);
        int[] homes = new int[len];

        for (int i=0; i<homes.length; i++) {
            homes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(homes);

        int interval = homes[homes.length - 1] + homes[0];
        int left = 1, right = interval;
        while (left <= right) {
            int last = 0, count = 1;

            for (int i=1; i<homes.length; i++) {
                if (homes[i] - homes[last] >= interval) {
                    last = i;
                    count++;
                }
            }

            // 아직 더 큰 범위 탐색 가능
            if (count >= router) {
                left = interval + 1;
            } else if (count < router) {
                right = interval - 1;
            }
            interval = ( left + right ) / 2;
        }

        System.out.println(interval);
    }
}
